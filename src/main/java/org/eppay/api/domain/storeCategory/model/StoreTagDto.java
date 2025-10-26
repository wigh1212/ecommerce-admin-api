package org.eppay.api.domain.storeCategory.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eppay.api.domain.category.model.TagEntity;

public class StoreTagDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {
        @NotBlank(message = "가맹점 id 오류.")
        private Long storeId;
        @NotBlank(message = "태그 id 오류.")
        private Long tagId;
        private String tagName;

        public StoreTagEntity toEntity(Long id) {
            return StoreTagEntity.builder()
                    .id(id)
                    .tagId(this.tagId)
                    .storeId(this.storeId)
                    .tagName(this.tagName)
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

        public StoreTagEntity toEntity() {
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

        public StoreTagEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;

        public static Response fromEntity(StoreTagEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .tagId(entity.getTagId())
                    .storeId(entity.getStoreId())
                    .tagName(entity.getTagName())
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
        public static CustomResponse fromEntity(TagEntity entity) {
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
        private Long tegId;
        private Long storeId;
    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Custom extends Common {
        private Long id;

        public StoreTagEntity toEntity() {
            return super.toEntity(id);
        }
    }

}