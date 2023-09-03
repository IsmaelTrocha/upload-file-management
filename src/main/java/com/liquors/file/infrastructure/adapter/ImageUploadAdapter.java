package com.liquors.file.infrastructure.adapter;

import com.liquors.file.domain.entity.ImageUpload;
import com.liquors.file.domain.service.UploadImageService;
import com.liquors.file.infrastructure.repository.ImageUploadDto;
import com.liquors.file.infrastructure.repository.ImageUploadRepository;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageUploadAdapter implements UploadImageService {

  private static final long MAX_FILE_SIZE = 6 * 1024 * 1024;

  @Value("${upload.path}")
  private String path;
  private final ImageUploadRepository imageUploadRepository;

  @Override
  public ImageUpload saveImage(MultipartFile imageUpload) {
    ImageUpload imageUpload1 = new ImageUpload();
    try {
      String fileName = imageUpload.getOriginalFilename();
      byte[] bytes = imageUpload.getBytes();

      validFile(imageUpload);
      validFileMaxSize(imageUpload);

      File folder = new File(path);
      existsFolder(folder.getPath());

      Path paths = Paths.get(path + fileName);

      Files.write(paths, bytes);
      imageUpload1.setName(fileName);
      imageUpload1.setResource(path + fileName);
      ImageUploadDto image = new ImageUploadDto();
      image.setName(imageUpload1.getName());
      image.setResource(imageUpload1.getResource());
      imageUploadRepository.save(image);
    } catch (Exception exception) {
      throw new RuntimeException(exception.getMessage());
    }
    return imageUpload1;
  }

  private static void validFile(MultipartFile multipartFile) {
    if (multipartFile.getName().endsWith(".jpg")) {
      throw new RuntimeException("File must end with .jpg , jpeg or .png, please send a valid File.");
    }
  }

  private static void validFileMaxSize(MultipartFile multipartFile) {
    if (multipartFile.getSize() > MAX_FILE_SIZE) {
      throw new RuntimeException("File size must be less than 6MB");
    }
  }

  private static void existsFolder(String path) {
    File folder = new File(path);
    if (!folder.exists()) {
      folder.mkdirs();
    }
  }

  public ResponseEntity<Resource> getImage(String imageName) {
    try {
      Path imagePath = Paths.get("src/main/resources/images/" + imageName);
      Resource resource = new UrlResource(imagePath.toUri());

      if (resource.exists()) {
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(resource);
      } else {
        return ResponseEntity.notFound().build();
      }
    } catch (Exception exception) {
      throw new RuntimeException(exception.getMessage());
    }
  }

}
