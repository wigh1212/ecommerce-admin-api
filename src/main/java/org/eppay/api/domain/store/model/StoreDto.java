package org.eppay.api.domain.store.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

public class StoreDto {
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Common {
        @NotBlank(message = "매장명은 필수 입력 항목입니다.")
        @Size(max = 50, message = "매장명은 50자 이하로 입력해야 합니다.")
        private String name;

//        @NotBlank(message = "사업자번호는 필수 입력 항목입니다.")
//        @Pattern(regexp = "\\d{10}", message = "사업자번호는 숫자 10자리 형식이어야 합니다.")
        private String businessNumber;

        @NotBlank(message = "대표자명은 필수 입력 항목입니다.")
        @Size(max = 30, message = "대표자명은 30자 이하로 입력해야 합니다.")
        private String ceo;

        @NotBlank(message = "전화번호는 필수 입력 항목입니다.")
        @Pattern(
                regexp = "^(01[0-9]|02|0[3-9][0-9])-?[0-9]{3,4}-?[0-9]{4}$",
                message = "전화번호 형식이 올바르지 않습니다."
        )
        private String phone;

        @NotBlank(message = "이메일은 필수 입력 항목입니다.")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        private String email;

        @NotBlank(message = "주소는 필수 입력 항목입니다.")
        private String address;

        @Pattern(
                regexp = "^http.*$",
                message = "이미지 URL 형식이 올바르지 않습니다."
        )
        private String image;
        @Builder.Default
        private boolean status=true;

        public StoreEntity toEntity(Long id) {
            return StoreEntity.builder()
                    .id(id)
                    .name(this.name)
                    .ceo(this.ceo)
                    .businessNumber(this.businessNumber)
                    .phone(this.phone)
                    .email(this.email)
                    .address(this.address)
                    .image(this.image)
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

        public StoreEntity toEntity() {
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

        public StoreEntity toEntity() {
            return super.toEntity(id);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Response extends Common {
        private Long id;

        public static Response fromEntity(StoreEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .ceo(entity.getCeo())
                    .businessNumber(entity.getBusinessNumber())
                    .phone(entity.getPhone())
                    .email(entity.getEmail())
                    .address(entity.getAddress())
                    .image(entity.getImage())
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

        public StoreEntity toEntity() {
            return super.toEntity(id);
        }
    }

}