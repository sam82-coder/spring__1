package com.web.jpa.j1.controllers;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 144444L;

	public UserNotFoundException(Long id) {
		super("Counldn't find User  "+id);
	}
}
