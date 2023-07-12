package entity;

public class User {
	String uid,password,fname,lname,email,contact;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String uid, String password, String fname, String lname, String email, String contact) {
		super();
		this.uid = uid;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
