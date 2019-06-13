package com.revature.beans;
//userinfo bean
public class UserInfo {
	private int ID;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String phone;
	private String email;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserInfo(int iD, String firstName, String lastName, String address, String city, String state, String phone,
			String email) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "======================= User ID " + ID +
				" ===========================" + 
				"\nFull Name:\t\t" + firstName + " " + lastName + 
				"\nFull Address:\t\t" + address
				+ ", " + city + ", " + state + 
				"\nPhone Number:\t\t" + phone + 
				"\nEmail Address:\t\t" + email;
	}
	
}
