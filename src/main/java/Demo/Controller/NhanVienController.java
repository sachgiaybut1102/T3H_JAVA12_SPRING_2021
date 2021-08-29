package Demo.Controller;

import Demo.Model.NhanVien;
import Demo.Service.INhanVien;
import Demo.ViewModel.NhanVienViewModel;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/admin/nhanvien")
public class NhanVienController {
    @Autowired
    INhanVien iNhanVien;

    @RequestMapping(value = "index")
    public ModelAndView index(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
        System.out.println("pageNumber = " + pageNumber);
        ModelAndView modelAndView = new ModelAndView("NhanVien/index");

        //Xử lý phân trang sai khi thay đổi số lượng hiển thị
        int pageCount = iNhanVien.getCountPage(pageSize, keyword);
        pageNumber = pageNumber <= pageCount ? pageNumber : pageCount;

        modelAndView.addObject("items", iNhanVien.getByPage(pageNumber, pageSize, keyword));
        modelAndView.addObject("pageNumber", pageNumber);
        modelAndView.addObject("pageSize", pageSize);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("keyword", keyword);

        return modelAndView;
    }

    @RequestMapping(value = "add")
    public ModelAndView add() {
        String msg = "";

       /* if (model != null) {
            if (isSuccess) {
                msg = "Thêm mới nhân viên thành công!";
            } else {
                msg = "Có lỗi xảy ra, không thể thêm được nhân viên mới!";
            }
        }*/

        ModelAndView modelAndView = new ModelAndView("NhanVien/add");
        /* modelAndView.addObject("item",model);*/
        modelAndView.addObject("msg", msg);

        return modelAndView;
    }

    @RequestMapping(value = "addconfirmed", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addconfirmed(@Validated @ModelAttribute("info") NhanVien info, BindingResult result) {
        boolean isSucess = true;
        String redirect = "index";

        /* NhanVien model = initNhanVien(req);*/

        if (result.hasErrors()) {
            redirect = "add";
        } else {
            if (!iNhanVien.add(info)) {
                isSucess = false;
                redirect = "add";
            }
        }


        return new ModelAndView("redirect:/nhanvien/" + redirect);
    }

    @RequestMapping(value = "edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("NhanVien/edit");

        modelAndView.addObject("item", iNhanVien.getByID(id));

        return modelAndView;
    }

    @RequestMapping(value = "editconfirmed", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView editconfirmed(HttpServletRequest req) {
        String msg = "ok";

        NhanVien nhanVien = initNhanVien(req);

        if (!iNhanVien.update(nhanVien)) {
            return new ModelAndView("redirect:edit/" + nhanVien.getMaNv());
        }

        return new ModelAndView("redirect:index");
    }

    @RequestMapping(value = "addlist", method = RequestMethod.POST)
    @ResponseBody
    public String addList(HttpServletRequest req) {
        System.out.println("in");

        System.out.println(req.getParameter("json"));
        ObjectMapper mapper = new ObjectMapper();

        try {
            Map<String, Object> map = mapper.readValue(req.getParameter("json"), Map.class);
            System.out.println(map);

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println(entry.getValue());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping(value = "upLoad", method = RequestMethod.POST)
    public ModelAndView upLoad(@RequestParam("file") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView("upload");
        System.out.println("đã vào");
        saveFile(file);
        System.out.println("upload file!");
        return modelAndView;
    }

    private NhanVien initNhanVien(HttpServletRequest req) {
        NhanVien nhanVien = new NhanVien();

        nhanVien.setMaNv(parseInt(req.getParameter("maNv")));
        nhanVien.setTenNv(req.getParameter("tenNv"));
        try {
            nhanVien.setNgaySinh(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("ngaySinh")));
        } catch (Exception ex) {
            System.out.println("Convert DateTime error:");
            ex.printStackTrace();
        }
        nhanVien.setGioiTinh(parseBoolean(req.getParameter("gioiTinh")));
        nhanVien.setDiaChi(req.getParameter("diaChi"));
        nhanVien.setSdt(req.getParameter("sdt"));
        nhanVien.setEmail(req.getParameter("email"));

        return nhanVien;
    }

    private String saveFile(MultipartFile file) {
        String name = "";
        if (file != null && !file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String rootPath = System.getProperty("resources");

                File dir = new File(rootPath + "\\" + "img");

                if (!dir.exists()) {
                    System.out.println("not exits");
                    dir.mkdir();
                }

                Path source = Paths.get(this.getClass().getResource("\\").getPath());

                System.out.println("source: " + source.toAbsolutePath());
                // Path newFolder = Paths.get(source.toAbsolutePath() + "/newFolder/");
                //Files.createDirectories(newFolder);


                name = String.valueOf(new Date().getTime() + ".jpg");

                File serverFile = new File(dir.getAbsoluteFile() + "\\" + name);

                System.out.println(serverFile.getPath());

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return name;
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<NhanVienViewModel> getAll() {
        return iNhanVien.getAll();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> test() {
        Map<String, Object> map = new LinkedHashMap<>();

        map.put("test01", "ádasdasdas");
        map.put("list", iNhanVien.getAll());

        return map;
    }
}
