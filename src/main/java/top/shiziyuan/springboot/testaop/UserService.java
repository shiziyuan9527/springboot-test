package top.shiziyuan.springboot.testaop;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    public void test() {
        System.out.println("UserService test!");
    }
}
