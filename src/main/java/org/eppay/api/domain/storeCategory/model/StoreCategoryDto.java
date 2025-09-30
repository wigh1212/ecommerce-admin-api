package org.eppay.api.domain.storeCategory.model;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eppay.api.domain.category.model.CategoryEntity;

public class StoreCategoryDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {
        private Long storeId;
        private Long categoryId;
        private String categoryName;

        public StoreCategoryEntity toEntity(Long id) {
            return StoreCategoryEntity.builder()
                    .id(id)
                    .categoryId(this.categoryId)
                    .storeId(this.storeId)
                    .categoryName(this.categoryName)
                    .build();
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class SearchRequest extends Common {
        private Long id;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class CreateRequest extends Common {
        private Long id;

        public StoreCategoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        private Long test;

        public StoreCategoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;

        public static Response fromEntity(StoreCategoryEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .categoryId(entity.getCategoryId())
                    .storeId(entity.getStoreId())
                    .categoryName(entity.getCategoryName())
                    .build();

        }
    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class CustomResponse  {
        private Long id;
        private String name;
        private boolean exists;
        public static CustomResponse fromEntity(CategoryEntity entity) {
            return CustomResponse.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .build();

        }
    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class DeleteRequest {
        private Long id;
        private Long storeId;
    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Custom extends Common {
        private Long id;

        public StoreCategoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

}