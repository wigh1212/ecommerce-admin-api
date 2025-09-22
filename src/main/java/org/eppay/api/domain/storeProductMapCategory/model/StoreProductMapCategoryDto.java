package org.eppay.api.domain.storeProductMapCategory.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;

import java.util.List;

public class StoreProductMapCategoryDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {

        @NotNull(message = "storeId는 필수 입니다.")
        private Long storeId;
        private Long storeProductId;
        private Long storeProductCategoryId;

        public StoreProductMapCategoryEntity toEntity(Long id) {
            return StoreProductMapCategoryEntity.builder()
                    .id(id)
                    .storeId(this.storeId)
                    .storeProductId(this.storeProductId)
                    .storeProductCategoryId(this.storeProductCategoryId)
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

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class CreateRequest {
        private Long id;
        private Long storeProductCategoryId;
        private List<Long> storeProductIdList;

    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        public StoreProductMapCategoryEntity toEntity() {
            return super.toEntity(id);
        }
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;
        private StoreProductDto.Response storeProduct;
        public static Response fromEntity(StoreProductMapCategoryEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .storeId(entity.getStoreId())
                    .storeProductId(entity.getStoreProductId())
                    .storeProductCategoryId(entity.getStoreProductCategoryId())
                    .storeProduct(StoreProductDto.Response.fromEntity(entity.getStoreProduct()))
                    .build();

        }
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class DeleteRequest extends Common{
        private Long id;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Custom extends Common {
        private Long id;

        public StoreProductMapCategoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

}