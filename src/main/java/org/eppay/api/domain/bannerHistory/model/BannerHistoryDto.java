package org.eppay.api.domain.bannerHistory.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.eppay.api.domain.bannerHistory.model.BannerHistoryEntity;

import java.time.LocalDateTime;

@Data
public class BannerHistoryDto {
    @Data
    public static class Common {
        private Long bannerId;
        private String image;
        private String link;
        private String type;
        private boolean activate;

        public BannerHistoryEntity toEntity(Long id) {
            return BannerHistoryEntity.builder()
                    .id(id)
                    .bannerId(this.bannerId)
                    .image(this.image)
                    .link(this.link)
                    .type(this.type)
                    .activate(this.activate)
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

        public BannerHistoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class UpdateRequest extends Common {
        private Long id;

        public BannerHistoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class Response extends Common {
        private Long id;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdAt;
        private String createdBy;
        public static Response fromEntity(BannerHistoryEntity entity) {
            Response response = new Response();
            response.setId(entity.getId());
            response.setBannerId(entity.getBannerId());
            response.setImage(entity.getImage());
            response.setLink(entity.getLink());
            response.setType(entity.getType());
            response.setActivate(entity.isActivate());
            response.setCreatedAt(entity.getCreatedAt());
            response.setCreatedBy(entity.getCreatedBy());
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

        public BannerHistoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

}