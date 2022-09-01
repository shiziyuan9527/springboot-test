package top.shiziyuan.springboottest.controller;

import io.minio.*;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.shiziyuan.springboottest.dto.FileDTO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/minio")
@Slf4j
public class MinioController {

    @Resource
    private MinioClient minioClient;

    @Value("${minio.bucket}")
    private String bucketName;

    @GetMapping("/list")
    public List<FileDTO> list() throws Exception {
        Iterable<Result<Item>> myObjects = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).build());
        Iterator<Result<Item>> iterator = myObjects.iterator();
        List<FileDTO> items = new ArrayList<>();
        while (iterator.hasNext()) {
            Item item = iterator.next().get();
            FileDTO dto = new FileDTO();
            dto.setId((String) JSON.parse(item.etag()));
            dto.setSize(item.size());
            dto.setName(item.objectName());
            items.add(dto);
        }
        return items;
    }

    @PostMapping("/download/{fileName}")
    public String download(@PathVariable String fileName, HttpServletResponse response) {
        InputStream io = null;
        try {
            StatObjectResponse stat = minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).build());
            response.setContentType(stat.contentType());
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            io = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).build());
            IOUtils.copy(io, response.getOutputStream());
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return "ok";
    }

    @PostMapping("/delete/{fileName}")
    public String delete(@PathVariable String fileName) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(fileName).build());
        } catch (Exception e) {
            log.error(e.getMessage());
            return "fail";
        }
        return "ok";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam(name = "file", required = false) MultipartFile[] files) {
        if (files == null || files.length == 0) {
            return "fail, param warn.";
        }

        List<String> fileNames = new ArrayList<>(files.length);
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            fileNames.add(originalFilename);
            try {
                InputStream in = file.getInputStream();
                minioClient.putObject(PutObjectArgs
                        .builder()
                        .bucket(bucketName)
                        .object(originalFilename)
                        .stream(in, file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build());
            } catch (Exception e) {
                log.error(e.getMessage());
                return "upload fail.";
            }
        }
        System.out.println(fileNames);
        return "ok";
    }
}
