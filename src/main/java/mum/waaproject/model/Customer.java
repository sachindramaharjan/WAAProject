package mum.waaproject.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Customer {

	@Column(name = "firstname", nullable=false)
	private String firstname;

	@Column(name = "lastname", nullable=false)
	private String lastname;

	@Column(name = "phone")
	private String phone;

	@Column(name = "mobile")
	private String mobile;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
