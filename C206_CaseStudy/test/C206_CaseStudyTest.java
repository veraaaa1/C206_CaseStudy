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

    @Before
    public void setUp() throws Exception {
    	mn1 = new Menu("Dish 1", "Description 1", 10.50, "Ingredients 1", "Vegan");
        mn2 = new Menu("Dish 2", "Description 2", 8.75, "Ingredients 2", "Vegetarian");
    	
        menuList = new ArrayList<Menu>();
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

    // Add more test cases for other methods as needed

    @After
    public void tearDown() {
    	mn1 = null;
    	mn2 = null;
        menuList = null;
    }
}
