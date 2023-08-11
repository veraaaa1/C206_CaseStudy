public class Order {
	private String orderId;
	private String itemName;
	private double amount;

	public Order(String orderId, String itemName, double amount) {
		this.orderId = orderId;
		this.itemName = itemName;
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getItemName() {
		return itemName;
	}

	public double getAmount() {
		return amount;
	}
}
