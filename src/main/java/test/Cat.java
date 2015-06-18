package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Cat {

	@Id
	@GeneratedValue
	public int id;

	public String name;

	public boolean leaf;

	public Cat(String name, boolean leaf) {
		this.name = name;
		this.leaf = leaf;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public Cat parent;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "parent_id")
	public List<Cat> catlist = new ArrayList<Cat>();
	
	public void add(Cat cat){
		catlist.add(cat);
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

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public Cat getParent() {
		return parent;
	}

	public void setParent(Cat parent) {
		this.parent = parent;
	}

	public List<Cat> getCatlist() {
		return catlist;
	}

	public void setCatlist(List<Cat> catlist) {
		this.catlist = catlist;
	}

}
