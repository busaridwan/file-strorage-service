package com.busaridwan.filestorageservice.repository;

import com.busaridwan.filestorageservice.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageDataRepository extends JpaRepository<ImageData, Integer> {
    Optional<ImageData> findByName(String fileName);
}
