package com.liquors.file.application;

import com.liquors.file.application.images.ImageUploadApplication;
import com.liquors.file.application.images.process.ImageUploadProcess;
import com.liquors.file.domain.service.UploadImageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanModuleApplication {


  @Bean
  public ImageUploadApplication imageUploadApplication(UploadImageService uploadImageService,
      ImageUploadProcess imageUploadProcess) {
    return new ImageUploadApplication(uploadImageService, imageUploadProcess);
  }

  @Bean
  public ImageUploadProcess imageUploadProcess() {
    return new ImageUploadProcess();
  }

}
