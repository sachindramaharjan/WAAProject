package mum.waaproject.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private int productId;
	private String message;
	
	public ProductNotFoundException(int productId, String message){
		this.productId = productId;
		this.message   = message;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
