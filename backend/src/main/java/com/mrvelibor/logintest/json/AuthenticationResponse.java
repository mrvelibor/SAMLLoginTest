package com.mrvelibor.logintest.json;

public class AuthenticationResponse {

	private String token;
    private String username;
    private String type;

	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token, String username, String type) {
	    this.setToken(token);
	    this.setUsername(username);
	    this.setType(type);
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
