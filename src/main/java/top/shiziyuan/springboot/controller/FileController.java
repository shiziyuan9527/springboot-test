package top.shiziyuan.springboot.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.shiziyuan.springboot.domain.FileMeta;
import top.shiziyuan.springboot.service.FileService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("/upload/test")
    public String uploadFileTest(@RequestParam("request") String request, @RequestParam("file") MultipartFile file) {
        return "ok";
    }

    @PostMapping(value = "/upload")
    public String uploadFile(@RequestPart("request") FileMeta meta, @RequestParam("file") MultipartFile file) {
        return fileService.uploadFile(meta, file);
    }
}
