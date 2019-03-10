package com.xjy.springboot;

import com.xjy.springboot.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@Configuration
@MapperScan("com.xjy.springboot.mapper")
public class SpringbootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
    @RequestMapping("hello")
    @ResponseBody()
	public String hello(){
	    return "hello world";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
	    return builder.sources(this.getClass());
    }

}

