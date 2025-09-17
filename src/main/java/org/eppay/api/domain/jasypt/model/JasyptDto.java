package org.eppay.api.domain.jasypt.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.eppay.api.domain.store.model.StoreEntity;

@Data
public class JasyptDto {
    @Data
    public static class Common {

    }

    @Data
    public static class SearchRequest {
        private String text;
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class CreateRequest extends Common {
        private Long id;
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class UpdateRequest extends Common {
        private Long id;

        private Long test;
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Response extends Common {
        private Long id;
    }

    @Data
    public static class DeleteRequest {
        private Long id;
    }

}