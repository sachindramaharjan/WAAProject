package mum.waaproject.model;

public class Category implements Item {

	private int id;
	private String name;
	private String description;
	private int parentid;

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

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public void addItem(Item item) {

	}

	public void removeItem(Item item) {

	}

	public Item getChild(int index) {
		return null;
	}

	@Override
	public Item findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sell(int id) {
		// TODO Auto-generated method stub

	}

}
