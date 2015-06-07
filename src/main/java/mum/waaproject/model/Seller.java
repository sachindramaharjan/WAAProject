package mum.waaproject.model;

public class Seller implements CustomerRole {
	
	private Integer rating;

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public void changeRole() {
		// TODO Auto-generated method stub
		
	}

}
