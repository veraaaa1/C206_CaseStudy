import java.util.ArrayList;

public class C206_CaseStudy {

    public static void main(String[] args) {
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        ArrayList<Order> orderList = new ArrayList<Order>();

        // ... (other code)

        int option = 0;

        while (option != 7) {
            C206_CaseStudy.menu();
            option = Helper.readInt("Enter an option > ");

            if (option == 1) {
                // View all user feature
                //C206_CaseStudy.viewAllUser(userList);
            } else if (option == 3) {
                // Menu options
                C206_CaseStudy.setHeader("MENU");
                System.out.println("1. View");
                System.out.println("2. ADD");
                System.out.println("3. DELETE");

                int itemType = Helper.readInt("Enter option to select function > ");

                if (itemType == 1) {
                    // View all menu items
                    C206_CaseStudy.viewAllMenu(menuList);
                } else if (itemType == 2) {
                    // Add a Menu
                    Menu menu = C206_CaseStudy.inputMenu();
                    C206_CaseStudy.addMenu(menuList, menu);
                    System.out.println("Menu added");
                } else if (itemType == 3) {
                    // Delete a menu item
                    C206_CaseStudy.loanCamcorder(menuList);
                } else {
                    System.out.println("Invalid type");
                }
            } else if (option == 4) {
                // ... (other options)
            } else if (option == 6) {
                // Add a new order
                C206_CaseStudy.setHeader("ADD ORDER");

                Order newOrder = inputOrder();
                addOrder(orderList, newOrder);
                System.out.println("Order added");
            } else if (option == 7) {
                // View all orders
                viewAllOrders(orderList);
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    // ... (other methods)

    //================================= Option 6 Add an order (CRUD - Create) =================================
    public static Order inputOrder() {
        String orderId = Helper.readString("Enter order ID > ");
        String itemName = Helper.readString("Enter item name > ");
        double amount = Helper.readDouble("Enter order amount > ");

        return new Order(orderId, itemName, amount);
    }

    public static void addOrder(ArrayList<Order> orderList, Order order) {
        if (order.getOrderId().isEmpty() || order.getItemName().isEmpty() || order.getAmount() <= 0) {
            System.out.println("Invalid order details");
            return;
        }

        orderList.add(order);
    }

    //================================= Option 7 View all orders (CRUD - Read) =================================
    public static void viewAllOrders(ArrayList<Order> orderList) {
    	C206_CaseStudy.setHeader("ORDER LIST");
        String output = String.format("%-10s %-30s %-10s\n", "ORDER ID", "ITEM NAME", "AMOUNT");

        for (int i = 0; i < orderList.size(); i++) {
            output += String.format("%-10s %-30s %-10.2f\n",
                    orderList.get(i).getOrderId(),
                    orderList.get(i).getItemName(),
