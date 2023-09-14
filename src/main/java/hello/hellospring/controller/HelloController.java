package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller // 컨트롤러
public class HelloController {

    @GetMapping("hello") // URL
    public String hello(Model model){ // model로 전달
        model.addAttribute("data", "hello!!"); // key, value 담아서
        return "hello"; // templates hello에 렌더링
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    // api
    @GetMapping("hello-string") // http://localhost:8080/hello-string?name=spring
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // HTTP의 BODY에 문자 내용을 직접 반환
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private  String name;

        public String getName(){ // 이름을 꺼낼 떄
            return name;
        }
        public void setName(String name) { // 이름을 넣을 떄
            this.name = name;
        }
    }
}
