package com.liquors.file.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ImageUpload {

  private Long id;
  private String name;
  private String resource;

}
