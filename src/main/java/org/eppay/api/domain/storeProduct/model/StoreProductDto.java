package org.eppay.api.domain.storeProduct.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelDto;
import org.eppay.api.domain.storeProductOptionRel.model.StoreProductOptionRelDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StoreProductDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {

        @NotNull(message = "storeId는 필수 입니다.")
        private Long storeId;
        private String name;
        private BigDecimal amount;
        private String image;
        private String info;
        @Builder.Default
        private boolean status=true;
        @Builder.Default
        private boolean existCategory=false;

        public StoreProductEntity toEntity(Long id) {
            return StoreProductEntity.builder()
                    .id(id)
                    .storeId(this.storeId)
                    .name(this.name)
                    .amount(this.amount)
                    .image(this.image)
                    .info(this.info)
                    .status(this.status)
                    .build();
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class SearchRequest extends Common {
        private Long id;
        private Long storeProductCategoryId;
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class CreateRequest extends Common {
        private Long id;

        public StoreProductEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        public StoreProductEntity toEntity() {
            return super.toEntity(id);
        }
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;
        private List<StoreProductOptionRelDto.Response> storeProductOptionRelList;
        public static Response fromEntity(StoreProductEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .storeId(entity.getStoreId())
                    .name(entity.getName())
                    .amount(entity.getAmount())
                    .image(entity.getImage())
                    .info(entity.getInfo())
                    .status(entity.isStatus())
                    .storeProductOptionRelList(entity.getStoreProductOptionRelList()!=null? entity.getStoreProductOptionRelList().stream().map(StoreProductOptionRelDto.Response::fromEntity).collect(Collectors.toList()):null)
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

        public StoreProductEntity toEntity() {
            return super.toEntity(id);
        }
    }

}