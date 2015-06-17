package mum.waaproject.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Customer {

	@NotEmpty(message="Firstname cannot be empty!")
	@Column(name = "firstname", nullable=false)
	private String firstname;

	@NotEmpty(message="Lastname cannot be empty!")
	@Column(name = "lastname", nullable=false)
	private String lastname;

	@NotEmpty(message="Phone cannot be empty!")
	@Column(name = "phone")
	private String phone;

	@NotEmpty(message="Mobile cannot be empty!")
	@Column(name = "mobile")
	private String mobile;
	
	@Embedded
	@Valid
	private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
