package com.busaridwan.filestorageservice.service;

import com.busaridwan.filestorageservice.entity.ImageData;
import com.busaridwan.filestorageservice.repository.ImageDataRepository;
import com.busaridwan.filestorageservice.util.ImageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageService {
    private final ImageDataRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
//                compress the image
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }


    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbImageData = repository.findByName(fileName);
//        decompress the image
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }


}
