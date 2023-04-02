package CollectionManager;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This program utilizes input from users to store recipe and ingredient data, then it utilizes a
 * custom method to print the recipe to the screen. 
 * @author Leonardo Bartlett
 * @version 1.0
 * Date: 3/19/2023
 */ 

public class Recipe {
	Scanner scnr = new Scanner(System.in);

	// Declaring class variables
	private String recipeName;
	private int servings;
	private ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient>();
	private double totalRecipeCalories;
    private double totalRecipeCost;


    /**
     * Sets the recipe name.
     * @param receipeName The name of the recipe.
     */
    public void setRecipeName(String receipeName) {
        this.recipeName = receipeName;
    }

    /**
     * Gets the recipe name.
     * @return The name of the recipe.
     */
    public String getRecipeName() {
        return this.recipeName;
    }

    /**
     * Sets the number of servings.
     * @param servings The number of servings.
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * Gets the number of servings.
     * @return The number of servings.
     */
    public int getServings() {
        return this.servings;
    }

    /**
     * Sets the total recipe calories.
     * @param totalRecipeCalories The total calories of the recipe.
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }

    /**
     * Gets the total recipe calories.
     * @return The total calories of the recipe.
     */
    public double getTotalRecipeCalories() {
        return this.totalRecipeCalories;
    }

    /**
     * Sets the recipe ingredients.
     * @param recipeIngredientsTwo The list of ingredients.
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredientsTwo) {
        this.recipeIngredients = recipeIngredientsTwo;
    }

    /**
     * Gets the recipe ingredients.
     * @return The list of ingredients.
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return this.recipeIngredients;
    }

    /**
     * Sets the total recipe cost.
     * @param totalRecipeCost The total cost of the recipe.
     */
    public void setRecipeCost(double totalRecipeCost) {
        this.totalRecipeCost = totalRecipeCost;
    }

    /**
     * Gets the total recipe cost.
     * @return The total cost of the recipe.
     */
    public double getRecipeCost() {
        return this.totalRecipeCost;
    }

    /**
     * Default constructor.
     */
	public Recipe() {
		this.recipeName = "";
		this.servings = 0; 
		this.recipeIngredients = new ArrayList<Ingredient>();
		this.totalRecipeCalories = 0.0;

	}
	
	  /**
     * Constructor that takes all class parameters.
     * @param recipeName The name of the recipe.
     * @param servings The number of servings.
     * @param recipeIngredients The list of ingredients.
     * @param totalRecipeCalories The total calories of the recipe.
     * @param totalRecipeCost The total cost of the recipe.
     */
	public Recipe(String recipeName, int servings, 
			ArrayList<Ingredient> recipeIngredients, double totalRecipeCalories, double totalRecipeCost) 

	{
		this.recipeName = recipeName;
		this.servings = servings;
		this.recipeIngredients = recipeIngredients;
		this.totalRecipeCalories = totalRecipeCalories;
		this.totalRecipeCost = totalRecipeCost;
	}
    /**
     * Prints the total cost of the recipe.
     */
	public void printRecipeCost()
	{
		
		System.out.println("Total cost of the recipe: $" + getRecipeCost());
		
		
	}
	
    /**
     * Prints the complete recipe information, including the name, servings,
     * ingredients, calories per serving, and total cost.
     */

	public void printRecipe() {
		Ingredient ingredientList = new Ingredient();
		//Initializing a variable to calculate the calories per servings.
		double singleServingCalories = getTotalRecipeCalories() / (double)getServings() ;
		double totalCaloriesPerRecipe = getTotalRecipeCalories() * (double)getServings();
		// Display recipe information: Name of recipe, servings, ingredients and calories per servings
		System.out.println ("*********************************");
		System.out.println("Recipe: " + getRecipeName());
		System.out.println ("*********************************");
		System.out.println("Serves: " + getServings());
		System.out.println("Ingredients:");
		for (int i = 0; i < getRecipeIngredients().size(); i++) {

			ingredientList = getRecipeIngredients().get(i);

			System.out.println("- " +ingredientList.getIngredientAmount()+ 
					" " +ingredientList.getUnitMeasurement() + " of " + ingredientList.getIngredientName());
		}
		System.out.println("Total calories per serving: " + (int)singleServingCalories);
		System.out.println("Total calories for the recipe is: " + (int)totalCaloriesPerRecipe);
		printRecipeCost();
	}

	  /**
     * Creates a new Recipe instance by prompting the user for input.
     * @return A new Recipe object with user-provided values.
     */
	public Recipe createNewRecipe() {

		double totalRecipeCalories = 0;
		double totalRecipeCost = 0;
		boolean addMoreIngredients = true;
		int servings = 0;
		String validInput = "";
		boolean controlVariable = false;
		ArrayList <Ingredient> recipeIngredients = new ArrayList<Ingredient>();
		
		Ingredient newIngredient = new Ingredient();

		System.out.println("Please enter the recipe name: ");
		String recipeName = scnr.nextLine();

		while(!recipeName.matches("[a-zA-Z -]+")){

			System.out.println("Please enter a valid recipe name!");
			recipeName =  scnr.nextLine();
		}

		//Accept only numbers for the servings variable
		do {
			System.out.println("Please enter the number of servings: ");
			while (!scnr.hasNextInt() ) {
				System.out.println("Please enter a valid number!");
				scnr.next();
			}
			servings = scnr.nextInt();
			controlVariable = true;

		} while (!controlVariable);

		// Get ingredients from user

		do {
			System.out.println("Would you like to add a new ingredient (Y or N): ");
			validInput = scnr.next();
			// Add new ingredient to the recipe
			if (validInput.toLowerCase().equals("y")) {

				recipeIngredients.add(newIngredient.addNewIngredient());
				totalRecipeCalories += newIngredient.getTotalCalories() ;
				totalRecipeCost += newIngredient.getIngredientPrice();
			}
			// Stop adding ingredients to the recipe
			else if (validInput.toLowerCase().equals("n")) {
				addMoreIngredients = false;

				// Ask for valid input
			}
			else {
				System.out.println("Please enter a valid input (Y or N)");

			}
		} while (addMoreIngredients);
        // Set recipe properties. 
		setRecipeName(recipeName);
		setServings(servings);
		setRecipeIngredients(recipeIngredients);
		setTotalRecipeCalories(totalRecipeCalories);
		setRecipeCost(totalRecipeCost);
		

		// Create a new Recipe object and return it

		Recipe newRecipe = new Recipe(recipeName, 
				servings, recipeIngredients, totalRecipeCalories, totalRecipeCost);
	
		return newRecipe;
	}
}


