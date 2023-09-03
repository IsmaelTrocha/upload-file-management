package com.liquors.file.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageUploadRepository extends JpaRepository<ImageUploadDto, Long> {

}
