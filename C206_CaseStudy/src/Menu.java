class Menu{
	private String dishName;
	private String description;
	private double price;
	private String ingredients;
	private String dietaryInformation;

	public Menu(String dishName, String description, double price, String ingredients, String dietaryInformation) {
		this.dishName = dishName; 
		this.description = description;
		this.price = price;
		this.ingredients = ingredients;
		this.dietaryInformation = dietaryInformation;
	}

	// Getters and Setters

	public String getDescription() {
		return description;
	}

	public String getDishName() {
		// TODO Auto-generated method stub
		return dishName;
	}

	
	public Object getDietaryInformation() {
		// TODO Auto-generated method stub
		return dietaryInformation;
	}


	public Object getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	
	public Object getIngredients() {
		// TODO Auto-generated method stub
		return ingredients;
	}
}