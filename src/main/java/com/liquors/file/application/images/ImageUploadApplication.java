package com.liquors.file.application.images;

import com.liquors.file.application.images.process.ImageUploadProcess;
import com.liquors.file.domain.entity.ImageUpload;
import com.liquors.file.domain.service.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
public class ImageUploadApplication {

  private final UploadImageService uploadService;
  private final ImageUploadProcess imageUploadProcess;

  public ImageUpload imageUpload(MultipartFile multipartFile) {
    imageUploadProcess.validateMultipartFile(multipartFile);
    return uploadService.saveImage(multipartFile);
  }

}
