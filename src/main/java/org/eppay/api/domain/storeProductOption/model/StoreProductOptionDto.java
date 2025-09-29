package org.eppay.api.domain.storeProductOption.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eppay.api.domain.storeProductOptionItem.model.StoreProductOptionItemDto;
import org.eppay.api.domain.storeProductOptionRel.model.StoreProductOptionRelDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StoreProductOptionDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {

        @NotNull(message = "storeId는 필수 입니다.")
        private Long storeId;
        private String name;
        @Builder.Default
        private boolean required=false;
        private int minSelectCount;
        private int maxSelectCount;
        @Builder.Default
        private boolean status=true;
        @Builder.Default
        private boolean existProduct=false;

        public StoreProductOptionEntity toEntity(Long id) {
            return StoreProductOptionEntity.builder()
                    .id(id)
                    .storeId(this.storeId)
                    .name(this.name)
                    .required(this.required)
                    .minSelectCount(this.minSelectCount)
                    .maxSelectCount(this.maxSelectCount)
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
        private Long storeProductId;
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class CreateRequest extends Common {
        private Long id;

        public StoreProductOptionEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        public StoreProductOptionEntity toEntity() {
            return super.toEntity(id);
        }
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;
        @Builder.Default
        private List<StoreProductOptionItemDto.Response> storeProductItemList=new ArrayList<>();
        public static Response fromEntity(StoreProductOptionEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .storeId(entity.getStoreId())
                    .name(entity.getName())
                    .required(entity.isRequired())
                    .minSelectCount(entity.getMinSelectCount())
                    .maxSelectCount(entity.getMaxSelectCount())
                    .status(entity.isStatus())
                    .storeProductItemList(entity.getStoreProductOptionItemList()!=null? entity.getStoreProductOptionItemList().stream().map(StoreProductOptionItemDto.Response::fromEntity).collect(Collectors.toList()) : null)
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

        public StoreProductOptionEntity toEntity() {
            return super.toEntity(id);
        }
    }

}