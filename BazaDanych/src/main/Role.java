package main;

import java.util.*;


public class Role extends Entity {
	
	private String name;
	private List<Privilege> privilege;
	private List<User> users;
	public Role()
	{
		privilege=new ArrayList<Privilege>();
		users= new ArrayList<User>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Privilege> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(List<Privilege> privilege) {
		this.privilege = privilege;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
