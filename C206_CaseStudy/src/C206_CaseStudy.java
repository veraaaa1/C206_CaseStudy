
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<Stall> stallList = new ArrayList<>();
		ArrayList<Queue> queues = new ArrayList<>();
		ArrayList<Feedback> feedbackList = new ArrayList<>();


		int option = 0;

		while (option != 7) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all user feature
				// <YI LUN>
				System.out.println("1. ADD A NEW USER");
				System.out.println("2. VIEW ALL USERS");
				System.out.println("3. DELETE AN EXISTING USER");


				int choice = Helper.readInt("Enter choice > ");

				if (choice == 1) {
					//ADD the add function
					//C206_CaseStudy.addUser(userList);}


				} else if (choice == 2) {
					//ADD the view function
					//C206_CaseStudy.viewUser(userList);

				} else if (choice == 3){
					//ADD the delete function
					//C206_CaseStudy.deleteUser(userList);

				}else {
					System.out.println("Invalid choice");
				}

				//View all stall feature
				//<Kai Wen>
			} else if (option == 2) {
				System.out.println("1. ADD A NEW STALL");
				System.out.println("2. VIEW ALL STALLS");
				System.out.println("3. DELETE AN EXISTING STALL");

				int choice = Helper.readInt("Enter choice > ");

				if (choice == 1) {
					Stall newStall = inputStalls();
					addStalls(stallList, newStall);

				} else if (choice == 2) {
					System.out.println("1. VIEW ALL STALLS");
					System.out.println("2. SEARCH BY KEYWORD");

					int choice1 = Helper.readInt("Enter choice > ");

					if (choice1 == 1) {
						C206_CaseStudy.viewAllStalls(stallList);

					} else if (choice1 == 2) {	
						String keyword = Helper.readString("Enter A Keyword > ");
						C206_CaseStudy.viewspecificStalls(stallList, keyword);

					} else {
						System.out.println("Invalid choice");
					}


				} else if (choice== 3) {
					String stallNoToDelete = Helper.readString("Enter Stall No to delete: ");
					deleteStall(stallList, stallNoToDelete);

				} else {
					System.out.println("Invalid choice");
				}
			}


			else if (option == 3) {
				// View all menu feature
				// <Xue E>
				System.out.println("1. ADD A NEW MENU");
				System.out.println("2. VIEW ALL MENU");
				System.out.println("3. DELETE AN EXISTING MENU");


				int choice = Helper.readInt("Enter choice > ");

				if (choice == 1) {
					// Add a Menu
					Menu menu = C206_CaseStudy.inputMenu();
					C206_CaseStudy.addMenu(menuList, menu);

				} else if (choice == 2) {
					// View all menu items
					C206_CaseStudy.viewAllMenu(menuList);

				} else if (choice == 3){
					//ADD the delete function
					//C206_CaseStudy.deleteMenu(MenuList);

				}else {
					System.out.println("Invalid choice");
				}
			}


			else if (option == 4) {
				// View all order feature
				// <Xavier>
				System.out.println("1. ADD A NEW ORDER");
				System.out.println("2. VIEW ALL ORDERS");
				System.out.println("3. DELETE AN EXISTING ORDER");


				int choice = Helper.readInt("Enter choice > ");

				if (choice == 1) {
					// Add a Menu
					C206_CaseStudy.setHeader("ADD ORDER");

					Order newOrder = inputOrder();
					addOrder(orderList, newOrder);
					System.out.println("Order added");

				} else if (choice == 2) {
					// View all orders
					viewAllOrders(orderList);

				} else if (choice == 3){
					//ADD the delete function
					//C206_CaseStudy.deleteMenu(MenuList);

				}else {
					System.out.println("Invalid choice");
				}


			}


			else if (option == 5) {
				// View all queue feature
				// <Chu Ying>
				System.out.println("1. ADD A NEW QUEUE");
				System.out.println("2. VIEW ALL QUEUE");
				System.out.println("3. DELETE AN EXISTING QUEUE");


				int choice = Helper.readInt("Enter choice > ");

				if (choice == 1) {
					// Task 2 in sprint backlog
					String queueId = Helper.readString("Enter queue ID > ");
					String stallName = Helper.readString("Enter stall name > ");
					C206_CaseStudy.addQueue(queueId, stallName);

				} else if (choice == 2) {
					// View all queues
					C206_CaseStudy.viewAllQueues();

				} else if (choice == 3){
					// Delete an existing queue
					String queueId = Helper.readString("Enter queue ID to delete > ");
					C206_CaseStudy.deleteQueue(queueId);


				}else {
					System.out.println("Invalid choice");
				}
			}
			else if (option == 6) {
				// View all feedback feature
				// <Zong Rong>
				System.out.println("1. ADD A NEW FEEDBACK");
				System.out.println("2. VIEW ALL FEEDBACKS");
				System.out.println("3. DELETE AN EXISTING FEEDBACK");


				int choice = Helper.readInt("Enter choice > ");

				if (choice == 1) {
					// Add a feedback
					C206_CaseStudy.addFeedback(feedbackList);

				} else if (choice == 2) {
					// View all feedback
					C206_CaseStudy.viewFeedbacks(feedbackList);

				} else if (choice == 3){
					// Delete a existing feedback
					C206_CaseStudy.deleteFeedback(feedbackList);

				}else {
					System.out.println("Invalid choice");
				}
			}
			else {
				System.out.println("Invalid option");

			}
		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("Canteen Ordering and Queuing System");
		System.out.println("1. User");
		System.out.println("2. Stall");
		System.out.println("3. Menu");
		System.out.println("4. Order");
		System.out.println("5. Queue");
		System.out.println("6. Feedback");
		System.out.println("7. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//================================= Option 1 Add user (CRUD - Create) =================================
	//================================= Option 1 View all users (CRUD - Read) =================================
	//================================= Option 1 Delete existing user (CRUD - Delete) =================================

	//================================= Option 2 Add stall (CRUD - Create) =================================
	public static Stall inputStalls() {
		String stallNo = Helper.readString("Enter stall No > ");
		String stallName = Helper.readString("Enter stall name > ");
		String location = Helper.readString("Enter location > ");
		String foodCuisine = Helper.readString("Enter food cuisine > ");

		Stall stall = new Stall(stallNo, stallName, location, foodCuisine);
		return stall;
	}

	public static void addStalls(ArrayList<Stall> stallList, Stall stall) {
		for (Stall item : stallList) {
			if (item.getStallNo().equalsIgnoreCase(stall.getStallNo())) {
				System.out.println("Stall with the same No already exists.");
				return;
			}
		}
		if (stall.getStallNo().isEmpty()|| stall.getStallName().isEmpty()|| stall.getLocation().isEmpty()|| stall.getFoodCuisine().isEmpty()) {
			System.out.println("Please fill up all information");
			return;
		}
		stallList.add(stall);
		System.out.println("Stall added successfully!");
	}


	//================================= Option 2 View all stalls (CRUD - Read) =================================
	public static String retrieveAllStalls(ArrayList<Stall> stallList) {
		String output = "";

		for (Stall stall : stallList) {
			output += String.format("%-10s %-10s %-10s %-10s\n", stall.getStallNo(),
					stall.getStallName(), stall.getLocation(), stall.getFoodCuisine());
		}
		return output;
	}

	public static void viewAllStalls(ArrayList<Stall> stallList) {
		C206_CaseStudy.setHeader("List of stalls by keywords");
		String output = String.format("%-10s %-10s %-10s %-10s\n", "Stall No", "Stall Name", "Location",
				"Food Cuisine");
		output += retrieveAllStalls(stallList);
		System.out.println(output);
	}

	public static void viewspecificStalls(ArrayList<Stall> stallList, String keyword) {
		C206_CaseStudy.setHeader("List of specific stalls");
		String output = String.format("%-10s %-10s %-10s %-10s\n", "Stall No", "Stall Name", "Location",
				"Food Cuisine");
		output += retrievespecificStalls(stallList, keyword);
		System.out.println(output);
	}

	public static String retrievespecificStalls(ArrayList<Stall> stallList, String keyword) {
		String output = "";

		for (Stall stall : stallList) {
			if (stall.getStallName().toLowerCase().contains(keyword.toLowerCase())) {
				output += String.format("%-10s %-10s %-10s %-15s\n", stall.getStallNo(), stall.getStallName(),
						stall.getLocation(), stall.getFoodCuisine());
			}
		}
		return output;
	}

	//================================= Option 2 Delete existing stall (CRUD - Delete) =================================
	public static void deleteStall(ArrayList<Stall> stallList, String stallNoToDelete) {
		for (int i = 0; i < stallList.size(); i++) {
			Stall stall = stallList.get(i);
			if (stall.getStallNo().equalsIgnoreCase(stallNoToDelete)) {
				stallList.remove(i);
				System.out.println("Stall deleted successfully!");
				return;
			}
		}
		System.out.println("Stall with the given Stall ID not found.");
	}

	//================================= Option 3 Add menu (CRUD - Create) =================================
	public static
	Menu inputMenu() { 
		String dishName = Helper.readString("Enter Dish Name > "); 
		String description = Helper.readString("Enter description > "); 
		float price = Helper.readInt("Enter price of the dish > $"); 
		String ingredients = Helper.readString("Enter the ingredients in the dish > "); 
		String dietaryInformation = Helper.readString("Enter Dietary Information > "); 

		Menu contentInput= new Menu(dishName, description, price, ingredients, dietaryInformation); 
		return contentInput; 

	} 
	public static void addMenu(ArrayList<Menu> menuList, Menu contentInput) { 
		Menu item; 
		for(int i = 0; i < menuList.size(); i++) { 
			item = menuList.get(i); 
			if (item.getDishName().equalsIgnoreCase(contentInput.getDishName()) ) 
				return; 
		} 
		if ((contentInput.getDishName().isEmpty()) || (contentInput.getDescription().isEmpty()) ) { 
			return; 
		} 

		menuList.add(contentInput); 
	} 





	//================================= Option 3 View all menus (CRUD - Read) =================================
	public static String retrieveAllMenu(ArrayList<Menu> menuList) { 
		String output = ""; 
		for (int i = 0; i < menuList.size(); i++) { 
			output += String.format("%-10s %-30s %-10.2f %-10s %-20s\n",menuList.get(i).getDishName(), 
					menuList.get(i).getDescription(), menuList.get(i).getPrice(), 
					menuList.get(i).getIngredients(),menuList.get(i).getDietaryInformation()); 
		} 
		return output; 
	} 

	public static void viewAllMenu(ArrayList<Menu> menuList) { 
		// Input stall name below <stallList.getName()> 
		C206_CaseStudy.setHeader("Stall 1"); 
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "STALL", "DISH NAME", "DESCRIPTION", 
				"PRICE", "INGREDIENTS", "DIETARY INFORMATION"); 
		output += retrieveAllMenu(menuList);  
		System.out.println(output); 
	} 

	//================================= Option 3 Delete existing menu (CRUD - Delete) =================================
	public static boolean doDeleteMenu(ArrayList<Menu> menuList, String dishNameDel) { 
		for (int i = 0; i < menuList.size(); i++) { 
			String dishName = menuList.get(i).getDishName(); 
			if (dishName.equalsIgnoreCase(dishNameDel)) { 
				menuList.remove(i); 
				return true; // Found and deleted 
			} 
		} 
		return false; // Not found 
	} 




	//================================= Option 4 Add order (CRUD - Create) =================================
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
	//================================= Option 4 View all orders (CRUD - Read) =================================

	public static String retrieveAllOrders(ArrayList<Order> orderList) {
		String output = "";
		for (int i = 0; i < orderList.size(); i++) {
			output += String.format("%-10s %-30s %-10.2f\n",orderList.get(i).getOrderId(),
					orderList.get(i).getItemName(), orderList.get(i).getAmount());

		}
		return output;
	}

	public static void viewAllOrders(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("ORDER LIST");
		String output = String.format("%-10s %-30s %-10s\n", "ORDER ID", "ITEM NAME", "AMOUNT");

		for (int i = 0; i < orderList.size(); i++) {
			output += String.format("%-10s %-30s %-10.2f\n",
					orderList.get(i).getOrderId(),
					orderList.get(i).getItemName());
			orderList.get(i).getAmount();

			output += retrieveAllOrders(orderList);	
			System.out.println(output);
		}
	}


	//================================= Option 4 Delete existing order (CRUD - Delete) =================================



	//================================= Option 5 Add queue (CRUD - Create) =================================
	public static void addQueue(ArrayList<Queue> queues, String queueId, String stallName) {
		// Task 3 - Validate queueId and stallName inputs
		if (queueId.trim().isEmpty() || stallName.trim().isEmpty()) {
			System.out.println("Error: Queue ID and Stall Name must not be empty.");
			return;
		}



		// Create a new Queue object and add it to the queues ArrayList
		Queue queue = new Queue(queueId, stallName);
		queues.add(queue);
		System.out.println("Queue " + queueId + " for " + stallName + " added.");
	}


	//================================= Option 5 View all queues (CRUD - Read) =================================
	public static void viewAllQueues() {
		if (queue.isEmpty()) {
			System.out.println("No queues available.");
		} else {
			System.out.println("Queues in Canteen:");
			for (Queue queue : queues) {
				System.out.println(queue.getQueueId() + ": " + queue.getStallName());
			}
		}
	}

	//================================= Option 5 Delete existing queue (CRUD - Delete) =================================
	public static void deleteQueue(String queueId) {
		Queue queueToRemove = null;
		for (Queue queue : queues) {
			if (queue.getQueueId().equals(queueId)) {
				queueToRemove = queue;
				break;
			}
		}



		if (queueToRemove != null) {
			// Confirm deletion 
			boolean isConfirmed = Helper.readBoolean("Are you sure you want to delete the queue " + queueId + "? (y/n): ");
			if (isConfirmed) {
				queues.remove(queueToRemove);
				System.out.println("Queue " + queueId + " has been deleted.");
			} else {
				System.out.println("Deletion of queue " + queueId + " canceled.");
			}
		} else {
			// Queue not found error
			System.out.println("Error: Queue " + queueId + " not found.");
		}
	}


	//================================= Option 6 Add feedback (CRUD - Create) =================================
	private static void addFeedback(ArrayList<Feedback> feedbackList) {
		String name = Helper.readString("Enter your name: ");
		int rating = Helper.readInt("Rate your experience (1 to 5): ");
		String comments = Helper.readString("Comments (optional): ");
		Feedback feedback = new Feedback(name, rating, comments);
		feedbackList.add(feedback);
		System.out.println("Thank you for your feedback!\n");
	}

	//================================= Option 6 View all feedback (CRUD - Read) =================================
	private static void viewFeedbacks(ArrayList<Feedback> feedbackList) {
		System.out.println("\nFeedback Summary:");
		if (feedbackList.isEmpty()) {
			System.out.println("No feedbacks collected yet.");
		} else {
			for (Feedback feedback : feedbackList) {
				System.out.println(feedback);
				System.out.println("--------------------------");
			}
		}
		System.out.println();
	}

	//================================= Option 6 Delete existing feedback (CRUD - Delete) =================================
	private static void deleteFeedback(ArrayList<Feedback> feedbackList) {
		if (feedbackList.isEmpty()) {
			System.out.println("No feedbacks collected yet.");
			return;
		}



		int indexToDelete = Helper.readInt("Enter the index of the feedback to delete: ");
		if (indexToDelete < 1 || indexToDelete > feedbackList.size()) {
			System.out.println("Invalid index. Please try again.");
			return;
		}



		feedbackList.remove(indexToDelete - 1);
		System.out.println("Feedback deleted successfully.\n");
	}
}

>>>>>>> branch 'master' of https://github.com/veraaaa1/C206_CaseStudy.git
