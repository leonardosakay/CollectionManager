package SteppingStones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a recipe box containing a list of recipes.
 * It provides methods to adding, removing, updating, and displaying recipes.
 * The class also contains a main method that serves as the entry point for a console-based 
 * user interface. The user can interact with the program using a menu system to perform various 
 * operations, such as adding, removing, updating, or displaying recipes. 
 * The menu system is driven by a switch statement that processes user input to execute
 * the desired operation. The program continues running until the user chooses to exit.
 * 
 * @author Leonardo Bartlett
 * @version 1.0
 * @Date 3/22/2023
 */
public class RecipeBox {

	private ArrayList<Recipe> listOfRecipes;

	/**
	 * Sets the list of recipes.
	 * @param listOfRecipes the list of recipes to set.
	 */
	public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	}

	/**
	 * Returns the list of recipes.
	 * @return the list of recipes.
	 */
	public ArrayList<Recipe> getListOfRecipes() {
		return this.listOfRecipes;
	}

	/**
	 * Default constructor. Initializes an empty list of recipes.
	 */
	public RecipeBox() {
		this.listOfRecipes = new ArrayList<>();
	}

	/**
	 * Constructor with a given list of recipes.
	 * @param listOfRecipes the list of recipes to initialize.
	 */
	public RecipeBox(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	}

	/**
	 * Prints the details of the selected recipe.
	 * @param selectedRecipe the recipe to print details for.
	 */
	public void printAllRecipeDetails(Recipe selectedRecipe) {
		for (int i = 0; i < listOfRecipes.size(); i++) {
			Recipe recipe = listOfRecipes.get(i);
			if (recipe.equals(selectedRecipe)) {
				recipe.printRecipe();
				return;
			}
		}
		System.out.println("Recipe not found.");
	}

	/**
	 * Prints the names of all recipes in the recipe box.
	 */
	public void printAllRecipeNames() {
		int numOfRecipe = 0;
       
		//Display message if ArrayList is empty 
		if ( listOfRecipes.size() == 0) {
			System.out.println("No recipes avaliable! \n");
		}
		// Display the list of Recipes
		else {
			System.out.println("************************");
			System.out.println("*    List Of Recipes   *");
			System.out.println("************************");
			
			for (int i = 0; i < listOfRecipes.size(); i++) {
				numOfRecipe++;
				System.out.println(numOfRecipe + "-  " + listOfRecipes.get(i).getRecipeName());
				
			}
		}
	}

	/**
	 * Adds a new recipe to the recipe box.
	 */
	public void addRecipe() {
		Recipe newRecipe = new Recipe();
		listOfRecipes.add(newRecipe.createNewRecipe());
	}

	/**
	 * Removes a recipe from the recipe box.
	 * @param index the index of the recipe to remove.
	 */
	public void removeRecipe(int index) {
		if (index >= 0 && index < listOfRecipes.size()) {
			listOfRecipes.remove(index);
			System.out.println("Recipe "+ listOfRecipes.get(index).getRecipeName()+ " removed successfully!");
		} else {
			System.out.println("Invalid index. Recipe not removed.");
		}
	}

	/**
	 * Updates a recipe in the recipe box.
	 * @param index the index of the recipe to update.
	 */
	public void updateRecipe(int index) {
		if (index >= 0 && index < listOfRecipes.size()) {
			Recipe updatedRecipe = new Recipe();
			listOfRecipes.set(index, updatedRecipe.createNewRecipe());
			System.out.println("Recipe updated successfully.");
		} else {
			System.out.println("Invalid index. Recipe not updated.");
		}
	}
	
	// Prompt user to press Enter to go back to menu
	public static void pressEnterForMenu() {
	    System.out.println("\nPress Enter to go back to the menu!");
	    try {
	        System.in.read();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	/**
	 * The main method that drives the recipe box program.
	 * @param args command line arguments (not used).
	 */
	public static void main(String[] args) {
		RecipeBox recipeBox = new RecipeBox();
		Scanner menuScnr = new Scanner(System.in);

		String input;


		do {
			// Display the menu options
			System.out.println("********************************"  );
			System.out.println("**             Menu           **"  );
			System.out.println("********************************"  );
			System.out.println("1. Add Recipe\n" + "2. Print Recipe Names\n" +
					"3. Print Recipe Details\n" + "4. Remove Recipe\n" + "5. Update Recipe\n" +
					"6. Exit\n" + "\nPlease select a menu item:");
			input = menuScnr.next();

			// Process user input using a switch statement
			switch (input) {
			case "1":
				// Add a new recipe to the recipe box
				recipeBox.addRecipe();
				break;
			case "2":
				//Display all recipes 
				recipeBox.printAllRecipeNames();
				   //Go back to the menu when user presses enter
			    pressEnterForMenu();

				break;

			case "3":
			    System.out.println("Select recipe (Enter number)?");
			    // Display all recipes 
			    recipeBox.printAllRecipeNames();

			    int selectedRecipeIndex = menuScnr.nextInt() - 1;
			    if (selectedRecipeIndex >= 0 && selectedRecipeIndex < recipeBox.getListOfRecipes().size()) {
			        Recipe selectedRecipe = recipeBox.getListOfRecipes().get(selectedRecipeIndex);
			        recipeBox.printAllRecipeDetails(selectedRecipe);
			    } else {
			        System.out.println("Invalid index. Please try again.");
			    }
			    //Go back to the menu when user presses enter
			    pressEnterForMenu();

			    break;
		
			case "4":
			    // Remove a recipe from the recipe box
			    System.out.println("Select recipe to remove (Enter number):");
			    recipeBox.printAllRecipeNames();
			    int recipeToRemoveIndex = menuScnr.nextInt() - 1;
			    if (recipeToRemoveIndex >= 0 && recipeToRemoveIndex < recipeBox.getListOfRecipes().size()) {
			        recipeBox.removeRecipe(recipeToRemoveIndex);
			    } else {
			        System.out.println("Invalid index. Recipe not removed.");
			    }
			    //Go back to the menu when user presses enter
			    pressEnterForMenu();

			    break;

			case "5":
			    // Update a recipe in the recipe box
			    System.out.println("Select recipe to update (Enter number):");
			    recipeBox.printAllRecipeNames();
			    int recipeToUpdateIndex = menuScnr.nextInt() - 1;
			    if (recipeToUpdateIndex >= 0 && recipeToUpdateIndex < recipeBox.getListOfRecipes().size()) {
			        recipeBox.updateRecipe(recipeToUpdateIndex);
			    } else {
			        System.out.println("Invalid index. Recipe not updated.");
			    }
			    break;
			case "6":
			 //Exit
				System.out.println("Exited successfully!");
				break;
				// Handle invalid user input
			default:
				System.out.println("Invalid input. Please try again.");
				break;
				
			}
		} while (!input.equals("6"));

		// Close the scanner to prevent resource leaks
		menuScnr.close();
	}
}
