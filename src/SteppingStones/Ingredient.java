/**
 * This program utilizes input from users to store ingredient data.
 * Additionally, it calculates the total calories of the ingredient. 
 * 
 * @author Leonardo Bartlett
 * @version 1.0
 * Date: 3/3/2023
 */
package SteppingStones;
import java.util.Scanner;

public class Ingredient {

	/**
	 * @param args the command line arguments
	 * @return 
	 */
	static Scanner scnr = new Scanner(System.in);

	// Initializing and declaring variables
	private String ingredientName = "";
	private String unitMeasurement = "";
	private float ingredientAmount = 0.0f;
	private double numCaloriesPerUnitMeasurement= 0;
	private double totalCalories = 0.0;
    private double ingredientPrice = 0.0;

    /**
     * Sets the name of the ingredient.
     * 
     * @param ingredientName The name of the ingredient.
     */
    public void setIngredientName(String ingredientName) {
    	this.ingredientName = ingredientName;
    }

    /**
     * Gets the name of the ingredient.
     * 
     * @return The name of the ingredient.
     */
    public String getIngredientName() {
    	return this.ingredientName;
    }

    /**
     * Sets the amount of the ingredient.
     * 
     * @param ingredientAmount The amount of the ingredient.
     */
    public void setIngredientAmount(float ingredientAmount) {
    	this.ingredientAmount = ingredientAmount;
    }

    /**
     * Gets the amount of the ingredient.
     * 
     * @return The amount of the ingredient.
     */
    public float getIngredientAmount() {
    	return this.ingredientAmount;
    }

    /**
     * Sets the number of calories per unit measurement of the ingredient.
     * 
     * @param numCaloriesPerUnitMeasurement The number of calories per unit measurement.
     */
    public void setNumCaloriesPerUnitMeasurement(double numCaloriesPerUnitMeasurement) {
    	this.numCaloriesPerUnitMeasurement = numCaloriesPerUnitMeasurement;
    }

    /**
     * Gets the number of calories per unit measurement of the ingredient.
     * 
     * @return The number of calories per unit measurement.
     */
    public double getNumCaloriesPerUnitMeasurement() {
    	return this.numCaloriesPerUnitMeasurement;
    }

    /**
     * Sets the total calories of the ingredient.
     * 
     * @param totalCalories The total calories of the ingredient.
     */
    public void setTotalCalories(double totalCalories) {
    	this.totalCalories = totalCalories;
    }

    /**
     * Gets the total calories of the ingredient.
     * 
     * @return The total calories of the ingredient.
     */
    public double getTotalCalories() {
    	return this.totalCalories;
    }

    /**
     * Sets the unit measurement of the ingredient.
     * 
     * @param unitMeasurement The unit measurement of the ingredient.
     */
    public void setUnitMeasurement(String unitMeasurement) {
    	this.unitMeasurement = unitMeasurement;
    }

    /**
     * Gets the unit measurement of the ingredient.
     * 
     * @return The unit measurement of the ingredient.
     */
    public String getUnitMeasurement() {
    	return this.unitMeasurement;
    }

    /**
     * Sets the price of the ingredient.
     * 
     * @param ingredientPrice The price of the ingredient.
     */
    public void setIngredientPrice(double ingredientPrice) {
    	this.ingredientPrice = ingredientPrice;
    }

    /**
     * Gets the price of the ingredient.
     * 
     * @return The price of the ingredient.
     */
    public double getIngredientPrice() {
    	return this.ingredientPrice;
    }

    /**
     * Default constructor for the Ingredient class.
     */
    public Ingredient() {
    	this.ingredientName = "Milk";
    	this.unitMeasurement = "Cup";
    	this.ingredientAmount = 0.5f;
    	this.totalCalories = 0.0;
    	this.numCaloriesPerUnitMeasurement = 30.0;
    	this.ingredientPrice = 0.50;
    }
    

/**
 * Constructor for the Ingredient class.
 * 
 * @param ingredientName The name of the ingredient.
 * @param unitMeasurement The unit measurement of the ingredient.
 * @param ingredientAmount The amount of the ingredient.
 * @param totalCalories The total calories of the ingredient.
 * @param numCaloriesPerUnitMeasurement The number of calories per unit measurement of the ingredient.
 * @param ingredientPrice The price of the ingredient
 */
	public Ingredient (String ingredientName, String unitMeasurement, float ingredientAmount,
			double totalCalories, double numCaloriesPerUnitMeasurement, double ingredientPrice) {

		this.ingredientName = ingredientName;
		this.unitMeasurement = unitMeasurement;
		this.ingredientAmount = ingredientAmount;
		this.totalCalories = totalCalories;
		this.numCaloriesPerUnitMeasurement = numCaloriesPerUnitMeasurement;
		this.ingredientPrice = ingredientPrice;
	}

	/** 
	 * Prompts the user for input to create a new ingredient object and returns it. 
	 * The method uses regular expressions to validate the user input for the name of the ingredient and the unit of measurement.
	 * It also calls the getValidIngredientAmount() method to limit the amount of the ingredient to a valid range. 
	 * Finally, it calculates the total calories by multiplying the amount of the ingredient by the number of calories
	 * per unit of measurement.
	 * 
	 * @param 
	 * @return a new ingredient object.
	 */

	public Ingredient addNewIngredient() {

		boolean validInput = false;

		System.out.println("Please enter the name of the ingredient:");
		ingredientName = scnr.nextLine();

		/*If ingredient name contain numbers or symbols the program will prompt 
			   user to enter the ingredient name again using a loop */
		while(!ingredientName.matches("[a-zA-Z -]+")){
			System.out.println("Please enter a valid ingredient name!");
			ingredientName = scnr.nextLine();
		}
	
		do {
			System.out.println("Please enter the price of " + ingredientName+ ": ");
			while (!scnr.hasNextDouble() ) {
				System.out.println("Please enter a valid amount!");
				scnr.next();
			}
			ingredientPrice = scnr.nextDouble();
			validInput = true;

		} while (!validInput);
		scnr.nextLine(); //Consume the newline character

		System.out.println("Please enter the unit of measurement (e.g cups, oz., etc): ");
		unitMeasurement = scnr.nextLine();

		/*If unit of measurement contain numbers or symbols the program will prompt
			   user to enter the unit of measurement again using a loop */
		while(!unitMeasurement.matches("[a-zA-Z -]+")){
			System.out.println("Please enter a valid unit of measurement!");
			unitMeasurement = scnr.nextLine();
		}

		// Using method getValidIngredientAmount to limit the ingredient amount.
		ingredientAmount = getValidIngredientAmount(unitMeasurement);

		//Accept only numbers for the double variable numCaloriesPerUnitMeasurement
    
		do {
			System.out.println("Please enter the number of calories per " + unitMeasurement+ ": ");
			while (!scnr.hasNextDouble() ) {
				System.out.println("Please enter a valid number of calories!");
				scnr.next();
			}
			numCaloriesPerUnitMeasurement = scnr.nextDouble();
			validInput = false;

		} while (validInput);
		scnr.nextLine(); //Consume the newline character

		// Multiplying the number of cups and the calories per cup.
		totalCalories = ingredientAmount * numCaloriesPerUnitMeasurement;
		
		//Setting class variables
		setIngredientName(ingredientName);
		setIngredientAmount(ingredientAmount);
		setNumCaloriesPerUnitMeasurement(numCaloriesPerUnitMeasurement);
		setTotalCalories(totalCalories);
		setUnitMeasurement(unitMeasurement);
		setIngredientPrice(ingredientPrice);
		
		//Creating new ingredient object and returning it.
		Ingredient newIngredient = new Ingredient(ingredientName,unitMeasurement,
				ingredientAmount, totalCalories, numCaloriesPerUnitMeasurement, ingredientPrice);

		return newIngredient;


	}

	/**
	 * Limits the unit measurement, numbers valid are 0.1 - 100.0 
	 *
	 * @param unitMeasurement the name of Unit of measurement.
	 * @return a float representing the amount of ingredient.
	 */
	public static float getValidIngredientAmount(String unitMeasurement) {
		// 'MAX_UNIT' and 'MIN_UNIT' are declared as constants and used as upper and lower bounds for the input value
		final float MAX_UNIT = 100.0f;
		final float MIN_UNIT = 0.1f;
		float ingredientAmount;
		// The do-while loop continues until the input value is within the valid range defined by the constants
		do {
			System.out.println("Please enter the number of " + unitMeasurement + "! (Between 0.1 and 100.0)");
			while (!scnr.hasNextFloat() ) {
				System.out.println("Please enter a valid number! (Between 0.1 and 100.0)");
				scnr.next();
			}
			ingredientAmount = scnr.nextFloat();


		} while (ingredientAmount < MIN_UNIT || ingredientAmount > MAX_UNIT);
		// The 'ingredientAmount' value is returned to the calling function.
		return ingredientAmount;


	}

}

