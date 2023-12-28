package com.busaridwan.filestorageservice.repository;

import com.busaridwan.filestorageservice.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDataRepository extends JpaRepository<ImageData, Integer> {
}
