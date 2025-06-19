package org.eppay.api.domain.store.model;

import lombok.Data;

@Data
public class StoreDto {
    @Data
    public static class Common {
        private String name;
        private String businessNumber;
        private String phone;
        private String email;
        private String address;
        private String image;
        private String status;

        public StoreEntity toEntity(Long id) {
            return StoreEntity.builder()
                    .id(id)
                    .name(this.name)
                    .businessNumber(this.businessNumber)
                    .phone(this.phone)
                    .email(this.email)
                    .address(this.address)
                    .image(this.image)
                    .status(this.status)
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

        public StoreEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class UpdateRequest extends Common {
        private Long id;

        private Long test;

        public StoreEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class Response extends Common {
        private Long id;

        public static Response fromEntity(StoreEntity entity) {
            Response response = new Response();
            response.setId(entity.getId());
            response.setName(entity.getName());
            response.setAddress(entity.getAddress());
            response.setBusinessNumber(entity.getBusinessNumber());
            response.setEmail(entity.getEmail());
            response.setImage(entity.getImage());
            response.setPhone(entity.getPhone());
            response.setStatus(entity.getStatus());
            return response;
        }
    }

    @Data
    public static class DeleteRequest {
        private Long id;
    }


    @Data
    public static class Custom extends Common {
        private Long id;

        public StoreEntity toEntity() {
            return super.toEntity(id);
        }
    }

}