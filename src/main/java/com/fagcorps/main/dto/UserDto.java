package com.fagcorps.main.dto;

import java.io.Serializable;

import com.fagcorps.main.Domain.User;

public record UserDto (String id , String nome , String email) implements Serializable{
	public UserDto(User user) {
		this(user.getId(),user.getName(),user.getEmail());
		// TODO Auto-generated constructor stub
	}
}
