package org.eppay.api.domain.storeProductCategoryRel.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;

import java.util.List;

public class StoreProductCategoryRelDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {

        @NotNull(message = "가맹점 id 오류.")
        private Long storeId;
        @NotNull(message = "상품 id 오류")
        private Long storeProductId;
        @NotNull(message = "카테고리 id 오류")
        private Long storeProductCategoryId;

        public StoreProductCategoryRelEntity toEntity(Long id) {
            return StoreProductCategoryRelEntity.builder()
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
        private Long storeId;
        private Long storeProductCategoryId;
        private Long storeProductId;

    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        public StoreProductCategoryRelEntity toEntity() {
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
        public static Response fromEntity(StoreProductCategoryRelEntity entity) {
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

        public StoreProductCategoryRelEntity toEntity() {
            return super.toEntity(id);
        }
    }

}