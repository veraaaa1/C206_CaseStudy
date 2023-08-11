public class Stall {
	private String stallNo;
	private String stallName;
	private String location;
	private String foodCuisine;

	public Stall(String stallNo, String stallName, String location, String foodCuisine) {
		this.stallNo = stallNo;
		this.stallName = stallName;
		this.location = location;
		this.foodCuisine = foodCuisine;
		this.stallNo = stallNo;
	}

	public String getStallNo() {
		return stallNo;
	}

	public void setStallNo(String stallNo) {
		this.stallNo = stallNo;
	}

	public String getStallName() {
		return stallName;
	}

	public void setStallName(String stallName) {
		this.stallName = stallName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFoodCuisine() {
		return foodCuisine;
	}

	public void setFoodCuisine(String foodCuisine) {
		this.foodCuisine = foodCuisine;
	}

}