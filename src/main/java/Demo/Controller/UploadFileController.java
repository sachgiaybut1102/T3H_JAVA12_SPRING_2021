package Demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/uploadfile")
public class UploadFileController {
    @Autowired
    ServletContext servletContext;

    @GetMapping
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("filename", "none1.png");
        return "home";
    }

    @PostMapping
    public String uploadFile(@RequestParam("file") CommonsMultipartFile file) {
        String nameFile = file.getOriginalFilename();
        System.out.println(nameFile);
        System.out.println("path");
        //System.out.println(request.getContextPath());

        if (!nameFile.equals("")) {
            String dirFile = servletContext.getRealPath("/" + "resources\\images\\");

            File fileDir = new File(dirFile);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }

            try {
                file.transferTo(new File(fileDir + File.separator + nameFile));
                System.out.println("Add image succesed ^^!");

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Add image falied!!");
            }
            System.out.println(fileDir);
        }
        return "home";
    }
}
