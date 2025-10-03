package org.eppay.api.domain.admin.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
public class AdminDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {
        private String userName;
        private String displayName;
        private String name;
        private String password;
        private String type;
        private Long storeId;
        @Builder.Default
        private boolean status=true;

        public AdminEntity toEntity(Long id) {
            return AdminEntity.builder()
                    .id(id)
                    .userName(this.getUserName())
                    .name(this.getName())
                    .password(this.getPassword())
                    .displayName(this.getDisplayName())
                    .storeId(this.getStoreId())
                    .type(this.getType())
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

        public AdminEntity toEntity() {
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

        public AdminEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;

        public static Response fromEntity(AdminEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .userName(entity.getUsername())
                    .name(entity.getName())
                    .displayName(entity.getDisplayName())
                    .storeId(entity.getStoreId())
                    .type(entity.getType())
                    .status(entity.isStatus())
                    .build();

        }
    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class DeleteRequest {
        private Long id;
        private Long storeId;
    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Custom extends Common {
        private Long id;

        public AdminEntity toEntity() {
            return super.toEntity(id);
        }
    }


    @Data
    public static class login {
        private String userName;
        private String password;
    }
}