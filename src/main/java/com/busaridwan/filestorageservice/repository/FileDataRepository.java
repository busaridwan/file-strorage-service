package com.busaridwan.filestorageservice.repository;

import com.busaridwan.filestorageservice.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileData, Integer> {
}
