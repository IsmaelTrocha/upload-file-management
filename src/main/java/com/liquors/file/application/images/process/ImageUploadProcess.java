package com.liquors.file.application.images.process;

import com.liquors.file.shared.exception.message.file.FileSizeOutBoundsException;
import com.liquors.file.shared.exception.message.file.ImageRequiredException;
import com.liquors.file.shared.exception.message.file.ValidFileExtensionNameException;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
public class ImageUploadProcess {


  private static final long MAX_FILE_SIZE = 6 * 1024 * 1024;


  public void validateMultipartFile(MultipartFile multipartFile) {
    validFileExtensionName(multipartFile);
    validFileMaxSize(multipartFile);
    validFileIsNotEmpty(multipartFile);
  }

  private void validFileExtensionName(MultipartFile multipartFile) {
    boolean result =
        multipartFile.getOriginalFilename().endsWith(".jpg") || multipartFile.getOriginalFilename()
            .endsWith(".jpeg") || multipartFile.getOriginalFilename().endsWith(".png");

    if (!result) {
      throw new ValidFileExtensionNameException(
          "File must end with .jpg , jpeg or .png, please send a valid File.");
    }
  }

  private void validFileIsNotEmpty(MultipartFile multipartFile) {
    if (multipartFile.isEmpty()) {
      throw new ImageRequiredException("File is empty");
    }
  }

  private void validFileMaxSize(MultipartFile multipartFile) {
    if (multipartFile.getSize() > MAX_FILE_SIZE) {
      throw new FileSizeOutBoundsException("File size must be less than 6MB");
    }
  }

}
