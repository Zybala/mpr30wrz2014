package main;





import java.util.ArrayList;
import java.util.List;


public class Person extends Entity{
	
	public Person() {
		super();
		this.locations=new ArrayList<Address>();
		
	}
	private String name;
	private String surename;
	private String middlename;
	private String IDnumber;
	private String DOB;
	
	private User user;
	private List<Address> locations;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getIDnumber() {
		return IDnumber;
	}
	public void setIDnumber(String iDnumber) {
		IDnumber = iDnumber;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		if(!this.equals(user.getPerson()))
		user.setPerson(this);
		this.user = user;
	}
	public List<Address> getLocations() {
		return locations;
	}
	public void setLocations(List<Address> locations) {
		this.locations = locations;
	}
	
	

}
