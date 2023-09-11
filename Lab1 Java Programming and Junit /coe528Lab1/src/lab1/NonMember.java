package lab1;

/**
 * This class represents a non-member passenger.
 * It extends the Passenger class and provides an implementation for the applyDiscount() method.
 * 
 * The NonMember class is a subclass of Passenger and inherits the name and age properties.
 * 
 * @author Hamza Malik
 */
public class NonMember extends Passenger {
    
    // Constructor
    public NonMember(String na, int ag) {
        super(na, ag); // Call the constructor of the superclass (Passenger)
    }
    
    // Override the applyDiscount() method to calculate the discounted price
    @Override
    public double applyDiscount(double p) {
        if (getAge() > 65) { // If the passenger is above 65 years old
            return (p * 0.1); // Apply a discount of 10% to the ticket price
        } else {
            return p; // Return the original price without any discount
        }
    }
}

