package com.youtube.spring.durgesh;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.youtube.spring.durgesh.entity.User;

@SpringBootApplication
public class BlogAppApisApplication {
 	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);	
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
