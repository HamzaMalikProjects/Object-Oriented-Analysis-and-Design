package lab1;

/**
 * This class represents a member passenger.
 * It extends the Passenger class and provides an implementation for the applyDiscount() method.
 * 
 * The Member class is a subclass of Passenger and inherits the name and age properties.
 * It also has an additional property yearsOfMembership to store the number of years the passenger has been a member.
 * 
 * @author Hamza Malik
 */
public class Member extends Passenger {
    private int yearsOfMembership; // Stores the number of years of membership
    
    // Constructor
    public Member(String na, int ag) {
        super(na, ag); // Call the constructor of the superclass (Passenger)
    }
    
    // Override the applyDiscount() method to calculate the discounted price
    @Override
    public double applyDiscount(double p) {
        if (yearsOfMembership > 5) { // If the passenger has been a member for more than 5 years
            return (p * 0.5); // Apply a discount of 50% to the ticket price
        } else if (yearsOfMembership > 1 && yearsOfMembership <= 5) { // If the passenger has been a member for 1 to 5 years
            return (p * 0.1); // Apply a discount of 10% to the ticket price
        } else {
            return p; // Return the original price without any discount
        }
    }
}
