package mum.waaproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="store")
@Table(name = "store")
public class Store implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "store_id", nullable=false, unique=true)
	private int id;

	@Column(name = "name", nullable=false, unique=true)
	private String name;

	@Column(name = "description", nullable=false)
	private String description;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="store")
	private List<Category> categorylist = new ArrayList<Category>();
	
	@OneToMany(mappedBy="store")
	private List<Product> productlist = new ArrayList<Product>();
	
	public void addCategory(Category category){
		categorylist.add(category);
	}
	
	public void addProduct(Product product){
		productlist.add(product);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Category> getCategorylist() {
		return categorylist;
	}

	public void setCategorylist(List<Category> categorylist) {
		this.categorylist = categorylist;
	}
	
	
	
	

}
