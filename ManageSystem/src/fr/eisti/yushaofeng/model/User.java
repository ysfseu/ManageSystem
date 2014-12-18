package fr.eisti.yushaofeng.model;

public class User {
	int id;
	String firstName;
	String lastName;
	String username;
	String password;
	int metierId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMetierId() {
		return metierId;
	}
	public void setMetierId(int metierId) {
		this.metierId = metierId;
	}
	

}
