package com.ouag.demo.config

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.servlet.config.annotation.{EnableWebMvc, ResourceHandlerRegistry, WebMvcConfigurer}
import springfox.documentation.builders.{ApiInfoBuilder, PathSelectors, RequestHandlerSelectors}
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
@EnableWebMvc
class SwaggerDocConfig extends WebMvcConfigurer {
  override def addResourceHandlers(registry: ResourceHandlerRegistry): Unit = {
    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/")
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
  }

  @Bean def apiDocket: Docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo).select.apis(RequestHandlerSelectors.basePackage("com.ouag.demo")).paths(PathSelectors.any).build

  private def getApiInfo = new ApiInfoBuilder().title("Swagger API Doc").description("More description about the API").version("1.0.0").build

}
