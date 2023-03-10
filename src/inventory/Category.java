package inventory;

public class Category {
	private String categoryName;
	private Category[] subCategories;

	public Category(String categoryName, Category[] subCategories) {
		this.categoryName = categoryName;
		this.subCategories = subCategories;
	}

	public Category() {

	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category[] getSubCategories() {
		return subCategories;
	}

	public void setSubCatogories(Category[] subCategories) {
		this.subCategories = subCategories;
	}
}
