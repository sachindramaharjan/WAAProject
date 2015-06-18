package mum.waaproject.exception;

public class CategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int categoryId;
	private String message;

	public CategoryNotFoundException(int categoryId, String message) {
		this.categoryId = categoryId;
		this.message = message;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
