package com.fagcorps.main.Domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fagcorps.main.dto.AuthorDto;
import com.fagcorps.main.dto.CommentsDto;

@Document
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String id ;
	private Instant date ;
	private String title ;
	private String body; 
	private AuthorDto Author; 
	
	List<CommentsDto> Comments = new ArrayList<>();
	
	
	public List<CommentsDto> getComments() {
		return Comments;
	}



	public Post() {
		// TODO Auto-generated constructor stub
	}



	public Post(String id, Instant date, String title, String body, User author) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		Author = new  AuthorDto(author); 
	}



	public AuthorDto getAuthor() {
		return Author;
	}



	public void setAuthor(AuthorDto author) {
		Author = author;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Instant getDate() {
		return date;
	}



	public void setDate(Instant date) {
		this.date = date;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getBody() {
		return body;
	}



	public void setBody(String body) {
		this.body = body;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
