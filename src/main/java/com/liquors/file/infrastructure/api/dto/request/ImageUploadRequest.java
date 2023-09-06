package com.liquors.file.infrastructure.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageUploadRequest {

  @Schema(name = "Campo de tipo texto para el nombre de la imagen que se va a ingresar en base de datos.",
      nullable = false)
  private String name;
  @Schema(name = "Campo de tipo texto para la ruta de la imagen que se va a ingresar en base de datos.",
      nullable = false)
  private String resource;

}
