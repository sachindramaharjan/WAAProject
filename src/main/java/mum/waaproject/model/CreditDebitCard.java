package mum.waaproject.model;

public class CreditDebitCard implements PaymentMethod {

	private int cardNumber;

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void makePayment() {
		// TODO Auto-generated method stub

	}

}
