package org.eppay.api.domain.banner.model;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BannerDto {
    @Data
    public static class Common {

        private String image;
        private String link;
        private String type;
        private String activate;
        private LocalDateTime applyAt;
        private String applyBy;

        public BannerEntity toEntity(Long id) {
            return BannerEntity.builder()
                    .id(id)
                    .image(this.image)
                    .link(this.link)
                    .type(this.type)
                    .activate(this.activate)
                    .applyAt(this.applyAt)
                    .applyBy(this.applyBy)
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

        public BannerEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class UpdateRequest extends Common {
        private Long id;

        public BannerEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class Response {
        private Long id;
        private String image;
        private String link;
        private String type;
        private String activate;
        private LocalDateTime applyAt;
        private String applyBy;
        public static Response fromEntity(BannerEntity entity) {
            Response response = new Response();
            response.setId(entity.getId());
            response.setImage(entity.getImage());
            response.setLink(entity.getLink());
            response.setType(entity.getType());
            response.setActivate(entity.getActivate());
            response.setApplyAt(entity.getApplyAt());
            response.setApplyBy(entity.getApplyBy());
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

        public BannerEntity toEntity() {
            return super.toEntity(id);
        }
    }

}