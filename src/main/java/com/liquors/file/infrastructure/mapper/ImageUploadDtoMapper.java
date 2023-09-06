package com.liquors.file.infrastructure.mapper;

import com.liquors.file.domain.entity.ImageUpload;
import com.liquors.file.infrastructure.repository.ImageUploadDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ImageUploadDtoMapper {

  ImageUpload toEntity (ImageUploadDto imageUpload);


      ImageUploadDto toDto (ImageUpload imageUpload);
}
