package lab1;

/**
 * This class represents a ticket for a flight.
 * It stores information about the passenger, flight, price, and ticket number.
 * The ticket number is assigned automatically.
 * 
 * @author Hamza Malik
 */

public class Ticket {
    // Private instance variables
    private Passenger passenger; // Stores information about the passenger
    private Flight flight; // Stores information about the flight
    private double price; // Stores the price of the ticket
    private int ticketnumber; // Stores the ticket number
    private static int number = 1; // Static variable to track ticket numbers
    
    // Constructor
    public Ticket(Passenger p, Flight flight, double price) {
        this.passenger = p;
        this.flight = flight;
        this.price = price;
        ticketnumber = number; // Assign the ticket number
        number++; // Increment the ticket number for the next ticket
    }
    
    // Getter for the passenger
    public Passenger getPassenger() {
        return passenger;
    }
    
    // Setter for the passenger
    public void setPassenger(Passenger p) {
        this.passenger = p;
    }
    
    // Getter for the flight
    public Flight getFlight() {
        return flight;
    }
    
    // Setter for the flight
    public void setFlight(Flight fl) {
        this.flight = fl;
    }
    
    // Getter for the price
    public double getPrice() {
        return price;
    }
    
    // Setter for the price
    public void setPrice(double p) {
        this.price = p;
    }
    
    // Getter for the ticket number
    public int getTicketNumber() {
        return ticketnumber;
    }
    
    // Setter for the ticket number
    public void setTicketNumber(int tn) {
        this.ticketnumber = tn;
    }
    
    // Override toString() method to represent Ticket object as a string
    @Override
    public String toString() {
        return passenger.getName() + "," + flight + "," + price;
    }
}


