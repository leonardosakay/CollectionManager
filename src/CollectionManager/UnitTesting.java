package CollectionManager;

import java.util.ArrayList;

public class UnitTesting {
	
    public static void main(String[] args) {
        // Execute each test method
    	testRecipeGettersAndSetters();
    	testRecipeName();
        testServings();
        testRecipeCalories();
        testRecipeCost();
        testIngredientsGettersAndSetters();
        testConstructors();
        testAddRecipe();
        testRemoveRecipe();
        testUpdateRecipe();
       
    }

    // Test the constructors of the RecipeBox class
    public static void testConstructors() {
        RecipeBox recipeBox = new RecipeBox();
        // Check if the default constructor creates an empty list of recipes
        if (recipeBox.getListOfRecipes().size() == 0) {
            System.out.println("Default constructor test passed.");
        } else {
            System.out.println("Default constructor test failed.");
        }
    }

    // Test the addRecipe() method of the RecipeBox class
    public static void testAddRecipe(){
    	
        RecipeBox recipeBox = new RecipeBox();
        recipeBox.addRecipe();
        // Check if a new recipe was added to the list of recipes
        if (recipeBox.getListOfRecipes().size() == 1) {
            System.out.println("Add recipe test passed.");
        } else {
            System.out.println("Add recipe test failed.");
        }
    }

    // Test the removeRecipe() method of the RecipeBox class
    public static void testRemoveRecipe() {
        RecipeBox recipeBox = new RecipeBox();
        recipeBox.addRecipe();
        recipeBox.removeRecipe(0);
        // Check if the recipe was removed from the list of recipes
        if (recipeBox.getListOfRecipes().size() == 0) {
            System.out.println("Remove recipe test passed.");
        } else {
            System.out.println("Remove recipe test failed.");
        }
    }

    // Test the updateRecipe() method of the RecipeBox class
    public static void testUpdateRecipe() {
        RecipeBox recipeBox = new RecipeBox();
        recipeBox.addRecipe();
        Recipe originalRecipe = recipeBox.getListOfRecipes().get(0);
        recipeBox.updateRecipe(0);
        Recipe updatedRecipe = recipeBox.getListOfRecipes().get(0);

        // Check if the original recipe and updated recipe are different
        if (!originalRecipe.equals(updatedRecipe)) {
            System.out.println("Update recipe test passed.");
        } else {
            System.out.println("Update recipe test failed.");
        }
    }
    

    public static void testIngredientsGettersAndSetters() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName("Sugar");
        ingredient.setUnitMeasurement("Teaspoon");
        ingredient.setIngredientAmount(3.0f);
        ingredient.setTotalCalories(48.0);
        ingredient.setNumCaloriesPerUnitMeasurement(16.0);
        ingredient.setIngredientPrice(0.15);

        if (ingredient.getIngredientName().equals("Sugar") &&
            ingredient.getUnitMeasurement().equals("Teaspoon") &&
            ingredient.getIngredientAmount() == 3.0f &&
            ingredient.getTotalCalories() == 48.0 &&
            ingredient.getNumCaloriesPerUnitMeasurement() == 16.0 &&
            ingredient.getIngredientPrice() == 0.15) {
            System.out.println("Getters and setters test passed.");
        } else {
            System.out.println("Getters and setters test failed.");
        }
    }
    

    public static void testRecipeName() {
        Recipe recipe = new Recipe();
        recipe.setRecipeName("Pasta");

        String expected = "Pasta";
        String actual = recipe.getRecipeName();

        if (expected.equals(actual)) {
            System.out.println("testRecipeName PASSED");
        } else {
            System.out.println("testRecipeName FAILED");
        }
    }

    public static void testServings() {
        Recipe recipe = new Recipe();
        recipe.setServings(4);

        int expected = 4;
        int actual = recipe.getServings();

        if (expected == actual) {
            System.out.println("testServings PASSED");
        } else {
            System.out.println("testServings FAILED");
        }
    }

    public static void testRecipeCalories() {
        Recipe recipe = new Recipe();
        recipe.setTotalRecipeCalories(600);

        double expected = 600;
        double actual = recipe.getTotalRecipeCalories();

        if (expected == actual) {
            System.out.println("testRecipeCalories PASSED");
        } else {
            System.out.println("testRecipeCalories FAILED");
        }
    }

    public static void testRecipeCost() {
        Recipe recipe = new Recipe();
        recipe.setRecipeCost(10.0);

        double expected = 10.0;
        double actual = recipe.getRecipeCost();

        if (expected == actual) {
            System.out.println("testRecipeCost PASSED");
        } else {
            System.out.println("testRecipeCost FAILED");
        }
    }

    public static void testRecipeGettersAndSetters() {
        // Create a new Recipe instance
        Recipe testRecipe = new Recipe();

        // Test setters and getters
        testRecipe.setRecipeName("Chocolate Cake");
        testRecipe.setServings(8);
        testRecipe.setTotalRecipeCalories(4000);
        testRecipe.setRecipeCost(15.00);

        ArrayList<Ingredient> testIngredients = new ArrayList<>();
        testIngredients.add(new Ingredient("Flour", "cup", 2, 100, 200.0, 1.50));
        testRecipe.setRecipeIngredients(testIngredients);

        // Check the results
        boolean passed = true;

        if (!testRecipe.getRecipeName().equals("Chocolate Cake")) {
            System.out.println("Failed: Recipe name");
            passed = false;
        }

        if (testRecipe.getServings() != 8) {
            System.out.println("Failed: Servings");
            passed = false;
        }

        if (testRecipe.getTotalRecipeCalories() != 4000) {
            System.out.println("Failed: Total recipe calories");
            passed = false;
        }

        if (testRecipe.getRecipeCost() != 15.00) {
            System.out.println("Failed: Recipe cost");
            passed = false;
        }

        if (!testRecipe.getRecipeIngredients().get(0).getIngredientName().equals("Flour")) {
            System.out.println("Failed: Ingredient name");
            passed = false;
        }

        if (passed) {
            System.out.println("All Recipes Getters and Setters tests passed!");
        } else {
            System.out.println("Some tests failed!");
        }
    }
    
    
}