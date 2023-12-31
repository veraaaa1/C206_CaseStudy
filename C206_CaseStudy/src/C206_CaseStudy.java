import java.util.ArrayList;

 

public class C206_CaseStudy {

 

	public static void main(String[] args) { 
		ArrayList<Menu> menuList = new ArrayList<Menu>(); 
		ArrayList<Order> orderList = new ArrayList<Order>(); 
		ArrayList<Stall> stallList = new ArrayList<>(); 
		ArrayList<Queue> queueList = new ArrayList<>(); 
		ArrayList<Feedback> feedbackList = new ArrayList<>(); 
		ArrayList<User> userList = new ArrayList<User>();

 

		// Adding some example stalls and menu items
		Stall stall1 = new Stall("S001", "Chinese Delights", "1A", "CHINESE");
		Menu menu1 = new Menu("Vegetable Fried Rice", "Stir-fried rice with assorted vegetables", 6.0f, "Rice, Vegetables", "Vegetarian");

		Stall stall2 = new Stall("S002", "Western Delights", "1B", "WESTERN");
		Menu menu2 = new Menu("Margherita Pizza", "Classic pizza with tomato, mozzarella, and basil", 10.0f, "Dough, Tomato, Cheese, Basil", "Vegetarian");

		// Adding some example users
		User user1 = new User("John", "john@example.com", 91234567);
		User user2 = new User("Jane", "jane@example.com", 98765432);
		userList.add(user1);
		userList.add(user2);

 

		// Adding some example orders
		Order order1 = new Order(1, "Vegetable Fried Rice", 5);
		Order order2 = new Order(2, "Margherita Pizza", 6);
		orderList.add(order1);
		orderList.add(order2);

 

		// Adding some example queues
		Queue queue1 = new Queue("Q001", "Chinese Delights");
		Queue queue2 = new Queue("Q002", "Western Delights");
		queueList.add(queue1);
		queueList.add(queue2);

 

		// Adding some example feedbacks
		Feedback feedback1 = new Feedback("John", 4, "Great food!");
		Feedback feedback2 = new Feedback("Jane", 5, "Excellent service!");
		feedbackList.add(feedback1);
		feedbackList.add(feedback2);

 

		int option = 0;

 

		while (option != 4) {
			C206_CaseStudy.Loginmenu(); 
			option = Helper.readInt("Enter an option > ");

 

			if (option == 1) {
				String adminuser = "Admin";
				String adminpw = "Admin1";

 

				String user = Helper.readString("Enter username > ");
				String pw = Helper.readString("Enter password > ");

 

				if(user.equals(adminuser) && pw.equals(adminpw)) {
					System.out.println("You are logged in as an Admin!");
					while (option != 7) { 
						C206_CaseStudy.Usermenu(); 
						option = Helper.readInt("Enter an option > ");

 

						if (option == 1) { 
							// View all user feature 
							// <YI LUN> 
							System.out.println("1. ADD A NEW USER"); 
							System.out.println("2. VIEW ALL USERS"); 
							System.out.println("3. DELETE AN EXISTING USER");

 

							int choice = Helper.readInt("Enter choice > ");

 

							if (choice == 1) { 
								// ADD the add function 
								C206_CaseStudy.addUser(userList);

 

							} else if (choice == 2) { 
								// ADD the view function 
								C206_CaseStudy.viewAllUsers(userList);

 

							} else if (choice == 3) { 
								// ADD the delete function 
								C206_CaseStudy.deleteUser(userList);

 

							} else { 
								System.out.println("Invalid choice"); 
							}

 

							// View all stall feature 
							// <Kai Wen> 
						} else if (option == 2) { 
							System.out.println("1. ADD A NEW STALL"); 
							System.out.println("2. VIEW ALL STALLS"); 
							System.out.println("3. DELETE AN EXISTING STALL");

 

							int choice = Helper.readInt("Enter choice > ");

 

							if (choice == 1) { 
								Stall newStall = inputStalls(stallList); 
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

 

							} else if (choice == 3) { 
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
								Menu menu = C206_CaseStudy.inputMenu(stallList); 
								C206_CaseStudy.addMenu(menuList, menu);

 

							} else if (choice == 2) { 
								// View all menu items 
								C206_CaseStudy.viewAllMenu(menuList);

 

							} else if (choice == 3) { 
								// ADD the delete function

 

								C206_CaseStudy.doDeleteMenu(menuList);

 

							} else { 
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

 

							} else if (choice == 3) { 
								deleteOrder(orderList);

 

							} else { 
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
								C206_CaseStudy.addQueue(queueList, queueId, stallName);

 

							} else if (choice == 2) { 
								// View all queues 
								C206_CaseStudy.viewAllqueueList(queueList);

 

							} else if (choice == 3) { 
								// Delete an existing queue 
								String queueId = Helper.readString("Enter queue ID to delete > "); 
								C206_CaseStudy.deleteQueue(queueList, queueId);

 

							} else { 
								System.out.println("Invalid choice"); 
							} 
						} else if (option == 6) { 
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

 

							} else if (choice == 3) { 
								// Delete a existing feedback 
								C206_CaseStudy.deleteFeedback(feedbackList);

 

							} else { 
								System.out.println("Invalid choice"); 
							} 
						} else { 
							System.out.println("Invalid option");

 

						} 
					} 
				}else {
					System.out.println("Invalid Admin Login");
				}
			}

 

			else if (option == 2) {
				while (option != 7) { 
					C206_CaseStudy.Usermenu(); 
					option = Helper.readInt("Enter an option > ");

 

					if (option == 1) { 
						// View all user feature 
						// <YI LUN> 
						System.out.println("1. ADD A NEW USER"); 
						int choice = Helper.readInt("Enter choice > ");

 

						if (choice == 1) { 
							// ADD the add function 
							C206_CaseStudy.addUser(userList);

 

						} else { 
							System.out.println("Invalid choice"); 
						}

 

						// View all stall feature 
						// <Kai Wen> 
					} else if (option == 2) { 
						System.out.println("1. VIEW ALL STALLS");

 

						int choice = Helper.readInt("Enter choice > ");

 

						if (choice == 1) { 
							C206_CaseStudy.viewAllStalls(stallList);

 

 

						} else { 
							System.out.println("Invalid choice"); 
						} 
					}

 

					else if (option == 3) { 
						// View all menu feature 
						// <Xue E> 
						System.out.println("1. VIEW ALL MENU");

 

						int choice = Helper.readInt("Enter choice > ");

 

						if (choice == 1) { 
							// View all menu items 
							C206_CaseStudy.viewAllMenu(menuList);

 

						} else { 
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

 

						} else if (choice == 3) { 
							deleteOrder(orderList);

 

						} else { 
							System.out.println("Invalid choice"); 
						}

 

					}

 

					else if (option == 5) { 
						// View all queue feature 
						// <Chu Ying> 
						System.out.println("1. VIEW ALL QUEUE");

 

						int choice = Helper.readInt("Enter choice > ");

 

						if (choice == 1) { 
							// View all queues 
							C206_CaseStudy.viewAllqueueList(queueList);

 

						} else { 
							System.out.println("Invalid choice"); 
						} 
					} else if (option == 6) { 
						// View all feedback feature 
						// <Zong Rong> 
						System.out.println("1. ADD A NEW FEEDBACK"); 
						System.out.println("2. VIEW ALL FEEDBACKS");

 

						int choice = Helper.readInt("Enter choice > ");

 

						if (choice == 1) { 
							// Add a feedback 
							C206_CaseStudy.addFeedback(feedbackList);

 

						} else if (choice == 2) { 
							// View all feedback 
							C206_CaseStudy.viewFeedbacks(feedbackList);

 

						} else { 
							System.out.println("Invalid choice"); 
						} 
					} else { 
						System.out.println("Invalid option");

 

					} 
				} 
			} 
		}

 

 

	}

 

 

	public static void Loginmenu() { 
		C206_CaseStudy.setHeader("Logging into Canteen Ordering and Queuing System"); 
		System.out.println("1. Log in as Admin");
		System.out.println("2. Log in as User/Guest");
		System.out.println("3. Quit");
		Helper.line(80, "-");

 

	}

 

	public static void Usermenu() { 
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

 

	public static void Adminmenu() { 
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

 

	// ================================= Option 1 Add user (CRUD - Create) 
	// ================================= 
	public static void addUser(ArrayList<User> userList) { 
		String name; 
		while (true) { 
			name = Helper.readString("Enter Name: "); 
			if (isValidName(name)) { 
				break; 
			} else { 
				System.out.println("Invalid name format. Please use alphabetic characters only."); 
			} 
		}

 

		String email; 
		while (true) { 
			email = Helper.readString("Enter Email: "); 
			if (isValidEmail1(email)) { 
				break; 
			} else { 
				System.out.println("Invalid email format. Please include the @ symbol."); 
			} 
		}

 

		int contactnum; 
		while (true) { 
			contactnum = Helper.readInt("Enter Contact Number: "); 
			if (contactnum != 0) { 
				break; 
			} else { 
				System.out.println("Contact Number cannot be empty. Please enter a valid number."); 
			} 
		}

 

		User newUser = new User(name, email, contactnum); 
		userList.add(newUser); 
		System.out.println("User added: " + newUser.getName()); 
	}

 

	private static boolean isValidName(String name) { 
		return name.matches("[a-zA-Z]+"); 
	}

 

	private static boolean isValidEmail1(String email) { 
		return email.contains("@");

 

	}

 

 

	// ================================= Option 1 View all users (CRUD - Read) 
	// =================================

 

	public static void viewAllUsers(ArrayList<User> userList) { 
		Helper.line(80, "-"); 
		System.out.println("All Users:"); 
		printFormattedHeader();

 

		for (User user : userList) { 
			printFormattedUser(user); 
		}

 

		Helper.line(80, "-"); 
	}

 

	private static void printFormattedHeader() { 
		String header = String.format("%-20s %-20s %-25s\n", "NAME", "E-MAIL", "CONTACT NUMBER"); 
		System.out.println(header + Helper.lineToString(80, "-")); 
	}

 

	private static void printFormattedUser(User user) { 
		String userLine = String.format("%-20s %-20s %-25s\n", user.getName(), user.getEmail(), user.getContactnum()); 
		System.out.println(userLine);

 

	} 
	// ================================= Option 1 Delete existing user (CRUD - 
	// Delete) =================================

 

	public static void deleteUser(ArrayList<User> userList) { 
		String username = Helper.readString("Enter Name To Delete: "); 
		User userToRemove = null;

 

		for (User user : userList) { 
			if (user.getName().equals(username)) { 
				userToRemove = user; 
				break; 
			} 
		}

 

		if (userToRemove != null) { 
			userList.remove(userToRemove); 
			System.out.println("User deleted: " + userToRemove.getName()); 
		} else { 
			System.out.println("User not found with username: " + username); 
		} 
	}

 

	// ================================= Option 2 Add stall (CRUD - Create) 
	// ================================= 
	public static Stall inputStalls(ArrayList<Stall> stallList) { 
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
		if (stall.getStallNo().isEmpty() || stall.getLocation().isEmpty() 
				|| stall.getFoodCuisine().isEmpty()) { 
			System.out.println("Please fill up all information"); 
			return; 
		} 
		stallList.add(stall); 
		System.out.println("Stall added successfully!"); 
	}

 

	// ================================= Option 2 View all stalls (CRUD - Read) 
	// ================================= 
	public static String retrieveAllStalls(ArrayList<Stall> stallList) { 
		String output = "";

 

		for (Stall stall : stallList) { 
			output += String.format("%-10s %-20s %-20s %-5s\n", stall.getStallNo(), stall.getStallName(), 
					stall.getLocation(), stall.getFoodCuisine()); 
		} 
		return output; 
	}

 

	public static void viewAllStalls(ArrayList<Stall> stallList) { 
		C206_CaseStudy.setHeader("List of stalls by keywords"); 
		String output = String.format("%-10s %-20s %-20s %-5s\n", "Stall No", "Stall Name", "Location", 
				"Food Cuisine"); 
		output += retrieveAllStalls(stallList); 
		System.out.println(output); 
	}

 

	public static void viewspecificStalls(ArrayList<Stall> stallList, String keyword) { 
		C206_CaseStudy.setHeader("List of specific stalls"); 
		String output = String.format("%-10s %-20s %-20s %-5s\n", "Stall No", "Stall Name", "Location", 
				"Food Cuisine"); 
		output += retrievespecificStalls(stallList, keyword); 
		System.out.println(output); 
	}

 

	public static String retrievespecificStalls(ArrayList<Stall> stallList, String keyword) { 
		String output = "";

 

		for (Stall stall : stallList) { 
			if (stall.getStallName().toLowerCase().contains(keyword.toLowerCase())) { 
				output += String.format("%-10s %-20s %-20s %-5s\n", stall.getStallNo(), stall.getStallName(), 
						stall.getLocation(), stall.getFoodCuisine()); 
			} 
		} 
		return output; 
	}

 

	// ================================= Option 2 Delete existing stall (CRUD - Delete) ================================= 
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

 

	// ================================= Option 3 Add menu (CRUD - Create)  ================================= 
	public static Menu inputMenu(ArrayList<Stall> stallList) { 
		String dishName = Helper.readString("Enter Dish Name > "); 
		String description = Helper.readString("Enter description > "); 
		float price = Helper.readInt("Enter price of the dish > $"); 
		String ingredients = Helper.readString("Enter the ingredients in the dish > "); 
		String dietaryInformation = Helper.readString("Enter Dietary Information > ");

 

		Menu contentInput = new Menu(dishName, description, price, ingredients, dietaryInformation); 
		return contentInput;

 

	}

 

	public static void addMenu(ArrayList<Menu> menuList, Menu contentInput) { 
		Menu item; 
		for (int i = 0; i < menuList.size(); i++) { 
			item = menuList.get(i); 
			if (item.getDishName().equalsIgnoreCase(contentInput.getDishName())) 
				return; 
		} 
		if ((contentInput.getDishName().isEmpty()) || (contentInput.getDescription().isEmpty())) { 
			return; 
		}

 

		menuList.add(contentInput); 
	}

 

	// ================================= Option 3 View all menus (CRUD - Read) 
	// ================================= 
	public static String retrieveAllMenu(ArrayList<Menu> menuList) {

 

		  String output = "";

 

		  for (int i = 0; i < menuList.size(); i++) {

		    Menu menu = menuList.get(i);

		    if (menu != null) {

 

		      output += String.format("%-10s %-30s %-10.2f %-10s %-20s\n",menu.getDishName(),menu.getDescription(),menu.getPrice(),menu.getIngredients(),menu.getDietaryInformation());
		    }

 

 

		  }

 

		  return output;

 

		}

 

	public static void viewAllMenu(ArrayList<Menu> menuList) { 
		// Input stall name below <stallList.getName()> 
		C206_CaseStudy.setHeader("Stall 1"); 
		String output = String.format("20s\n", "STALL", "DISH NAME", "DESCRIPTION", "PRICE", 
				"INGREDIENTS", "DIETARY INFORMATION"); 
		output += retrieveAllMenu(menuList); 
		System.out.println(output); 
	}

 

	// ================================= Option 3 Delete existing menu (CRUD - 
	// Delete) =================================

 

 

	public static void doDeleteMenu(ArrayList<Menu> menuList) { 
		C206_CaseStudy.viewAllMenu(menuList); 
		String dishNameDel = Helper.readString("Enter the dish name you want to delete > ");

 

		Boolean isFound = checkDeleteMenu(menuList, dishNameDel); 
		if (isFound == false) { 
			System.out.println("Invalid Dish Name!"); 
		} else { 
			System.out.println(dishNameDel + "'s menu has been deleted."); 
		} 
	}

 

	public static boolean checkDeleteMenu(ArrayList<Menu> menuList, String dishNameDel) {

 

		boolean isFound = false;

 

		if (dishNameDel.isEmpty()) 
			return false;

 

		for (int i = 0; i < menuList.size(); i++) { 
			// changes made xe 
			String dishName = menuList.get(i).getDishName(); 
			if (dishName.equalsIgnoreCase(dishNameDel)) { 
				isFound = true; 
			} else { 
				isFound = false; 
			} 
		} 
		return isFound; 
	}

 

	// ================================= Option 4 Add order (CRUD - Create) ================================= 
	public static Order inputOrder() { 
		int orderId = Helper.readInt("Enter order ID > "); 
		String itemName = Helper.readString("Enter item name > "); 
		int amount = Helper.readInt("Enter order amount > ");

 

		return new Order(orderId, itemName, amount); 
	}

 

	public static void addOrder(ArrayList<Order> orderList, Order order) { 
		  // Check for duplicate order
		  if(orderList.contains(order)) {
		    System.out.println("Duplicate order not added"); 
		    return;
		  }

		 //  Validate order
		if (order.getOrderId() == 0 || order.getAmount() <= 0) { 
			System.out.println("Invalid order details"); 
			return; 
		}

 

		orderList.add(order); 
	} 

	// ================================= Option 4 View all orders (CRUD - Read) 
	// =================================

 

	public static String retrieveAllOrders(ArrayList<Order> orderList) {

 

		  String output = "";

 

		  for (int i = 0; i < orderList.size(); i++) {

 

		    output += String.format("%-10s %-30s %-10d\n",  
		      orderList.get(i).getOrderId(),
		      orderList.get(i).getItemName(), 
		      orderList.get(i).getAmount());

 

		  }

 

		  return output;

 

		}

 

		public static void viewAllOrders(ArrayList<Order> orderList) {

 

		  C206_CaseStudy.setHeader("ORDER LIST");

		  String output = String.format("%-10s %-30s %-10s\n", 
		    "ORDER ID", "ITEM NAME", "AMOUNT");

 

		  output += retrieveAllOrders(orderList);

		  System.out.println(output);

 

		}

 

	// ================================= Option 4 Delete existing order (CRUD - Delete) =================================

 

	public static void deleteOrder(ArrayList<Order> orderList) { 
		int orderId = Helper.readInt("Enter order ID > "); 
		char deleteConfirm = Helper.readChar("Confirm deletion? (Y/N)");

 

 

		for (int i = 0; i < orderList.size(); i++) { 
			Order order = orderList.get(i); 
			if (order.getOrderId() == orderId && (deleteConfirm == 'Y' || deleteConfirm == 'y')) { 
				orderList.remove(i); 
				System.out.println("Order deleted successfully!"); 
				return; 
			} 
		} 
		System.out.println("Order with the given Order ID not found."); 
	}

 

 

	public static boolean checkDeleteOrder(ArrayList<Order> orderList, int orderId) {
		boolean isFound = false;

 

		if (orderList.size() == 0)
			return false;

 

		for (int i = 0; i < orderList.size(); i++) {
			int orderID = orderList.get(i).getOrderId();

 

			if (orderID == orderId) {
				isFound = true;

 

				break;

 

			}

 

		}

 

		return isFound;

 

	}

 

	// ================================= Option 5 Add queue (CRUD - Create)

 

	public static void addQueue(ArrayList<Queue> queueList, String queueId, String stallName) { 
		// Task 3 - Validate queueId and stallName inputs 
		if (queueId.trim().isEmpty() || stallName.trim().isEmpty()) { 
			System.out.println("Error: Queue ID and Stall Name must not be empty."); 
			return; 
		}

 

		// Check if queueId already exists 
		for (Queue existingQueue : queueList) { 
			if (existingQueue.getQueueId().equals(queueId)) { 
				System.out.println("Error: Queue ID " + queueId + " already exists."); 
				return; 
			} 
		}

 

		// Create a new Queue object and add it to the queueList ArrayList 
		Queue queue = new Queue(queueId, stallName); 
		queueList.add(queue); 
		System.out.println("Queue " + queueId + " for " + stallName + " added."); 
	}

 

	// ================================= Option 5 View all queues (CRUD - Read)

 

	public static void viewAllqueueList(ArrayList<Queue> queueList) {

 

		if (queueList.size() == 0) { 
			System.out.println("No queueList available."); 
		} else { 
			System.out.println("queueList in Canteen:"); 
			for (Queue queue : queueList) { 
				System.out.println(queue.getQueueId() + ": " + queue.getStallName()); 
			} 
		} 
	}

 

	// ================================= Option 5 Delete existing queue (CRUD - ⠟⠟⠞⠞⠺⠞⠟⠞⠟⠟⠵⠞⠞⠺⠟⠟⠵⠺⠞⠺⠺⠵⠺⠟⠞⠵⠺⠵⠟⠞⠞=============== 
	public static void deleteQueue(ArrayList<Queue> queueList, String queueId) { 
		Queue queueToRemove = null; 
		for (Queue queue : queueList) { 
			if (queue.getQueueId().equals(queueId)) { 
				queueToRemove = queue; 
				break; 
			} 
		}

 

		if (queueToRemove != null) { 
			// Confirm deletion 
			boolean isConfirmed = Helper 
					.readBoolean("Are you sure you want to delete the queue " + queueId + "? (y/n): "); 
			if (isConfirmed) { 
				queueList.remove(queueToRemove); 
				System.out.println("Queue " + queueId + " has been deleted."); 
			} else { 
				System.out.println("Deletion of queue " + queueId + " canceled."); 
			} 
		} else { 
			// Queue not found error 
			System.out.println("Error: Queue " + queueId + " not found."); 
		} 
	}

 

	public static boolean checkDeleteQueue(ArrayList<Queue> queueList, String queueId) { 
		boolean isFound = false;

 

		if (queueId.isEmpty()) 
			return false;

 

		for (int i = 0; i < queueList.size(); i++) {

 

			String dishName = queueList.get(i).getQueueId(); 
			if (dishName.equalsIgnoreCase(queueId)) { 
				isFound = true; 
			} else { 
				isFound = false; 
			} 
		} 
		return isFound; 
	} 
	// ================================= Option 6 Add feedback (CRUD - Create)
	// =================================
	private static void addFeedback(ArrayList<Feedback> feedbackList) {
		String name = Helper.readString("Enter your name: ");
		int rating = Helper.readInt("Rate your experience (1 to 5): ");
		String comments = Helper.readString("Comments (optional): ");
		Feedback feedback = new Feedback(name, rating, comments);
		feedbackList.add(feedback);
		System.out.println("Thank you for your feedback!\n");
	}

 

	// ================================= Option 6 View all feedback (CRUD - Read)
	// =================================
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

 

	// ================================= Option 6 Delete existing feedback (CRUD -
	// Delete) =================================
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


