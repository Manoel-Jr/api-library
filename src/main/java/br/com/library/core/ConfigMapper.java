package br.com.library.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMapper {

	@Bean
	public ModelMapper model() {
		return new ModelMapper();
	}
}
