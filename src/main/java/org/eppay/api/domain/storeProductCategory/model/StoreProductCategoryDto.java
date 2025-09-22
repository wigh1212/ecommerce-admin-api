package org.eppay.api.domain.storeProductCategory.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eppay.api.domain.storeProductMapCategory.model.StoreProductMapCategoryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreProductCategoryDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {

        @NotNull(message = "storeId는 필수 입니다.")
        private Long storeId;
        private String name;
        private String description;
        private Long parentId;

        public StoreProductCategoryEntity toEntity(Long id) {
            return StoreProductCategoryEntity.builder()
                    .id(id)
                    .storeId(this.storeId)
                    .name(this.name)
                    .description(this.description)
                    .parentId(this.parentId)
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

        public StoreProductCategoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        public StoreProductCategoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;
        private List<StoreProductMapCategoryDto.Response> storeProductMapCategoryList;
        public static Response fromEntity(StoreProductCategoryEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .storeId(entity.getStoreId())
                    .name(entity.getName())
                    .description(entity.getDescription())
                    .parentId(entity.getParentId())
                    .storeProductMapCategoryList(entity.getStoreProductMapCategoryList().stream().map(StoreProductMapCategoryDto.Response::fromEntity).collect(Collectors.toList()))
                    .build();

        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    public static class DeleteRequest extends Common{
        private Long id;
    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    public static class Custom extends Common {
        private Long id;

        public StoreProductCategoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

}