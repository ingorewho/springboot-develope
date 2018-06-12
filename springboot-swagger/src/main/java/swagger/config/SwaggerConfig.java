/**
 * 
 */
package swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ignore1992
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
	@Bean
	public Docket createDocket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(createApiInfo())
		.select()
		.apis(RequestHandlerSelectors.basePackage("swagger.api.controller"))
		.paths(PathSelectors.any())
		.build();
	}
	
	private ApiInfo createApiInfo()
	{
		return new ApiInfoBuilder()
							.title("springboot使用swagger2")
							.description("生成对应接口文档")
							.termsOfServiceUrl("https://blog.csdn.net/ignorewho")
							.contact("ignore1992")
							.version("1.0")
							.build();
	}
}
