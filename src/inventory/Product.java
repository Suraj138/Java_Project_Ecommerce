package inventory;

import inventory.Category;
import user.Seller;

public class Product {
	private String productId;
	private String cost;
	private String productName;
	private Seller seller;
	private Category category;

	public Product(String productId, String cost, String productName, Seller seller, Category category) {
		this.productId = productId;
		this.cost = cost;
		this.productName = productName;
		this.seller = seller;
		this.category = category;
	}

	public Product() {

	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
