package c5ng.springbeginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") /* web app에서 /hello로 들어오면 아래 메서드를 호출 */
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    /* ReqyestParam은 외부에서 name을 받아 우리가 선언한 name이라는 변수에 할당하겠다는 의미
    * RequestParam(String, requried = false) 이렇게 required 매개변수를 줘 false로 줄 수 있음
    * 다만 기본은 True */

    @GetMapping("hello-String")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }
    /* ResponseBody는 Http에서 header, body로 나뉘는데 body에 데이터를 직접 넣어주겠다는 의미 */

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    /* 객체가 온다면 Json 방식으로 리턴 (JsonConverter, StringConverter) */

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
