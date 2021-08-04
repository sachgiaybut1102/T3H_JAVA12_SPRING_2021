package Demo.Controller;

import Demo.Model.NhanVien;
import Demo.Service.INhanVien;
import Demo.ViewModel.NhanVienViewModel;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    INhanVien iNhanVien;

    @RequestMapping(value = "index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("NhanVien/index");

        return modelAndView;
    }

    @RequestMapping(value = "add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("NhanVien/add");

        return modelAndView;
    }

    @RequestMapping(value = "addconfirmed", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addconfirmed(HttpServletRequest req) {
        String msg = "ok";

        if (!iNhanVien.add(initNhanVien(req))) {
            return new ModelAndView("redirect:/nhanvien/add");
        }

        return new ModelAndView("redirect:/nhanvien/index");
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
