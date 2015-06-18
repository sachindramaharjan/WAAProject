package mum.waaproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


public class Stock implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_id", nullable = false, unique = true)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "product"))
	private int id;

	@Column(name = "available")
	private int available;

	@Column(name = "status", nullable=false)
	private String Status;
//	
//	@OneToOne
//	@PrimaryKeyJoinColumn
//	private Product product;

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
}
