package com.liquors.file.domain.service;

import com.liquors.file.domain.entity.ImageUpload;
import org.springframework.web.multipart.MultipartFile;

public interface UploadImageService {

  ImageUpload saveImage(MultipartFile imageUpload);
}
