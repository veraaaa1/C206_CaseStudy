public class Order {
	private int orderId;
	private String itemName;
	private int amount; // quantity

	public Order(int orderId, String itemName, int amount) {
		this.orderId = orderId;
		this.itemName = itemName;
		this.amount = amount;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getItemName() {
		return itemName;
	}

	public int getAmount() {
		return amount;
	}
}