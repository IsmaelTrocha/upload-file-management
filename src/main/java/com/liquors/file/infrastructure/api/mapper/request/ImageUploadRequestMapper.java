package com.liquors.file.infrastructure.api.mapper.request;

import com.liquors.file.domain.entity.ImageUpload;
import com.liquors.file.infrastructure.api.dto.request.ImageUploadRequest;
import com.liquors.file.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ImageUploadRequestMapper extends EntityToDto<ImageUpload, ImageUploadRequest> {

}
