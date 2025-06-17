package org.eppay.api.domain.admin.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdminDto {
    @Data
    public static class Common {
        private String userName;
        private String name;
        private String password;
        private String type;

        public AdminEntity toEntity(Long id) {
            return AdminEntity.builder()
                    .id(id)
                    .userName(this.getUserName())
                    .name(this.getName())
                    .password(this.getPassword())
                    .type(this.getType())
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

        public AdminEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class UpdateRequest extends Common {
        private Long id;

        private Long test;

        public AdminEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class Response extends Common {
        private Long id;

        public static Response fromEntity(AdminEntity entity) {
            Response response = new Response();
            response.setId(entity.getId());
            response.setUserName(entity.getUsername());
            response.setName(entity.getName());
            response.setPassword(entity.getPassword());
            response.setType(entity.getType());
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

        public AdminEntity toEntity() {
            return super.toEntity(id);
        }
    }
}