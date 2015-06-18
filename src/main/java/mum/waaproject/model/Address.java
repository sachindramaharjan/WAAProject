package mum.waaproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Street cannot be empty!")
	@Column(name="street", nullable=false)
	private String street;
	
	@NotEmpty(message="City cannot be empty!")
	@Column(name="city", nullable=false)
	private String city;
	
	@NotEmpty(message="State cannot be empty!")
	@Column(name="state", nullable=false)
	private String state;
	
	@NotEmpty(message="Zip cannot be empty!")
	@Column(name="zip", nullable=false)
	private String zip;
	
	@NotEmpty(message="Courntry cannot be empty!")
	@Column(name="country", nullable=false)
	private String country;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
