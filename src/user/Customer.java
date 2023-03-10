package user;

import order.Cart;

public class Customer extends User {
	private Cart cart;

	public Customer(Cart cart) {
		this.cart = cart;
	}

	public Customer() {

	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public Boolean verifyUser() {
		return true;
	}

}
