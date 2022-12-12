package hubSideProject.hubApi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
	
	@Bean
    public Docket userApi() {	
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user")
                .select()
                .apis(RequestHandlerSelectors.basePackage("hubSideProject.hubApi.user.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
	
	@Bean
    public Docket postApi() {	
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("post")
                .select()
                .apis(RequestHandlerSelectors.basePackage("hubSideProject.hubApi.post.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HUB Project Api Dev Test")
                .description("Hub 사이드프로젝트 api 입니다.")
                .version("0.1")
                .build();
    }
}
