package org.eppay.api.domain.storeProductOption.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
        private final boolean status=true;

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

        public static Response fromEntity(StoreProductOptionEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .storeId(entity.getStoreId())
                    .name(entity.getName())
                    .required(entity.isRequired())
                    .minSelectCount(entity.getMinSelectCount())
                    .maxSelectCount(entity.getMaxSelectCount())
                    .status(entity.isStatus())
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