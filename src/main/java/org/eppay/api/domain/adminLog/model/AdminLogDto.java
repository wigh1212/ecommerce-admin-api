package org.eppay.api.domain.adminLog.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
public class AdminLogDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {
        private String description;
        private String ip;
        private String path;
        private String param;

        public AdminLogEntity toEntity(Long id) {
            return AdminLogEntity.builder()
                    .id(id)
                    .description(this.description)
                    .ip(this.ip)
                    .path(this.path)
                    .param(this.param)
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

        public AdminLogEntity toEntity() {
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

        public AdminLogEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;

        public static Response fromEntity(AdminLogEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .description(entity.getDescription())
                    .ip(entity.getIp())
                    .path(entity.getPath())
                    .param(entity.getParam())
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

        public AdminLogEntity toEntity() {
            return super.toEntity(id);
        }
    }
}