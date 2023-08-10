class Menu {
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

    public String getIngredients() {
		return ingredients;
	}

	public String getDietaryInformation() {
		return dietaryInformation;
	}

	public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	public String getDishName() {
		return dishName;
	}

	public String toDisplay() {
		return "Dish: " + dishName +
                "\nDescription: " + description +
                "\nPrice: $" + price +
                "\nIngredients: " + ingredients +
                "\nDietary Information: " + dietaryInformation;
    }
}