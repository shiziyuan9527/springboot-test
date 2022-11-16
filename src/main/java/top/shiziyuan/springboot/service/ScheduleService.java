package top.shiziyuan.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

//    @Scheduled(cron = "0/2 * * * * ?")
    public void schedule() {
        System.out.println("schedule execute...");
    }
}
