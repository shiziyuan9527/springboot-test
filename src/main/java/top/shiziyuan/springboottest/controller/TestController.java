package top.shiziyuan.springboottest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shiziyuan.springboottest.domain.Cat;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    Cat cat;
    // 只有有参构造器注入 ？？

    @GetMapping("/cat")
    public Cat getPet() {
        return cat;
    }
}
