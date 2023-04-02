package CollectionManager;

import java.util.ArrayList;

public class RecipeBoxDriver {
	  public static void main(String[] args) {
	        // Create instances of Recipe class
	        Recipe pancakeRecipe = new Recipe();
	        Recipe scrambledEggsRecipe = new Recipe();
	        Recipe spaghettiRecipe = new Recipe();

	        // Create an ArrayList to store the recipes
	        ArrayList<Recipe> initialRecipes = new ArrayList<>();
	        initialRecipes.add(pancakeRecipe);
	        initialRecipes.add(scrambledEggsRecipe);
	        initialRecipes.add(spaghettiRecipe);

	        // Create a RecipeBox object with the initial recipes
	        RecipeBox myRecipeBox = new RecipeBox(initialRecipes);

	        // Add a new recipe to the RecipeBox
	        myRecipeBox.addRecipe();

	        // Print all recipe names
	        myRecipeBox.printAllRecipeNames();

	        // Print details for the first recipe
	        Recipe firstRecipe = myRecipeBox.getListOfRecipes().get(0);
	        myRecipeBox.printAllRecipeDetails(firstRecipe);

	        // Remove the second recipe from the RecipeBox
	        myRecipeBox.removeRecipe(1);

	        // Update the first recipe in the RecipeBox
	        myRecipeBox.updateRecipe(0);

	        // Print all recipe names after removing and updating recipes
	        myRecipeBox.printAllRecipeNames();
	    }
}
