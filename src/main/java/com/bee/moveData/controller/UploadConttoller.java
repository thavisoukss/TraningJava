package com.bee.moveData.controller;

import com.bee.moveData.service.Uploadfile;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadConttoller {
    @Autowired
    Uploadfile uploadfile;

//    public ImageUploadController(ImageUploadService imageUploadService) {
//        this.imageUploadService = imageUploadService;
//    }

    @PostMapping("/uploadImg")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            return uploadfile.uploadImage(file);
        } catch (IOException e) {
            return "Upload failed: " + e.getMessage();
        }
    }
}
