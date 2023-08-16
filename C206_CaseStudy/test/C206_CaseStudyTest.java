import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest { 
	// prepare test data  
	private Menu mn1; 
	private Menu mn2; 
	private ArrayList<Menu> menuList; 

	private Feedback fb1; 
	private Feedback fb2; 
	private Feedback fb3; 
	private ArrayList<Feedback> feedbackList; 

	private Stall sl1; 
	private Stall sl2; 
	private ArrayList<Stall> stallList; 

	private User user1; 
	private User user2; 
	private User user3; 
	private ArrayList<User> userList; 

	private Queue queue1; 
	private Queue queue2; 
	private Queue queue3; 
	private ArrayList<Queue> queueList; 

	private Order o1; 
	private Order o2; 
	private ArrayList<Order> orderList; 


	@Before 
	public void setUp() throws Exception { 
		// Menu 
		mn1 = new Menu("Dish 1", "Description 1", 10.50, "Ingredients 1", "Vegan"); 
		mn2 = new Menu("Dish 2", "Description 2", 8.75, "Ingredients 2", "Vegetarian"); 

		menuList = new ArrayList<Menu>(); 

		// Feedback 
		fb1 = new Feedback("Zongrong", 5, "Food was nice, especially the chicken drumstick!"); 
		fb2 = new Feedback("Yi Lun", 3, "The spaghetti was pretty okay, but could be better..."); 
		fb3 = new Feedback("Xue E", 2, "Oh my god, I hate the pepperoni pizza! Taste so bad..."); 

		feedbackList = new ArrayList<Feedback>(); 

		// Stall 
		sl1 = new Stall("Stall 1","AAA","1A","CHI"); 
		sl2 = new Stall("Stall 2","BBB","1B","MLY"); 
		new Stall("Stall 3","CCC","1C","IND"); 

		stallList = new ArrayList<Stall>(); 

		// User 
		user1 = new User("Lew", "Lew111@gmail.com", 24681012); 
		user2 = new User("Pop", "Pop222@gmail.com", 12345678); 
		user3 = new User("Chill", "chill333@gmail.com", 87654321); 

		userList = new ArrayList<User>(); 

		// Queue 
		queue1 = new Queue("Q001","Stall A"); 
		queue2 = new Queue("Q002","Stall B"); 
		queue3 = new Queue("Q003","Stall C"); 

		queueList = new ArrayList<Queue>(); 

		// Order 
		o1 = new Order(1, "Spaghetti", 1); 
		o2 = new Order(2, "Pizza", 2); 

		orderList = new ArrayList<Order>(); 
	} 





	// ================================= Menu ================================= 
	@Test 
	public void testAddMenu() { 
		// Test adding a new menu 
		Menu menuToAdd = mn1; 
		C206_CaseStudy.addMenu(menuList, menuToAdd); 
		assertEquals("Test that menuList size is 1 after adding a menu.", 1, menuList.size()); 
		assertSame("Test that the added menu is the same as the menu in menuList.", menuToAdd, menuList.get(0)); 

		// Test adding a menu with duplicate dish name 
		C206_CaseStudy.addMenu(menuList, menuToAdd); 
		assertEquals("Test that menuList size remains 1 after adding a duplicate menu.", 1, menuList.size()); 
	} 

	@Test 
	public void testRetrieveAllMenu() { 
		// Prepare some menus for testing 
		C206_CaseStudy.addMenu(menuList, mn1); 
		C206_CaseStudy.addMenu(menuList, mn2); 
		String expectedOutput = "Dish 1     Description 1                  10.50      Ingredients 1 Vegan               \n" 
				+ "Dish 2     Description 2                  8.75       Ingredients 2 Vegetarian          \n"; 
		assertEquals("Test if the retrieveAllMenu method returns the expected output.", expectedOutput, 
				C206_CaseStudy.retrieveAllMenu(menuList)); 
	} 

	@Test 
	public void testDeleteMenu() {       
		menuList.add(new Menu("Dish 1", "Description 1", 10.50, "Ingredients 1", "Vegan"));
		// Test deleting an existing menu
		Menu menuToDelete = menuList.get(0); 
		assertTrue("Test if an existing menu can be deleted.", C206_CaseStudy.checkDeleteMenu(menuList, menuToDelete.getDishName()));        
		assertEquals("Test that menuList size is decreased by 1 after deleting a menu.", 1, menuList.size());
		
		// Test deleting a non-existing menu
		String nonExistingMenuName = "NonExistingDish";        assertFalse("Test if a non-existing menu cannot be deleted.", C206_CaseStudy.checkDeleteMenu(menuList, nonExistingMenuName));
		assertEquals("Test that menuList size remains the same after attempting to delete a non-existing menu.", 1, menuList.size());    }


	// ------------------------------ Feedback ----------------------------------
	@Test
	public void testAddFeedback() {
		// Feedback list is not null and it is empty
		assertNotNull("Test if there is valid feedbackList to add to", feedbackList);
		assertEquals("Test that the feedback list is empty", 0, feedbackList.size());



		// Given an empty list, after adding 1 item, the size of the list is 1
		feedbackList.add(fb1);
		assertEquals("Test that the feedback list has 1 item", 1, feedbackList.size());



		// Add an item
		feedbackList.add(fb2);
		assertEquals("Test that the feedback list has 2 items", 2, feedbackList.size());



		// The item just added is as same as the last item in the list
		assertEquals("Test that the last item in the list is the same as the added item", fb2, feedbackList.get(1));



		// Add an item that has missing detail
		Feedback fb_missing = new Feedback("", 2, "Food was bad.");
		feedbackList.add(fb_missing);
		assertEquals("Test that the feedback list has 3 items", 3, feedbackList.size());
	}


	@Test
	public void testViewFeedback() {
		// Test Case 1
		// Test if feedback list is not null and empty
		assertNotNull("Test if there is valid feedbackList to add to", feedbackList);
		assertEquals("Test that the feedback list is empty", 0, feedbackList.size());



		// Attempt to retrieve the feedback
		for (Feedback fb : feedbackList) {
			String allFeedback = fb.toString();



			String testOutput = "";
			// Test if the output is empty
			assertEquals("Test that nothing is displayed", testOutput, allFeedback);



			// Test Case 2
			feedbackList.add(fb1);
			feedbackList.add(fb2);
			// Test that the list is not empty
			assertEquals("Test that the feedback arraylist size is 2", 2, feedbackList.size());
			// Attempt to retrieve the feedback
			for (Feedback i : feedbackList) {
				System.out.println(i);
			}
			testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "Zongrong", 5,
					"Food was nice, especially the chicken drumstick!");
			testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "Yi Lun", 3,
					"The spaghetti was pretty okay, but could be better...");
			// Test if the output is correct
			assertEquals("Test that the output is correct", testOutput, allFeedback);



		}
	}


	@Test
	public void testDeleteFeedback() {
		// Test Case 1
		assertNotNull("Test if there is valid feedbackList to add to", feedbackList);
		assertEquals("Test that the feedback list is empty", 0, feedbackList.size());



		// Attempt to delete feedback when the list is empty
		feedbackList.remove(fb1);
		assertEquals("Test that nothing is deleted", 0, feedbackList.size());



		// Test Case 2
		feedbackList.add(fb1);
		feedbackList.add(fb2);
		feedbackList.add(fb3);



		// Test that the list is not empty
		assertEquals("Test that the feedback arraylist size is 3", 3, feedbackList.size());



		// Attempt to delete the first feedback
		feedbackList.remove(fb1);
		assertEquals("Test that the first feedback is deleted", 2, feedbackList.size());



		// Attempt to delete the last feedback
		feedbackList.remove(fb3);
		assertEquals("Test that the last feedback is deleted", 1, feedbackList.size());
	}


	// --------------------------- Stall ---------------------------
	@Test
	public void testaddStalls() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid stall arraylist to add to", stallList);
		assertEquals("Test that the stall arraylist is empty.", 0, stallList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addStalls(stallList, sl1);		
		assertEquals("Test that the stall arraylist size is 1.", 1, stallList.size());


		// Add an item
		C206_CaseStudy.addStalls(stallList, sl2);
		assertEquals("Test that the stall arraylist size is now 2.", 2, stallList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that stall is added to the end of the list.", sl2, stallList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addStalls(stallList, sl2);
		assertEquals("Test that the stall arraylist size is unchange.", 2, stallList.size());

		// Add an item that has missing detail
		Stall sl_missing = new Stall("STALL 1", "AAA", "1A", "");
		C206_CaseStudy.addStalls(stallList, sl_missing);
		assertEquals("Test that the Stall arraylist size is unchange.", 2, stallList.size());
	}

	@Test
	public void testRetrieveAllStalls() {
		// Test Case 1
		assertNotNull("Test if there is valid stall arraylist to add to", stallList);
		assertEquals("Test that the stall arraylist is empty.", 0, stallList.size());

		// Assuming sl1 and sl2 are instances of Stall
		Stall sl1 = new Stall("STALL 1", "AAA", "1A", "CHI");
		Stall sl2 = new Stall("STALL 2", "BBB", "1B", "MLY");

		// Add stalls to the list
		C206_CaseStudy.addStalls(stallList, sl1);
		C206_CaseStudy.addStalls(stallList, sl2);

		// Check that the stall ArrayList size is 2
		assertEquals("Test that Stall arraylist size is 2.", 2, stallList.size());

		// Attempt to retrieve the stalls
		String allStalls = C206_CaseStudy.retrieveAllStalls(stallList);
		String testOutput = String.format("%-10s %-20s %-20s %-5s\n", "STALL 1", "AAA", "1A", "CHI");
		testOutput += String.format("%-10s %-20s %-20s %-5s\n", "STALL 2", "BBB", "1B", "MLY");

		// Check that the display is correct
		assertEquals("Test that the display is correct.", testOutput, allStalls);
	}


	@Test
	public void testRetrievespecificStalls() {
		// Test Case 1: Test if stallList is not null and empty
		assertNotNull("Check if stallList is not null", stallList);
		assertEquals("Check that the stall ArrayList is empty.", 0, stallList.size());

		// Prepare stalls for testing
		Stall sl1 = new Stall("STALL 1", "AAA", "1A", "CHI");
		Stall sl2 = new Stall("STALL 2", "BBB", "1B", "MLY");

		// Add stalls to the list
		C206_CaseStudy.addStalls(stallList, sl1);
		C206_CaseStudy.addStalls(stallList, sl2);

		// Check that the stall ArrayList size is 2
		assertEquals("Test that the stall ArrayList size is 2.", 2, stallList.size());

		// Attempt to retrieve the specific stalls
		String specificStalls = C206_CaseStudy.retrievespecificStalls(stallList, "AAA"); // Replace "AAA" with the desired keyword
		String testOutput = String.format("%-10s %-20s %-20s %-10s\n", "STALL 1", "AAA", "1A", "CHI");

		// Check that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput.trim(), specificStalls.trim());
	}

	@Test
	public void testDeleteStall() {
		// Test Case 1
		ArrayList<Stall> stallList = new ArrayList<>();
		Stall sl1 = new Stall("STALL 1", "AAA", "1A", "CHI");
		Stall sl2 = new Stall("STALL 2", "BBB", "1B", "MLY");
		stallList.add(sl1);
		stallList.add(sl2);

		// Attempt to delete an existing stall
		C206_CaseStudy.deleteStall(stallList, "STALL 1");

		// Check that the stall was deleted and list size decreased
		assertEquals("Test that the stall list size is 1 after deleting an existing stall.", 1, stallList.size());

		// Test Case 2
		// Attempt to delete a non-existing stall
		C206_CaseStudy.deleteStall(stallList, "NON_EXISTING_STALL");

		// Check that the list size remains the same
		assertEquals("Test that the stall list size remains 1 after attempting to delete a non-existing stall.", 1, stallList.size());
	}

	// ------------------------- User ----------------------------------
	@Test
	public void testAddUser() {
		assertNotNull("Test if there is valid userlist to add to", userList);
		assertEquals("Test that the user arraylist is empty.", 0, userList.size());

		// Given an empty list, after adding 1 user, the size of the list is 1
		userList.add(user1);
		assertEquals("Test that the user list has 1 user", 1, userList.size());

		// Add another user
		userList.add(user2);
		assertEquals("Test that the user list has 2 users", 2, userList.size());


		// The user just added is the same as the last user in the list
		assertEquals("Test that the last user in the list is the same as the added user", user2, userList.get(1));
	}

	@Test
	public void testViewAllUsers() {
		assertNotNull("Test if there is valid arrayList to add to", userList);
		assertEquals("Test that the user list is empty", 0, userList.size());



		// Attempt to retrieve the feedback
		for (User us : userList) {
			String allUser = us.toString();



			String testOutput = "";
			// Test if the output is empty
			assertEquals("Test that nothing is displayed", testOutput, allUser);

			// Add users to the list
			userList.add(user1);
			userList.add(user2);

			// Test that the list is not empty
			assertEquals("Test that the user arraylist size is 2", 2, userList.size());

			// Attempt to retrieve the users
			for (User user : userList) {
				String allUsers = user.toString();
				System.out.println(allUsers);
			}
		}
	}

	@Test
	public void testDeleteUser() {
		assertNotNull("Test if there is valid userList to add to", userList);
		assertEquals("Test that the user list is empty", 0, userList.size());

		// Attempt to delete user when the list is empty
		userList.remove(user1);
		assertEquals("Test that nothing is deleted", 0, userList.size());

		// Add users to the list
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);

		// Test that the list is not empty
		assertEquals("Test that the user arraylist size is 3", 3, userList.size());

		// Attempt to delete a user
		userList.remove(user2);
		assertEquals("Test that the user is deleted", 2, userList.size());
	}


	// ================================= Queue ================================= 
	@Test 
	public void testAddQueue() {
		assertNotNull("Test if there is valid queuelist to add to", queueList);
		assertEquals("Test that the queue arraylist is empty.", 0, queueList.size());

		// Given an empty list, after adding 1 queue, the size of the list is 1
		queueList.add(queue1);
		assertEquals("Test that the user list has 1 queue", 1, queueList.size());

		// Test adding another queue
		queueList.add(queue2);
		assertEquals("Test that the queue list has 2 queues", 2, queueList.size());


		// Test adding duplicate queue
		assertEquals("Test that the last queue in the list is the same as the added queue", queue2, queueList.get(1));
	}


	@Test 
	public void testViewAllQueues() { 
		ArrayList<Queue> queueList = new ArrayList<>(); 

		// Test viewing all queues when the list is empty 
		C206_CaseStudy.viewAllqueueList(queueList); // This should print "No queueList available." 

		// Test viewing all queues when there are queues in the list 
		queueList.add(queue1); 
		queueList.add(queue1); 
		C206_CaseStudy.viewAllqueueList(queueList); 
		// Expected output: "queueList in Canteen :\nQ001: Stall A\nQ002: Stall B" 
	} 

	@Test
	public void testDeleteQueue() {
		// Test Case 1
		assertNotNull("Test if there is valid queueList to add to", queueList);
		assertEquals("Test that the queue list is empty", 0, queueList.size());

		// Attempt to delete queue when the list is empty
		queueList.remove(queue1);
		assertEquals("Test that nothing is deleted", 0, queueList.size());



		// Test Case 2
		queueList.add(queue1);
		queueList.add(queue2);
		queueList.add(queue3);


		// Test that the list is not empty
		assertEquals("Test that the queue arraylist size is 3", 3, queueList.size());

		// Attempt to delete the first feedback
		queueList.remove(queue1);
		assertEquals("Test that the first queue is deleted", 2, queueList.size());

		// Attempt to delete the last feedback
		queueList.remove(queue3);
		assertEquals("Test that the last queue is deleted", 1, queueList.size());
	}


	// ================================= Order ================================= 
	@Test 
	public void testViewAllOrder() { 

		// Test viewing all queues when the list is empty 
		C206_CaseStudy.viewAllOrders(orderList); // This should print "No orderList available." 

		// Test viewing all queues when there are queues in the list 
		orderList.add(o1); 
		orderList.add(o2); 
		C206_CaseStudy.viewAllOrders(orderList); 


	} 

	// written by chuying
	@Test
	public void testaddOrder() {
		// Order list is not null and it is empty
		assertNotNull("Test if there is valid order arraylist to add to", orderList);
		assertEquals("Test that the order arraylist is empty.", 0, orderList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addOrder(orderList, o1);		
		assertEquals("Test that the order arraylist size is 1.", 1, orderList.size());


		// Add an order
		C206_CaseStudy.addOrder(orderList, o2);
		assertEquals("Test that the order arraylist size is now 2.", 2, orderList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that order is added to the end of the list.", o2, orderList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addOrder(orderList, o2);
		assertEquals("Test that the order arraylist size is unchange.", 2, orderList.size());


	}

	@Test 
	public void testDeleteOrder() { 
		assertNotNull("Test if there is a valid Order arraylist to add to", orderList); 
		assertEquals("Test that the Order arraylist is empty.", 0, orderList.size()); 

		// Add orders to the list 
		orderList.add(o1); 

		// Test that the list is not empty 
		assertEquals("Test that the Order arraylist size is 1.", 1, orderList.size()); 

		// Attempt to delete an existing order 
		C206_CaseStudy.checkDeleteOrder(orderList, 1); 
		assertEquals("Test that the order list size is 1 after deleting an existing order.", 1, orderList.size()); 

		// Attempt to delete a non-existing order 
		C206_CaseStudy.checkDeleteOrder(orderList, 3); // This should print "Order ID 3 not found." 
		assertEquals("Test that the order list size remains 1 after attempting to delete a non-existing order.", 1, 
				orderList.size()); 
	} 



	@After
	public void tearDown() {
		mn1 = null;
		mn2 = null;
		menuList = null;

		fb1 = null;
		fb2 = null;
		fb3 = null;
		feedbackList = null;

		sl1 = null;
		sl2 = null;
		stallList = null;

		user1 = null;
		user2 = null;
		user3 = null;
		userList = null;


		queue1 = null;
		queue2 = null;
		queue3 = null;
		queueList = null;
	}
}
