package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(value="hello")
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/api.*"))
				.build()
				.apiInfo(apiInfo());
			
    }
    
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "SACA-CONFIG",
            "Configurações de ambiente do universo SACA.",
            "SACA-CONFIG",
            "l-scrum-roma@uolinc.com",
            "Time Roma",
            "API License URL", 
            ""
        );
        return apiInfo;
    }


}
