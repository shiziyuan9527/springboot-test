package top.shiziyuan.springboottest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.shiziyuan.springboottest.domain.FileMeta;

@Service
public class FileService {

    public String uploadFile(FileMeta meta, MultipartFile file) {
        return "ok";
    }
}
