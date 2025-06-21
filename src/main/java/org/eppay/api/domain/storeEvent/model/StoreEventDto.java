package org.eppay.api.domain.storeEvent.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StoreEventDto {
    @Data
    public static class Common {

        @NotNull(message = "storeId는 필수 입니다.")
        private Long storeId;
        private String name;
        private String image;
        private String link;

        public StoreEventEntity toEntity(Long id) {
            return StoreEventEntity.builder()
                    .id(id)
                    .storeId(this.storeId)
                    .name(this.name)
                    .image(this.image)
                    .link(this.link)
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

        public StoreEventEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class UpdateRequest extends Common {
        private Long id;

        public StoreEventEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @Data
    public static class Response extends Common {
        private Long id;

        public static Response fromEntity(StoreEventEntity entity) {
            Response response = new Response();
            response.setId(entity.getId());
            response.setStoreId(entity.getStoreId());
            response.setName(entity.getName());
            response.setImage(entity.getImage());
            response.setLink(entity.getLink());
            return response;
        }
    }

    @Data
    public static class DeleteRequest extends Common{
        private Long id;
    }


    @Data
    public static class Custom extends Common {
        private Long id;

        public StoreEventEntity toEntity() {
            return super.toEntity(id);
        }
    }

}