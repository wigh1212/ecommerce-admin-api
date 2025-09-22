package org.eppay.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Comparator;
import java.util.List;

@OpenAPIDefinition(
        info = @Info(title = "이커머스 프로젝트 어드민 API 명세서",
                description = "이커머스 프로젝트 어드민 API 명세서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi chatOpenApi() {
//        String[] paths = {"/v1/**"};

        return GroupedOpenApi.builder()
                .group("이커머스 API v1")
                .pathsToMatch("/**")
                .packagesToScan("org.eppay.api")
                .build();
    }

    @Bean
    public OpenApiCustomizer sortTagsAlphabetically() {
        return openApi -> {
            List<Tag> tags = openApi.getTags();
            if (tags != null) {
                tags.sort(Comparator.comparing(Tag::getName));
            }
        };
    }
}
