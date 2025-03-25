package com.bee.moveData.service;

import com.bee.moveData.upload.MultipartInputResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;

@Service
public class Uploadfile {


    private final RestTemplate restTemplate = new RestTemplate();

    public String uploadImage(MultipartFile file) throws IOException {
        String phpUploadUrl = "http://10.0.1.129/biz_upload/upload.php"; // Change to your server URL

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Prepare the file data
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", new MultipartInputResource(file));

        // Create request entity
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // Send request
        ResponseEntity<String> response = restTemplate.postForEntity(phpUploadUrl, requestEntity, String.class);

        return response.getBody(); // Return PHP script response
    }
}
