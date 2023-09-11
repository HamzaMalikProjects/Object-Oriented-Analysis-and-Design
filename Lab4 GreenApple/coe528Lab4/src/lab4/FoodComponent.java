/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lab4;

/**
 *
 * @author hamzamalik
 */

// Abstract class representing food component.
public abstract class FoodComponent {
    
    //Default constructor for the FoodComponent class.
    public FoodComponent() {};
    
    //Abstract method to get the price of the food component.
    //@return The price of the food component.
    public abstract double getPrice();
    
    //Abstract method to print the details of the food component.
    public abstract void print(int level);
}
