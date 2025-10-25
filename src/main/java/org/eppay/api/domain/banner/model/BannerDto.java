package org.eppay.api.domain.banner.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
public class BannerDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {

        private String image;
        private String link;
        private String type;
        private boolean activate;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
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

        public BannerEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        public BannerEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response {
        private Long id;
        private String image;
        private String link;
        private String type;
        private boolean activate;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime applyAt;
        private String applyBy;
        public static Response fromEntity(BannerEntity entity) {

            return Response.builder()
                    .id(entity.getId())
                    .image(entity.getImage())
                    .link(entity.getLink())
                    .type(entity.getType())
                    .activate(entity.isActivate())
                    .applyAt(entity.getApplyAt())
                    .applyBy(entity.getApplyBy())
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

        public BannerEntity toEntity() {
            return super.toEntity(id);
        }
    }

}