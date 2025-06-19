package org.eppay.api.domain.storeProduct.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
public class StoreProductDto {
    @Data
    public static class Common {

        @NotNull(message = "storeId는 필수 입니다.")
        private Long storeId;
        private String name;
        private double amount;
        private String image;
        private String info;

        public StoreProductEntity toEntity(Long id) {
            return StoreProductEntity.builder()
                    .id(id)
                    .storeId(this.storeId)
                    .name(this.name)
                    .amount(this.amount)
                    .image(this.image)
                    .info(this.info)
                    .build();
        }
    }

    @Data
    public static class SearchRequest extends Common {
        private Long id;
    }

    @Data
    public static class CreateRequest extends Common {
        private Long id;

        public StoreProductEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class UpdateRequest extends Common {
        private Long id;

        public StoreProductEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class Response extends Common {
        private Long id;

        public static Response fromEntity(StoreProductEntity entity) {
            Response response = new Response();
            response.setId(entity.getId());
            response.setStoreId(entity.getStoreId());
            response.setName(entity.getName());
            response.setImage(entity.getImage());
            response.setInfo(entity.getInfo());
            response.setAmount(entity.getAmount());
            return response;
        }
    }

    @Data
    public static class DeleteRequest extends Common{
        private Long id;
    }


    @Data
    public static class Custom extends Common {
        private Long id;

        public StoreProductEntity toEntity() {
            return super.toEntity(id);
        }
    }

}