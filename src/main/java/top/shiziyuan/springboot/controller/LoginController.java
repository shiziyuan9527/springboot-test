package top.shiziyuan.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shiziyuan.springboot.service.LoginService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("login")
    public void login(HttpServletRequest request) {
        loginService.login(request);
    }
}
