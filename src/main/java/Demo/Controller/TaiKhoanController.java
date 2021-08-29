package Demo.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.SecurityContext;

@Controller
public class TaiKhoanController {
    @RequestMapping("/taikhoan/login")
    public ModelAndView login(@RequestParam(value = "error", required = false, defaultValue = "") String error) {
        ModelAndView modelAndView = new ModelAndView("TaiKhoan/login");

        modelAndView.addObject("error", error);

        return modelAndView;
    }

    @RequestMapping("taikhoan/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return new ModelAndView("redirect:login");
    }

    @RequestMapping("/admin/accessdeny")
    public ModelAndView accessdeny() {
        ModelAndView modelAndView = new ModelAndView("TaiKhoan/accessdeny");

        return modelAndView;
    }
}

