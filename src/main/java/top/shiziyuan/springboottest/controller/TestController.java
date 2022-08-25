package top.shiziyuan.springboottest.controller;

import org.springframework.web.bind.annotation.*;
import top.shiziyuan.springboottest.domain.Cat;
import top.shiziyuan.springboottest.domain.Dog;
import top.shiziyuan.springboottest.domain.Person;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private Cat cat;

    @Resource
    private Dog dog;

    @Resource
    private Person person;

    @GetMapping("/cat")
    public Cat getPet() {
        return cat;
    }

    @GetMapping("/dog")
    public Dog getDog() {
        return dog;
    }

    @GetMapping("/person")
    public Person getPerson() {
        return person;
    }

    @GetMapping("/cat/{id}")
    public Map<String, String> testParam(@PathVariable("id") String id,
                                         @RequestHeader Map<String, String> headerMap,
                                         HttpSession session,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        response.setHeader("test", "setHeader");
        return headerMap;
    }
}
