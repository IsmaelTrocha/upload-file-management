package com.liquors.file.infrastructure.adapter;

import com.liquors.file.domain.entity.ImageUpload;
import com.liquors.file.domain.service.UploadImageService;
import com.liquors.file.infrastructure.mapper.ImageUploadDtoMapper;
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

  @Value("${upload.path}")
  private String path;
  private final ImageUploadRepository imageUploadRepository;
  private final ImageUploadDtoMapper imageUploadDtoMapper;

  @Override
  public ImageUpload saveImage(MultipartFile imageUpload) {
    ImageUpload imageUpload1 = new ImageUpload();
    try {
      String fileName = imageUpload.getOriginalFilename();
      byte[] bytes = imageUpload.getBytes();

      validFile(imageUpload);
      File folder = new File(path);
      existsFolder(folder.getPath());

      Path paths = Paths.get(path + fileName);

      Files.write(paths, bytes);
      imageUpload1.setName(fileName);
      imageUpload1.setResource(path + fileName);
      imageUploadRepository.save(imageUploadDtoMapper.toDto(imageUpload1));
    } catch (Exception exception) {
      throw new RuntimeException(exception.getMessage());
    }
    return imageUpload1;
  }

  private static void validFile(MultipartFile multipartFile) {
    if (multipartFile.getName().endsWith(".jpg")) {
      throw new RuntimeException(
          "File must end with .jpg , jpeg or .png, please send a valid File.");
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
