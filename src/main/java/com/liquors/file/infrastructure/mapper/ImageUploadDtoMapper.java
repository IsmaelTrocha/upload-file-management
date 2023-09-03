package com.liquors.file.infrastructure.mapper;

import com.liquors.file.domain.entity.ImageUpload;
import com.liquors.file.infrastructure.repository.ImageUploadDto;
import com.liquors.file.infrastructure.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ImageUploadDtoMapper extends EntityToDto<ImageUpload, ImageUploadDto> {

}
