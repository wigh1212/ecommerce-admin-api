package org.eppay.api.domain.storeProductOptionRel.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;

import java.util.List;

public class StoreProductOptionRelDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {

        @NotNull(message = "storeId는 필수 입니다.")
        private Long storeId;
        private Long storeProductId;
        private Long storeProductOptionId;

        public StoreProductOptionRelEntity toEntity(Long id) {
            return StoreProductOptionRelEntity.builder()
                    .id(id)
                    .storeId(this.storeId)
                    .storeProductId(this.storeProductId)
                    .storeProductOptionId(this.storeProductOptionId)
                    .build();
        }
    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class SearchRequest {

        private Long storeProductId;
        private Long storeProductOptionId;
    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class CreateRequest {
        private Long id;
        private Long storeProductId;
        private Long storeProductOptionId;

    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        public StoreProductOptionRelEntity toEntity() {
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
        public static Response fromEntity(StoreProductOptionRelEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .storeId(entity.getStoreId())
                    .storeProductId(entity.getStoreProductId())
                    .storeProductOptionId(entity.getStoreProductOptionId())
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

        public StoreProductOptionRelEntity toEntity() {
            return super.toEntity(id);
        }
    }

}