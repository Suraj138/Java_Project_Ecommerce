package inventory;

import user.Seller;

public class Catalogue {
	private Product[] listofAllProducts;

	public Catalogue(Product[] listofAllProducts) {
		this.listofAllProducts = listofAllProducts;
	}

	public Catalogue() {

	}

	public Product[] getListofAllProducts() {
		Category cat1 = new Category();
		Category cat2 = new Category();
		Category cat3 = new Category();
		Category cat4 = new Category();
		Category cat5 = new Category();
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		Product product4 = new Product();
		cat1.setCategoryName("Clothes");
		cat2.setCategoryName("Electronics");
		cat3.setCategoryName("Furniture");
		cat4.setCategoryName("Formals");
		cat5.setCategoryName("Casuals");
		Category[] subCategory = { cat4, cat5 };
		cat1.setSubCatogories(subCategory);

		product1.setProductId("1");
		product1.setProductName("T-shirt");
		product1.setCost("300");
		product1.setCategory(cat1);
		product1.setSeller(new Seller());

		product2.setProductId("2");
		product2.setProductName("Pyjama");
		product2.setCost("200");
		product2.setCategory(cat1);
		product2.setSeller(new Seller());

		product3.setProductId("3");
		product3.setProductName("Smart Phone");
		product3.setCost("15000");
		product3.setCategory(cat2);
		product3.setSeller(new Seller());

		product4.setProductId("4");
		product4.setProductName("Study Table");
		product4.setCost("3000");
		product4.setCategory(cat3);
		product4.setSeller(new Seller());

		listofAllProducts = new Product[100];
		listofAllProducts[0] = product1;
		listofAllProducts[1] = product2;
		listofAllProducts[2] = product3;
		listofAllProducts[3] = product4;
		return listofAllProducts;
	}

	public void setListofAllProducts(Product[] listofAllProducts) {
		this.listofAllProducts = listofAllProducts;
	}
}
