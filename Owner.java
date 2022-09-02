package Project;

import java.util.GregorianCalendar;

public class Owner {
	// Declare variables
	String Name;
	String RegisterionNo;
	String Address;
	String Tel;
	GregorianCalendar DateOfRegestration;

	// No-argument constructer
	public Owner() {
		Name = "No Name";
		RegisterionNo = "No Number";
		Address = "No Address";
		Tel = "0000";
	}

	// argument constructer (to make it easy when we make object from this class
	public Owner(String name) {
		super();
		Name = name;
	}

	// Method that return the registration duration
	@SuppressWarnings("static-access")
	public String DurationOfRegistration() {
		String Year = new GregorianCalendar().YEAR - DateOfRegestration.YEAR + " Years.";
		return Year;
	}

	// toString method that return all information about the object
	@Override
	public String toString() {
		return "Owner [Name: " + Name + ", RegisterionNo: " + RegisterionNo + ", Address: " + Address + ", Tel: " + Tel
				+ ", DateOfRegestration: " + DateOfRegestration + "]";
	}

	// Getters and Setters
	public GregorianCalendar getDateOfRegestration() {
		return DateOfRegestration;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRegisterionNo() {
		return RegisterionNo;
	}

	public void setRegisterionNo(String registerionNo) {
		RegisterionNo = registerionNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public void setDateOfRegestration(GregorianCalendar dateOfRegestration) {
		DateOfRegestration = dateOfRegestration;
	}

}
