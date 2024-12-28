package com.fagcorps.main.dto;

import java.io.Serializable;

import com.fagcorps.main.Domain.User;

public record AuthorDto(String id, String name)  implements Serializable{

	public AuthorDto(User user) {
		this(user.getId(), user.getName());
		// TODO Auto-generated constructor stub
	}
}
