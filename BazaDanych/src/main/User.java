package main;

import java.util.*;




public class User extends Entity {
	public String username;
	public String password;
	public Person person;
	public String email;
	
	private List<Role> roles;
	public User()
	{
		roles=new ArrayList<Role>();
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
	public String getEmail() {
		return email;
	}
	public void setEmail2(String email) {
		this.email = email;
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	

}
