package top.shiziyuan.springboottest.controller;

import org.springframework.web.bind.annotation.*;
import top.shiziyuan.springboottest.domain.Cat;
import top.shiziyuan.springboottest.domain.Dog;
import top.shiziyuan.springboottest.domain.Person;
import top.shiziyuan.springboottest.producer.TestProducer;
import top.shiziyuan.springboottest.service.RedisService;
import top.shiziyuan.springboottest.service.TestService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {

    @Resource
    private Cat cat;
    @Resource
    private Dog dog;
    @Resource
    private Person person;
    @Resource
    private TestService testService;
    @Resource
    private RedisService redisService;
    @Resource
    private TestProducer testProducer;

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

    @PostMapping("/person")
    public Person getPerson1() {
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

    @GetMapping("/async")
    public String testAsync() {
        testService.asyncTask();
        return String.valueOf(new Random().nextInt());
    }

    @GetMapping("/redis")
    public String testRedis(@RequestParam String text) {
        return redisService.test(text);
    }

    @GetMapping("/send/msg")
    public void send() {
        testProducer.test();
    }
}
