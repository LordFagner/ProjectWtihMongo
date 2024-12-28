package com.fagcorps.main.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fagcorps.main.Domain.User;

public record CommentsDto(String text, Instant date, AuthorDto user) implements Serializable{

	public CommentsDto(AuthorDto user, String text) {
		this(text, Instant.now(), user);
	}

}
