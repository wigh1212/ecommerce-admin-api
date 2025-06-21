package org.eppay.api.domain.file.model;

import lombok.Data;
import org.eppay.api.domain.store.model.StoreEntity;

@Data
public class FileDto {
    private String name;
    private String contentType;
    private long size;
    private String originalFilename;

    private String imagePath;
}