import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		

		menuList.add(new Menu("Steam Chicken rice", "Description", 5.30, "Steamed Chicken meat, rice, cucumber", "Non-Halal"));
		menuList.add(new Menu("Roasted Chicken rice", "Description", 5.00, "Roasted Chicken meat, rice, cucumber", "Non-Halal"));

		int option = 0;

		while (option != 7) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all yr feature
				//C206_CaseStudy.viewAllUser(userList);


			} else if (option == 3) {
				// Add a new item
				C206_CaseStudy.setHeader("MENU");	
				System.out.println("1. View");
				System.out.println("2. ADD");
				System.out.println("3. DELETE");

				int itemType = Helper.readInt("Enter option to select function > ");

				if (itemType == 1) {
					// View all items
					C206_CaseStudy.viewAllMenu(menuList);

				} else if (itemType == 2) {
					// Add a Menu
					Menu cc = inputMenu();
					C206_CaseStudy.addMenu(menuList, cc);
					System.out.println("Menu added");

				} else if (itemType == 3) {
					// Add a ?
					// code for others

				}else {
					System.out.println("Invalid type");
				}

			} else if (option == 4) {
				// Loan item
				C206_CaseStudy.setHeader("LOAN");			
				C206_CaseStudy.setHeader("ITEM TYPES");
				System.out.println("1. View");
				System.out.println("2. ADD ");
				System.out.println("3. Delete");

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// dk
					System.out.println("item type 1?");
				} else if (itemType == 2) {
					//dk
					System.out.println("item type 2?");
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 4) {
				// Return item
				C206_CaseStudy.setHeader("RETURN");				
				C206_CaseStudy.setHeader("ITEM TYPES");
				System.out.println("1. Menu");
				System.out.println("2. Chromebook");

				int itemType = Helper.readInt("Enter option to select item type > ");
				if (itemType == 1) {
					// dk
					System.out.println("item type 1?");
				} else if (itemType == 2) {
					// dk
					System.out.println("item type 2?");
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 5) {
				System.out.println("Bye!");
			} else {
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

	//================================= Option 1 View XX (CRUD- Read) =================================
	public static String retrieveAllMenu(ArrayList<Menu> menuList) {
		String output = "";
		for (int i = 0; i < menuList.size(); i++) {
			output += String.format("%-10s %-30s %-10s %-10s %-20d\n",menuList.get(i).getDishName(),
					menuList.get(i).getDescription(), menuList.get(i).getPrice(),
					menuList.get(i).getIngredients(),menuList.get(i).getDietaryInformation());
		}
		return output;
	}

	public static void viewAllMenu(ArrayList<Menu> menuList) {
		// Input stall name below <stallList.getName()>
		C206_CaseStudy.setHeader("Stall 1");
		String output = String.format("%-10s %-30s %-10.2f %-10s %-20s\n", "STALL", "DISH NAME", "DESCRIPTION",
				"PRICE", "INGREDIENTS", "DIETARY INFORMATION");
		output += retrieveAllMenu(menuList);	
		System.out.println(output);
	}


	//================================= Option 2 Add an item (CRUD - Create) =================================
	public static Menu inputMenu() {
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

	//================================= Option 3 Delete an item (CRUD - Update) =================================
	public static boolean doDeleteMenu(ArrayList<Menu> menuList, String dishNameDel) {

		boolean isFound = false;

		if (dishNameDel.isEmpty() )
			return false;

		for (int i = 0; i < menuList.size(); i++) {
			//changes made xe
			String dishName = menuList.get(i).getDishName();
			if (dishName.equalsIgnoreCase(dishNameDel)) {
				isFound = true;
			}else {
				isFound = false;
			}
		}
		return isFound;
	}

	public static void loanCamcorder(ArrayList<Menu> menuList) {
		C206_CaseStudy.viewAllMenu(menuList);
		String dishNameDel = Helper.readString("Enter the dish name you want to delete > ");
		Boolean isFound = doDeleteMenu(menuList, dishNameDel);
		if (isFound == false) {
			System.out.println("Invalid Dish Name!");
		} else {
			System.out.println(dishNameDel + "'s menu has been deleted.");
		}
	}


}	
	