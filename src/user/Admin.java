package user;

import inventory.Catalogue;
import inventory.Category;
import inventory.Product;
import order.Order;

public class Admin extends User {

	private Customer customer;
	private Category category;
	private Catalogue catalogue;
	private Order order;
	private Product product;
	private Seller seller;
	private User user;

	public Admin(Customer customer, Category category, Catalogue catalogue, Order order, Product product, Seller seller,
			User user) {
		this.customer = customer;
		this.category = category;
		this.catalogue = catalogue;
		this.order = order;
		this.product = product;
		this.seller = seller;
		this.user = user;
	}

	public Admin() {

	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Boolean verifyUser() {
		if (this.getUserId().equals("admin")) {
			return true;
		}
		return false;
	}

}
