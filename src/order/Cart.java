package order;

import inventory.Product;

public class Cart {
	private String cartId;

	public Cart(String cartId, Product[] listOfProducts) {
		this.cartId = cartId;
		this.listOfProducts = listOfProducts;
	}

	public Cart() {
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	private Product[] listOfProducts;

	public Product[] getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(Product[] listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	public Boolean checkOut() {
		return true;
	}
}
