package com.microservice.loja.usuario.entrypoint.model.request;

import com.microservice.loja.usuario.enumerator.Status;

import lombok.Data;

@Data
public class UserModelRequest {
		
	private String id;	
	private String email;
	private String identification;
	private String password;
	private String authId;
	private Status status;
}