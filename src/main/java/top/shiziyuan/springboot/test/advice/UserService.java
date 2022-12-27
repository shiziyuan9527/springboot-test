package top.shiziyuan.springboot.test.advice;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Override
    public void test() {
        System.out.println("test!");
    }
}
