package ecommerce;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import inventory.Catalogue;
import inventory.Category;
import inventory.Product;
import order.Cart;
import order.Order;
import user.Admin;
import user.Customer;
import user.Seller;

public class Store {

	Product prod = new Product();
	Cart cart = new Cart();
	Catalogue catalogue = new Catalogue();
	static Customer customer = new Customer();
	static Seller seller = new Seller();
	static Admin admin = new Admin();
	Product[] allProducts = catalogue.getListofAllProducts();

	public void addProduct(Product prod) {
		for (int i = 0; i < allProducts.length; i++) {
			if (allProducts[i] == null) {
				allProducts[i] = prod;
				break;
			}
		}
		catalogue.setListofAllProducts(allProducts);
		System.out.println("Product added successfully!");
	}

	public void viewProducts() {

		for (int i = 0; i < allProducts.length; i++) {
			if (allProducts[i] != null) {
				System.out.println(allProducts[i].getProductId() + " " + allProducts[i].getProductName() + " "
						+ allProducts[i].getCost());
			}
		}
	}

	public void addToCart(String productId) {
		Product[] allProducts = catalogue.getListofAllProducts();
		Product[] cartProducts = new Product[1];
		for (int i = 0; i < allProducts.length; i++) {
			if (allProducts[i] != null) {
				if (allProducts[i].getProductId().equals(productId))
					cartProducts[0] = allProducts[i];
			}
		}

		Cart cart = new Cart();
		cart.setCartId("1");
		cart.setListOfProducts(cartProducts);
		customer.setCart(cart);
		System.out.println("The product is successfully added to the cart.");
	}

	public void viewCart() {
		try {
			Product[] cartProducts = customer.getCart().getListOfProducts();
			System.out.println(customer.getCart().getCartId());
			for (int i = 0; i < cartProducts.length; i++) {
				System.out.println(cartProducts[i].getProductId() + " " + cartProducts[i].getProductName() + " "
						+ cartProducts[i].getCost());
			}
		} catch (Exception e) {
			System.out.println("Cart is empty!");
			e.printStackTrace();
		}
	}

	public void checkOut() {

		if (customer.getCart().checkOut()) {
			// Create an order object and assign this user to the order with an order id
			Order order = new Order();
			order.setOrderId("1");
			order.setUser(customer);
			System.out.println("Your order id is.." + order.getOrderId() + " for the user id "
					+ order.getUser().getUserId() + " is placed successfully");
			String customerId = customer.getUserId();
			System.out.println("Creating receipt");
			File f1 = new File(customerId + ".txt");
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(f1, true));
				bw.write("Your order id is " + order.getOrderId());
				bw.newLine();
				bw.write("For the user " + order.getUser().getUserId());
				bw.newLine();
				bw.write("Thank you..!  (',')  ");
				bw.close();
			} catch (IOException e) {
				System.out.println("Error while creating receipt.");
				e.printStackTrace();
			}
		}

	}

	public void deleteProduct(String productId) {
		for (int i = 0; i < allProducts.length; i++) {
			if (allProducts[i] != null) {
				if (allProducts[i].getProductId().equals(productId)) {
					allProducts[i] = null;
					break;
				}
			}

		}
	}

	public void viewProductsByCategory(String categoryName) {
		for (int i = 0; i < allProducts.length; i++) {
			if (allProducts[i] != null && allProducts[i].getCategory().getCategoryName().equals(categoryName)) {
				System.out.println(allProducts[i].getProductId() + " " + allProducts[i].getProductName() + " "
						+ allProducts[i].getCost());
			}
		}
	}

	public void contactUs() {
		System.out.println("To contact us, please email on store@ecommerce.com");
	}

	public void exit() {
		System.out.println("Thank you! Please visit again...  (',')  ");
		System.exit(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();

		System.out.println("Welcome to the ecommerce store!");
		System.out.println("Which user are you? 1. Customer 2. Seller 3. Admin");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("What is your userId?");
			sc.nextLine();
			customer.setUserId(sc.nextLine());
			System.out.println("What is your passWord?");
			sc.nextLine();
			customer.setPassword(sc.nextLine());
			if (customer.verifyUser() == true) {
				System.out.println("User verified!");
				while (true) {
					System.out.println("Do you want to- 1. View products 2. View Cart 3. Contact Us 4. Exit");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Select the category: 1.Clothes 2. Electronics 3.Furnitures 4.Exit");
						choice = sc.nextInt();
						if (choice == 1)
							store.viewProductsByCategory("Clothes");
						else if (choice == 2)
							store.viewProductsByCategory("Electronics");
						else if (choice == 3)
							store.viewProductsByCategory("Furniture");
						else
							store.exit();
						System.out.println("Do you want to add any product to the cart? Y/N");
						sc.nextLine();
						String addToCart = sc.nextLine();
						if (addToCart.equals("Y")) {
							System.out.println("Input the product id of the product which you want to add to cart.");
							String productId = sc.nextLine();
							store.addToCart(productId);
						}
						break;
					case 2:
						store.viewCart();
						System.out.println("Do you want to checkout? Y/N");
						sc.nextLine();
						String checkout = sc.nextLine();
						if (checkout.equals("Y"))
							store.checkOut();
						break;
					case 3:
						store.contactUs();
						break;
					case 4:
						store.exit();
						break;
					default:
						System.out.println("Invalid choice, please try again.");
					}
				}
			}
			break;
		case 2:
			Seller seller = new Seller();
			sc.nextLine();
			System.out.println("What is your seller Id? ");
			sc.nextLine();
			System.out.println("What is your password?");
			sc.nextLine();
			if (seller.verifyUser()) {
				while (true) {
					System.out.println("Do you want to- 1. View products 2. Add product 3. Contact Us 4. Exit");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Select the category: 1.Clothes 2. Electronics 3.Furnitures 4.Exit");
						choice = sc.nextInt();
						if (choice == 1)
							store.viewProductsByCategory("Clothes");
						else if (choice == 2)
							store.viewProductsByCategory("Electronics");
						else if (choice == 3)
							store.viewProductsByCategory("Furniture");
						else
							store.exit();
						System.out.println("Do you want to delete any product (Y/N)?");
						sc.nextLine();
						String deleteProd = sc.nextLine();
						if (deleteProd.equals("Y")) {
							System.out.println("Input the product id of the product which you want to delete");
							String productId = sc.nextLine();
							store.deleteProduct(productId);
						}
						break;
					case 2:
						Product prod = new Product();
						Category cat = new Category();
						System.out.println("Do you want to add any product ? Y/N");
						sc.nextLine();
						String addProduct = sc.nextLine();
						if (addProduct.equals("Y")) {
							System.out.println("Select the category: 1.Clothes 2. Electronics 3.Furnitures");
							choice = sc.nextInt();
							if (choice == 1)
								cat.setCategoryName("Clothes");
							else if (choice == 2)
								cat.setCategoryName("Electronics");
							else
								cat.setCategoryName("Furniture");
							prod.setCategory(cat);
							sc.nextLine();
							System.out.println("Input the product details which you want to add.");
							System.out.println("Enter product id:");
							prod.setProductId(sc.nextLine());
							System.out.println("Enter product name:");
							prod.setProductName(sc.nextLine());
							System.out.println("Enter product's cost: ");
							prod.setCost(sc.nextLine());
							System.out.println("Enter seller details:");
							System.out.println("Seller's id:");
							seller.setUserId(sc.nextLine());
							prod.setSeller(seller);
							store.addProduct(prod);
							break;
						}
					case 3:
						store.contactUs();
						break;
					case 4:
						store.exit();
						break;
					default:
						System.out.println("Invalid choice, please try again.  (',')  ");
					}
				}
			}
			break;

		case 3:
			System.out.println("What is your AdminId?");
			sc.nextLine();
			admin.setUserId(sc.nextLine());
			System.out.println("What is your PassWord?");
			sc.nextLine();
			admin.setPassword(sc.nextLine());
			if (admin.verifyUser() == true) {
				System.out.println("Admin verified!");
				while (true) {
					System.out.println("Do you want to:- 1.View Products 2. Contact Us 3. Exit ");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						store.viewProducts();
					case 2:
						store.contactUs();
						break;
					case 3:
						store.exit();
						break;
					default:
						System.out.println("Invalid choice, please try again.");
					}

				}

			} else
				System.out.println("You are not an admin!");
			break;
		default:
			System.out.println("Invalid input...!  Please Try Again... (',') ");
		}
		sc.close();
	}
}
