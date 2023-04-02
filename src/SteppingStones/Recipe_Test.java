package SteppingStones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Unit tests that ensure validity of the Ingredient and Recipe class 
 * 
 * @author Leonardo Bartlett
 * @version 1.0
 * Date: 3/19/2023
 */
public class Recipe_Test {
	

}
/**
public class Recipe_Test {
}

	
	public static void main(String[] args) {
		 Scanner scnr = new Scanner (System.in);
		 String option = "";
		 // Create an ArrayList to store ingredients of the recipe
		 ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient>();

		 // Create an ingredient object and set its properties

		 Ingredient ingredient1 = new Ingredient();
		 ingredient1.setIngredientAmount(5);
		 ingredient1.setIngredientName("Sugar");
		 ingredient1.setNumCaloriesPerUnitMeasurement(100);
		 ingredient1.setUnitMeasurement("Cups");
		 ingredient1.setIngredientPrice(3.50);

		 Ingredient ingredient2 = new Ingredient();
		 ingredient2.setIngredientAmount(2);
		 ingredient2.setIngredientName("Chocolate");
		 ingredient2.setNumCaloriesPerUnitMeasurement(100);
		 ingredient2.setUnitMeasurement("Cups");
		 ingredient2.setIngredientPrice(4.50);
		 // Add the ingredient to the ArrayList of recipe ingredients

		 recipeIngredients.add(ingredient1);
		 recipeIngredients.add(ingredient2);

		 // Create a recipe object and set its properties, including the ArrayList of ingredients for Unit testing
		 Recipe newRecipe1 = new Recipe ("Brownies", 4, 
				 recipeIngredients, 700, 9.0);	

		 System.out.println("Testing Menu (Type 1 or 2");
		 System.out.println("1 - Unit Testing (Classes) ");
		 System.out.println("2 - Create a new Recipe and Print Recipe ");
		 option = scnr.nextLine();

		 if (option.equals("1")) {

			 ArrayList<String> expectedOutput = new ArrayList<String>();
			 expectedOutput.add("Sugar");
			 expectedOutput.add("Chocolate");

			 // Start Unit Test 
			 System.out.println("Beginning tests. \n");
			 //Test calories per serving 
			 int caloriesPerServingTest = (int) (newRecipe1.getTotalRecipeCalories() / newRecipe1.getServings());

			 //Test Calories per serving 
			 if (caloriesPerServingTest != 175) {
				 System.out.println("FAILED caloriesPerServing for 700, 4");
			 }
			 else {
				 System.out.println("PASSED caloriesPerServing for 700, 4");
			 }

			 //Test total calories per Recipe 
			 int totalCaloriesPerRecipeTest = (int) (newRecipe1.getTotalRecipeCalories() * newRecipe1.getServings());

			 if (totalCaloriesPerRecipeTest != 2800) {
				 System.out.println("FAILED totalCaloriesPerRecipe for 700, 4");
			 }
			 else {
				 System.out.println("PASSED totalCaloriesPerRecipe for 700, 4");
			 }
			 
             //Test total cost per recipe 
			 double totalRecipeCost = newRecipe1.getRecipeCost();
			 
			 if (totalRecipeCost != 8.0) {
				 System.out.println("FAILED totalRecipeCost for 3.50, 4.50");
			 }
			 else {
				 System.out.println("PASSED totalCaloriesPerRecipe for 3.50, 4.50");
			 }


			 // Print hard coded recipe 

			 newRecipe1.printRecipe();

		 }

		 else if (option.equals("2")) {
			 Recipe newRecipe2 = new Recipe();
			 //Create new recipe
			 newRecipe2.createNewRecipe();
			 //Print recipe;2  
			 newRecipe2.printRecipe();
		 }
		 else {
			 System.out.println("Please select 1 or 2!");

		 }

		 scnr.close();

	 }

}
*/

