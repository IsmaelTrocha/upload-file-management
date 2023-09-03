package com.liquors.file.application.images;

import com.liquors.file.domain.entity.ImageUpload;
import com.liquors.file.domain.service.UploadImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
public class ImageUploadApplication {

  private final UploadImageService uploadService;

  public ImageUpload imageUpload(MultipartFile multipartFile) {
    return uploadService.saveImage(multipartFile);
  }
}
