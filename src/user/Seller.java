package user;

import inventory.Product;

public class Seller extends User {
	private Product[] productsListed;

	public Seller(Product[] productsListed) {
		this.productsListed = productsListed;
	}

	public Seller() {

	}

	@Override
	public Boolean verifyUser() {
		return true;
	}

	public Product[] getProductsListed() {
		return productsListed;
	}

	public void setProductsListed(Product[] productsListed) {
		this.productsListed = productsListed;
	}

}
