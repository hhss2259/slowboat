package slowboat.slowboat.controller.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    String getMain(){
        return "main";
    }

    @GetMapping("/category")
    String getCategory(){
        return "category";
    }

    @GetMapping("/myInfo")
    String getMyIfo(){
        return "myInfo";
    }


}
