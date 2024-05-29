package com.code.whiskers.mic_e_commerce_order;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MicECommerceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicECommerceOrderApplication.class, args);
	}

	@Bean
	@SuppressWarnings("null")
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override

			public void addCorsMappings(@NotNull CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins("*")
						.allowedHeaders("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}


}
