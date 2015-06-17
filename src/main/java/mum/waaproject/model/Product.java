package mum.waaproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import mum.waaproject.validator.ProductCode;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "product")
@Table(name = "product", uniqueConstraints = @UniqueConstraint(columnNames = {
		"store_id", "productcode" }))
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;

	@Column(name = "name")
	@NotNull(message="{error.notnull.product.name}")
	@Size(min = 4, max = 40, message = "{error.size.product.name}")
	private String name;

	@Column(name = "description")
	@NotEmpty(message = "{error.notempty.product.description}")
	@Size(max = 255,message="{error.size.product.description}")
	private String description;

	@Column(name = "productcode", nullable = false)
	//@ProductCode
	@Pattern(regexp = "P[1-9]+", message = "{error.pattern.product.productcode}")
	@NotNull(message = "{error.product.notnull.productcode}")
	private String productcode;

	@Column(name = "image")
	private String image;

	@Transient
	@JsonIgnore
	private MultipartFile imageFile;

	@Column(name = "price")
	@NotNull(message= "{error.notnull.product.price}")
	@Min(value=0, message="{error.min.product.price}")
	@Digits(integer=6, fraction=2, message="{error.digits.product.price}")
	private Double price;

	@Column(name = "feature")
	private String feature;

	@Column(name = "stock")
	@NotNull(message="{error.notnull.product.stock}")
	@Min(value=1, message="{error.min.product.stock}")
	private Integer stock;

	@Column(name = "stock_status")
	@NotEmpty(message = "{error.notnull.product.stock_status}")
	private String stock_status;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@NotNull(message = "{error.notnull.product.category}")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;
	
	@Column(name="is_freatured")
	private Boolean isFeatured;
	
	@Column(name="created_date")
	@DateTimeFormat(pattern="mm/dd/yyyy")
	private Date createdDate;

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

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getStock_status() {
		return stock_status;
	}

	public void setStock_status(String stock_status) {
		this.stock_status = stock_status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Integer getStock() {
		return stock;
	}

	public Boolean getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(Boolean isFeatured) {
		this.isFeatured = isFeatured;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
