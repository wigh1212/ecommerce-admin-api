package org.eppay.api.domain.bannerHistory.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eppay.api.domain.bannerHistory.model.BannerHistoryEntity;

import java.time.LocalDateTime;

public class BannerHistoryDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
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

        public BannerHistoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        public BannerHistoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdAt;
        private String createdBy;
        public static Response fromEntity(BannerHistoryEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .bannerId(entity.getBannerId())
                    .image(entity.getImage())
                    .link(entity.getLink())
                    .type(entity.getType())
                    .activate(entity.isActivate())
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

        public BannerHistoryEntity toEntity() {
            return super.toEntity(id);
        }
    }

}