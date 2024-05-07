package com.ilp03.entity;

public class Clients {
	
    private int clientId;
    private String clientName;
    private String email;
    private long phone;
	public Clients(int clientId, String clientName, String email, long phone) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.email = email;
		this.phone = phone;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}


}
