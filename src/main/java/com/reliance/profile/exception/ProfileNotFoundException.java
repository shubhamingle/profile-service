package com.reliance.profile.exception;

public class ProfileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProfileNotFoundException(String message) {
		super(message);
	}

	public ProfileNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}