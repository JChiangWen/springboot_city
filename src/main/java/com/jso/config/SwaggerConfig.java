package com.jso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket buildDocket(){
        /*swagger3*/
        return new Docket(DocumentationType.OAS_30).apiInfo(buildApiInfo())
                .select()       //创建ApiSelectorBuilder对象
                .apis(RequestHandlerSelectors.basePackage("com.jso.controller"))
                .paths(PathSelectors.any())
                .build();
        /*swagger2*/
        /*return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInfo())
                .select()       //创建ApiSelectorBuilder对象
                .apis(RequestHandlerSelectors.basePackage("com.jso.controller"))
                .paths(PathSelectors.any())
                .build();*/
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger接口测试")   //标题
                .description("Test")    //说明
                .termsOfServiceUrl("http://www.baidu.com")  //服务规范url
                .contact(new Contact("jso","www.dapaodewangzhan.top","707546728@qq.com"))   //作者信息
                .version("1.0") //版本号
                .build();       //构建
    }
}
