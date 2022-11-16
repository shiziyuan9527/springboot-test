package top.shiziyuan.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.shiziyuan.springboot.domain.FileMeta;

@Service
public class FileService {

    public String uploadFile(FileMeta meta, MultipartFile file) {
        return "ok";
    }
}
