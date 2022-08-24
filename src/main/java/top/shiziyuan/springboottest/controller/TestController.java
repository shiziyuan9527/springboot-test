package top.shiziyuan.springboottest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shiziyuan.springboottest.domain.Cat;
import top.shiziyuan.springboottest.domain.Person;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private Cat cat;
    // 只有有参构造器注入 ？？

    @Resource
    private Person person;

    @GetMapping("/cat")
    public Cat getPet() {
        return cat;
    }

    @GetMapping("/person")
    public Person getPerson() {
        return person;
    }
}
