package com.sakthi.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

    @RequestMapping(value = {"/{path:^(?!api|static|index\\.html|favicon\\.ico).*}", "/{path:^(?!api|static).*}/**"})
    public String redirect() {
        return "forward:/index.html";
    }
}
