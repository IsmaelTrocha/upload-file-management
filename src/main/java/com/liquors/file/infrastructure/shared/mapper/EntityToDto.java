package com.liquors.file.infrastructure.shared.mapper;

public interface EntityToDto <E,O>{

  O toDto(E e);
  E toEntity(O o);
}
