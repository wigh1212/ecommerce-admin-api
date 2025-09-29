package org.eppay.api.domain.storeProductCategory.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelDto;

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
        @Builder.Default
        private boolean statue=true;

        public StoreProductCategoryEntity toEntity(Long id) {
            return StoreProductCategoryEntity.builder()
                    .id(id)
                    .storeId(this.storeId)
                    .name(this.name)
                    .description(this.description)
                    .status(this.statue)
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
        private List<StoreProductCategoryRelDto.Response> storeProductMapCategoryList;
        public static Response fromEntity(StoreProductCategoryEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .storeId(entity.getStoreId())
                    .name(entity.getName())
                    .description(entity.getDescription())
                    .statue(entity.isStatus())
                    .storeProductMapCategoryList(entity.getStoreProductCategoryRelList()!=null?  entity.getStoreProductCategoryRelList().stream().map(StoreProductCategoryRelDto.Response::fromEntity).collect(Collectors.toList()) : null)
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