package lab.springboot.example.conf;

import io.swagger.annotations.ApiOperation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

@Configuration
@EnableSwagger2
public class Swagger2Config extends WebMvcConfigurerAdapter {

	/**
	 * SpringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/
	 * resources/webjars/映射 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义（我没有尝试） 重写该方法需要
	 * extends WebMvcConfigurerAdapter
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public Docket createRestApi() {
		Predicate<RequestHandler> swaggerSelector = RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class);
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(swaggerSelector).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs").description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
				.termsOfServiceUrl("http://blog.didispace.com/").contact("liangchao.min").version("1.0").build();
	}
}