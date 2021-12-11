package com.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2     //开启swagger2
@Profile({"dev","test"})    //生产环境禁用swagger
public class SwaggerConfig {
    //配置Swagger的Docket的bean实例
    @Bean
    public Docket createRestApi(Environment environment) {

        //设置要显示Swagger的环境
//        Profiles profiles = Profiles.of("dev", "test");//开发环境和测试环境

        //判断是否处在自己设定的环境当中
//        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                //设置swagger基本信息
                .apiInfo(apiInfo())
                .groupName("龚志成")
//                .enable(flag)//是否启动swagger(默认启动)
                //配置扫描信息
                .select()
                //RequestHandlerSelectors 配置要扫描的接口的方式
                //basePackage   指定要扫描的包
                //any           扫描全部
                //none          不扫描
                //withClassAnnotation   扫描类上面的注解，参数是一个注解的反射信息
                //withMethodAnnotation  扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.controller"))
                //paths     过滤路径
                .paths(PathSelectors.any()) //扫描全部
//              .paths(PathSelectors.ant("/gzc/**"))    //只扫描gzc开头的接口
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("龚志成", "http://localhost:3306/info/hello", "gzc103@163.com");
        return new ApiInfoBuilder()
                .title("龚志成的接口文档")  //标题
                .contact(contact)       //作者
                .version("1.0")         //版本
                //描述
                .description("此套接口包含了对图书信息的正删改查功能")
                .build();
//        return new ApiInfo(
//                "龚志成的接口文档",
//                "此套接口包含了对图书信息的正删改查功能",
//                "1.0",
//                "www.baidu.com",
//                contact,
//                "Apache 2.0",
//                "http://localhost:3306/info/hello",
//                new ArrayList<>()
//        );
    }
}
