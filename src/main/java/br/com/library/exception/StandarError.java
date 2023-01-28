package br.com.library.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class StandarError {

private LocalDateTime timestemp;
	
	private Integer status;
	
	private String error;
	
	private String path;
}
