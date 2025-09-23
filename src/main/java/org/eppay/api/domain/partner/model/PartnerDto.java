package org.eppay.api.domain.partner.model;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

public class PartnerDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {
        private String name;
        private String address;
        private String addressDetail;
        private String memo;
        private boolean status;

        public PartnerEntity toEntity(Long id) {
            return PartnerEntity.builder()
                    .id(id)
                    .name(this.name)
                    .status(this.status)
                    .memo(this.memo)
                    .address(this.address)
                    .addressDetail(this.addressDetail)
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

        public PartnerEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class UpdateRequest extends Common {
        private Long id;

        public PartnerEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;
        public static Response fromEntity(PartnerEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .status(entity.isStatus())
                    .memo(entity.getMemo())
                    .address(entity.getAddress())
                    .addressDetail(entity.getAddressDetail())
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

        public PartnerEntity toEntity() {
            return super.toEntity(id);
        }
    }

}