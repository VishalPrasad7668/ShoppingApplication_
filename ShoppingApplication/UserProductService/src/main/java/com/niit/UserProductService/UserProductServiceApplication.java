package com.niit.UserProductService;

import com.niit.UserProductService.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProductServiceApplication.class, args);
	}
	@Bean
	FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean frb = new FilterRegistrationBean<>();
		frb.setFilter(new JwtFilter());
		frb.addUrlPatterns("/userProduct/app/product/*");
		return frb;
	}

}
