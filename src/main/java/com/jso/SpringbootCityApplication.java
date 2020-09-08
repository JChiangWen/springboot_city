package com.jso;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi /*开启Swagger3*/
public class SpringbootCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCityApplication.class, args);
    }

}
