package top.shiziyuan.springboot.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Mail {
    private String from;
    private String to;
    private String subject;
    private String text;
    private MultipartFile file;
    private String filePath;
}
