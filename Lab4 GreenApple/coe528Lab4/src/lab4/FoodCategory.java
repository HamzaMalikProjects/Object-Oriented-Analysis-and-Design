/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lab4;
import java.util.ArrayList;

/**
 *
 * @author hamzamalik
 */


//Represents FoodCategory, used to group multiple FoodComponents together.
public class FoodCategory extends FoodComponent {

    private ArrayList<FoodComponent> foodcomp; // List of food components in this category
    private String name; // Name of the food category
    private double price; // Total price of all the food components in this category

    //Constructor for the FoodCategory class.
    public FoodCategory(String name){
        this.name = name;
        foodcomp = new ArrayList<>();
    }

    //Adds a new FoodComponent to this FoodCategory.
    public void add(FoodComponent x){
        foodcomp.add(x);
    }

    //Removes a FoodComponent from this FoodCategory.
    public void remove(FoodComponent y){
        foodcomp.remove(y);
    }

   
    //Calculates and returns the total price of all the food components in this FoodCategory.
    //@return The total price of all the food components in this category.
    @Override
    public double getPrice(){
        price = 0;
        for (int i = 0; i < foodcomp.size(); i++){
            price += foodcomp.get(i).getPrice();
        }
        return price;
    }

    
    //Prints the details of this FoodCategory and all its contained food components with indentation.
    //@param level The level of indentation for formatting purposes.
    @Override
    public void print(int level){
        String tab = " ";
        for(int i = 0; i < level; i++){
            tab += "\t";
        }
        level++;

        System.out.println(tab + "Food Category (" + name + ", " + this.getPrice() + ") contains:");
        for (int i = 0; i < foodcomp.size(); i++){
            foodcomp.get(i).print(level);
        }
    }
}

