package org.eppay.api.domain.user.model;

import lombok.Data;

@Data
public class UserDto {
    @Data
    public static class Common {
        private String userName;
        private String password;
        private String name;
        private String phone;
        private String address;
        private String addressDetail;
        private String zipCode;
        private String email;

        public UserEntity toEntity(Long id) {
            return UserEntity.builder()
                    .id(id)
                    .name(this.name)
                    .userName(this.userName)
                    .password(this.password)
                    .phone(this.phone)
                    .email(this.email)
                    .address(this.address)
                    .addressDetail(this.addressDetail)
                    .zipCode(this.zipCode)
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

        public UserEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class UpdateRequest extends Common {
        private Long id;

        public UserEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class Response {
        private Long id;
        private String name;
        private String phone;
        private String address;
        private String addressDetail;
        private String zipCode;
        private String email;
        public static Response fromEntity(UserEntity entity) {
            Response response = new Response();
            response.setId(entity.getId());
            response.setName(entity.getName());
            response.setAddress(entity.getAddress());
            response.setZipCode(entity.getZipCode());
            response.setAddressDetail(entity.getAddressDetail());
            response.setPhone(entity.getPhone());
            response.setEmail(entity.getEmail());
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

        public UserEntity toEntity() {
            return super.toEntity(id);
        }
    }

}