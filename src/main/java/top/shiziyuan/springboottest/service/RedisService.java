package top.shiziyuan.springboottest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {

    @Resource
    private RedisTemplate myRedisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    public String test(String text) {
        myRedisTemplate.opsForValue().set("test-key", text);
        return String.valueOf(myRedisTemplate.opsForValue().get("test-key"));
    }
}
