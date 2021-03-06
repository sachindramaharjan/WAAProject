package mum.waaproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="category")
@Table(name = "category",  uniqueConstraints=@UniqueConstraint(columnNames={"name", "store_id"}))
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Name cannot be empty")
	@Size(min=4, max=40, message="Size must be between 4 and 40 characters")
	@Column(name = "name", nullable=false)
	private String name;

	@NotEmpty(message="Description cannot be empty")
	@Size(min=10, max=200, message="Size must be between 10 and 200 characters")
	@Column(name = "description")
	private String description;

	@Column(name = "leaf", nullable=false)
	private boolean leaf;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parent_category")
	private Category parent;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	List<Category> children = new ArrayList<Category>();
	
	@OneToMany(mappedBy="category")
	List<Product> products = new ArrayList<Product>();

	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;

	public Category(){}
	
	public Category(int id, String name, String description, boolean leaf) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.leaf = leaf;
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

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public void addCategory(Category category) {
		children.add(category);
	}

	public void removeCategory(Category category) {
		children.remove(category);
	}

	public Category getChild(int index) {
		return null;
	}

}
