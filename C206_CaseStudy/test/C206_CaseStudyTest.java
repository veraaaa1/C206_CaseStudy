
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
	private Stall sl3;
	private ArrayList<Stall> stallList;

	@Before
	public void setUp() throws Exception {
		mn1 = new Menu("Dish 1", "Description 1", 10.50, "Ingredients 1", "Vegan");
		mn2 = new Menu("Dish 2", "Description 2", 8.75, "Ingredients 2", "Vegetarian");

		menuList = new ArrayList<Menu>();

		fb1 = new Feedback("Zongrong", 5, "Food was nice, especially the chicken drumstick!");
		fb2 = new Feedback("Yi Lun", 3, "The spaghetti was pretty okay, but could be better...");
		fb3 = new Feedback("Xue E", 2, "Oh my god, I hate the pepperoni pizza! Taste so bad...");

		feedbackList = new ArrayList<Feedback>();

		sl1 = new Stall("Stall 1","AAA","1A","CHI");
		sl2 = new Stall("Stall 2","BBB","1B","MLY");
		sl3 = new Stall("Stall 3","CCC","1C","IND");

		stallList = new ArrayList<Stall>();
	}



	@Test
	public void testAddMenu() {
		// Test adding a new menu
		Menu menuToAdd = mn1;
		C206_CaseStudy.addMenu(menuList, menuToAdd);
		C206_CaseStudy.addMenu(menuList, mn2);
		assertEquals("Test that menuList size is 1 after adding a menu.", 1, menuList.size());
		assertSame("Test that the added menu is the same as the menu in menuList.", menuToAdd, menuList.get(0));

		// Test adding a menu with duplicate dish name
		C206_CaseStudy.addMenu(menuList, menuToAdd);
		assertEquals("Test that menuList size remains 1 after adding a duplicate menu.", 1, menuList.size());
	}

	@Test
	public void testRetrieveAllMenu() {
		// Prepare some menus for testing

		String expectedOutput = "Dish 1     Description 1                 10.50       Ingredients 1      Vegan             \n"
				+ "Dish 2     Description 2                 8.75         Ingredients 2      Vegetarian        \n";
		assertEquals("Test if the retrieveAllMenu method returns the expected output.", expectedOutput,
				C206_CaseStudy.retrieveAllMenu(menuList));
	}

	@Test
	public void testDeleteMenu() {
		// Prepare some menus for testing
		menuList.add(new Menu("Dish 1", "Description 1", 10.50, "Ingredients 1", "Vegan"));
		menuList.add(new Menu("Dish 2", "Description 2", 8.75, "Ingredients 2", "Vegetarian"));

		// Test deleting an existing menu
		assertTrue("Test if an existing menu can be deleted.", C206_CaseStudy.doDeleteMenu(menuList, "Dish 1"));
		assertEquals("Test that menuList size is 1 after deleting a menu.", 1, menuList.size());

		// Test deleting a non-existing menu
		assertFalse("Test if a non-existing menu cannot be deleted.", C206_CaseStudy.doDeleteMenu(menuList, "Dish 3"));
		assertEquals("Test that menuList size remains 1 after attempting to delete a non-existing menu.", 1, menuList.size());
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
		String testOutput = String.format("%-10s %-10s %-10s %-10s\n", "STALL 1", "AAA", "1A", "CHI");
		testOutput += String.format("%-10s %-10s %-10s %-10s\n", "STALL 2", "BBB", "1B", "MLY");

		// Check that the display is correct
		assertEquals("Test that the display is correct.", testOutput, allStalls);
	}


	@Test
	public void testRetrievespecificStalls() {
	    // Test Case 1: Test if stallList is not null and empty
	    assertNotNull("Test if there is a valid stall ArrayList to add to", stallList);
	    assertEquals("Test that the stall ArrayList is empty.", 0, stallList.size());

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
	    String testOutput = String.format("%-10s %-10s %-10s %-10s\n", "STALL 1", "AAA", "1A", "CHI");

	    // Check that the details are displayed correctly
	    assertEquals("Test that the display is correct.", testOutput, specificStalls);
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
		sl3 = null;
		stallList = null;
	}
}
>>>>>>> branch 'master' of https://github.com/veraaaa1/C206_CaseStudy.git
