package org.eppay.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
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
                .addOpenApiCustomizer(openApi -> {
                    if (openApi.getComponents() == null) {
                        openApi.setComponents(new Components());
                    }

                    // Bearer JWT 설정 (Swagger UI의 Authorize 버튼에서 Bearer 입력 가능)
                    SecurityScheme jwtScheme = new SecurityScheme()
                            .name("Authorization")
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                            .in(SecurityScheme.In.HEADER);

                    openApi.getComponents().addSecuritySchemes("BearerAuth", jwtScheme);

                    SecurityRequirement securityRequirement = new SecurityRequirement();
                    securityRequirement.addList("BearerAuth");
                    openApi.addSecurityItem(securityRequirement);
                })
                .build();
    }

//    @Bean
//    public OpenApiCustomizer sortTagsAlphabetically() {
//        return openApi -> {
//            List<Tag> tags = openApi.getTags();
//            if (tags != null) {
//                tags.sort(Comparator.comparing(Tag::getName));
//            }
//        };
//    }

//    @Bean
//    public OpenApiCustomizer sortTagsWithLoginFirst() {
//        return openApi -> {
//            List<Tag> tags = openApi.getTags();
//            if (tags != null) {
//                tags.sort((t1, t2) -> {
//                    if ("어드민 로그인 API".equals(t1.getName())) return -1; // t1이 로그인 → 최상단
//                    if ("어드민 로그인 API".equals(t2.getName())) return 1;  // t2가 로그인 → 아래로
//                    return t1.getName().compareTo(t2.getName());  // 나머지는 알파벳순
//                });
//            }
//        };
//    }

}
