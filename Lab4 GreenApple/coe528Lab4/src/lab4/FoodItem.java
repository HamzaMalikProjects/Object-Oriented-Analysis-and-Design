/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lab4;

/**
 *
 * @author hamzamalik
 */

//Represents FoodItem, a basic component of a food item representing a single ingredient.
public class FoodItem extends FoodComponent {

    private double price; // Price of the food item
    private String name; // Name of the food item

    /**
     * Constructor for the FoodItem class
     * @param name The name of the food item.
     * @param cost The price of the food item.
     */
    public FoodItem(String name, double cost){
        this.name = name;
        price = cost;
    }

    //Gets the price of the food item and returns the price of the food item.
    public double getPrice(){
        return price;
    }
    
    // Prints the details of this FoodItem.
    //@level The level of indentation for formatting purposes.
    @Override
    public void print(int level){
        String tab = "";
        for (int i = 0; i < level; i++){
            tab += "\t"; // Add tabs based on the indentation level
        }
        level++;

        System.out.println(tab + "Food Item: " + this.name + ", " + this.getPrice());
    }
}
