package br.com.library.core;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateConfig {

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
