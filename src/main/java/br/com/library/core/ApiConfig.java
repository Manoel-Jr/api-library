package br.com.library.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfig {

	@Bean
	public ModelMapper model() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
