package br.com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.library.dto.EnderecoDTO;

@Service
public class ViaCepService {

	@Autowired
	private RestTemplate template;
	
	@Value("${url.via-cep}")
	private String url;
	
	public EnderecoDTO obterDadosCep(String cep) {
		String body = consultarCep(cep);
		Gson gson = new Gson();
        return gson.fromJson(body, EnderecoDTO.class);
	}

	private String consultarCep(String cep) {
		String  urlviacep = url   + cep + "/json";
        ResponseEntity<String> response = template.exchange(urlviacep, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
	}
}
