package org.eppay.api.domain.store.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

public class StoreDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {
        private String name;
        private String businessNumber;
        private String ceo;
        private String phone;
        private String email;
        private String address;
        private String image;
        @Builder.Default
        private boolean status=true;

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

        public StoreEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        private Long test;

        public StoreEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;

        public static Response fromEntity(StoreEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .businessNumber(entity.getBusinessNumber())
                    .phone(entity.getPhone())
                    .email(entity.getEmail())
                    .address(entity.getAddress())
                    .image(entity.getImage())
                    .status(entity.isStatus())
                    .build();

        }
    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class DeleteRequest {
        private Long id;
    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Custom extends Common {
        private Long id;

        public StoreEntity toEntity() {
            return super.toEntity(id);
        }
    }

}