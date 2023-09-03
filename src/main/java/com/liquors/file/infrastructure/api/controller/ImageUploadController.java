package com.liquors.file.infrastructure.api.controller;

import com.liquors.file.application.images.ImageUploadApplication;
import com.liquors.file.domain.entity.ImageUpload;
import com.liquors.file.infrastructure.adapter.ImageUploadAdapter;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/images")
@AllArgsConstructor
public class ImageUploadController {

  private final ImageUploadApplication imageUploadApplication;
  private final ImageUploadAdapter imageUploadAdapter;

  @PostMapping("/upload")
  public ResponseEntity<ImageUpload> uploadImage(
      @RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
    return new ResponseEntity<>(imageUploadApplication.imageUpload(multipartFile),
        HttpStatus.CREATED);
  }


  @GetMapping("/{imageName}")
  public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
    return imageUploadAdapter.getImage(imageName);
  }

}
