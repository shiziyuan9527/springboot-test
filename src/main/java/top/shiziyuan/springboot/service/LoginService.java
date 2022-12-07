package top.shiziyuan.springboot.service;

import com.alibaba.fastjson.JSON;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.stereotype.Service;
import top.shiziyuan.springboot.domain.Pet;
import top.shiziyuan.springboot.domain.User;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {
    public void login(HttpServletRequest request) {
        User user = new User("oliver", "lyh", 25, new Pet());
        request.getSession().setAttribute("user", JSON.toJSONString(user));
        request.getSession().setAttribute("type", "test");
        request.getSession().setAttribute(FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME, "oliver");
    }
}
