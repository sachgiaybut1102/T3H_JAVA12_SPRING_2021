package Demo.Controller;

import Demo.Model.NhanVien;
import Demo.Service.INhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;

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

    private NhanVien initNhanVien(HttpServletRequest req) {
        NhanVien nhanVien = new NhanVien();

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
    public List<NhanVien> getAll() {
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
