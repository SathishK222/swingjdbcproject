package Swing_JDBC_Myproject;


import java.io.Serializable;
import java.time.LocalDate;

//STEP 1 implements Serializable
public class UserModel implements Serializable  
{
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String city;
	private String gender;
	private String interests;
	private String dob;
    private String date;
	
	//STEP 2 CREATE NO ARG CONSTRUCTOR
	public UserModel() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		LocalDate dt = LocalDate.now();
		this.date = ""+dt;
	}
}