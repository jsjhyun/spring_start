package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // 메인 화면
    public String home() {
        return "home"; // home 뷰 resolver 렌더링
    }
}
