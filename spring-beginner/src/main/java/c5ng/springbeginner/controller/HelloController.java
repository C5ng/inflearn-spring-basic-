package c5ng.springbeginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") /* web app에서 /hello로 들어오면 아래 메서드를 호출 */
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    }
}
