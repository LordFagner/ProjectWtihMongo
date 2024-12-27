package com.fagcorps.main.Services.Exeption;

public class ObjextNotFoundExpction extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjextNotFoundExpction(String id) {
		super("Not Found object " + id); // TODO Auto-generated constructor stub
	}




}
