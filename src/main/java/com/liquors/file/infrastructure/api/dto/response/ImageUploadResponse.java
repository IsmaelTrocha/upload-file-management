package com.liquors.file.infrastructure.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageUploadResponse {

  private Long id;
  private String name;
  private String resource;
  private Resource imgResource;
}
