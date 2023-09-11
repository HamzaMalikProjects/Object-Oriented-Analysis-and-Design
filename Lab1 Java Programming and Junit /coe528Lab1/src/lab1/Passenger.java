package lab1;

/**
 * This abstract class represents a passenger.
 * It provides common functionality and properties for different types of passengers.
 * Subclasses of Passenger must implement the applyDiscount() method.
 * 
 * The Passenger class has properties for name and age.
 * Provides Getter and Setters for these properties.
 * 
 * This class is abstract, meaning it cannot be instantiated directly.
 * Instead, it serves as a base class for more specific passenger types.
 * 
 * @author Hamza Malik
 */
public abstract class Passenger {
    private String name; // Stores the name of the passenger
    private int age; // Stores the age of the passenger
    
    // Abstract method to apply a discount to the ticket price
    public abstract double applyDiscount(double p);
    
    // Constructor
    public Passenger(String na, int ag) {
        this.name = na;
        this.age = ag;
    }
    
    // Getter for the name
    public String getName() {
        return name;
    }
    
    // Setter for the name
    public void setName(String na) {
        this.name = na;
    }
    
    // Getter for the age
    public int getAge() {
        return age;
    }
    
    // Setter for the age
    public void setAge(int ag) {
        this.age = ag;
    }
}

