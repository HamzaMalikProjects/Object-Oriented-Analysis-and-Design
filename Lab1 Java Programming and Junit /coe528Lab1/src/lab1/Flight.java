package lab1;

/**
 * This class represents a flight.
 * It stores information about the flight number, capacity, number of seats left,
 * original price, origin, destination, and departure time.
 * 
 * @author Hamza Malik
 */
public class Flight {
    public int flightNumber; // Stores the flight number
    public int capacity; // Stores the maximum capacity of the flight
    public int numberOfSeatsLeft; // Stores the number of seats left
    public double originalPrice; // Stores the original price of the flight
    public String origin; // Stores the origin of the flight
    public String destination; // Stores the destination of the flight
    public String departureTime; // Stores the departure time of the flight
    
    // Constructor
    public Flight(int fn, int cap, String og, String des, String dt, double op) {
        try {
            if (og.equals(des)) { // If the origin and destination are the same
                throw new IllegalArgumentException("The Origin And Destination Cannot Be The Same");
            } else {
                flightNumber = fn;
                origin = og;
                destination = des;
                departureTime = dt;
                numberOfSeatsLeft = cap;
                capacity = cap;
                originalPrice = op;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
    
    // Getter for the flight number
    public int getFlightNumber() {
        return flightNumber;
    }
    
    // Setter for the flight number
    public void setFlightNumber(int fn) {
        flightNumber = fn;
    }
    
    // Getter for the capacity
    public int getCapacity() {
        return capacity;
    }
    
    // Setter for the capacity
    public void setCapacity(int cap) {
        capacity = cap;
    }
    
    // Getter for the origin
    public String getOrigin() {
        return origin;
    }
    
    // Setter for the origin
    public void setOrigin(String og) {
        origin = og;
    }
    
    // Getter for the destination
    public String getDestination() {
        return destination;
    }
    
    // Setter for the destination
    public void setDestination(String des) {
        destination = des;
    }
    
    // Getter for the departure time
    public String getDepartureTime() {
        return departureTime;
    }
    
    // Setter for the departure time
    public void setDepartureTime(String dt) {
        departureTime = dt;
    }
    
    // Getter for the number of seats left
    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }
    
    // Setter for the number of seats left
    public void setNumberOfSeatsLeft(int nsl) {
        numberOfSeatsLeft = nsl;
    }
    
    // Getter for the original price
    public double getOriginalPrice() {
        return originalPrice;
    }
    
    // Setter for the original price
    public void setOriginalPrice(double op) {
        originalPrice = op;
    }
    
    // Method to book a seat on the flight
    public boolean bookASeat() {
        if (numberOfSeatsLeft > 0) { // If there are seats available
            numberOfSeatsLeft--; // Decrease the number of seats left
            return true; // Return true to indicate successful booking
        }
        return false; // Return false to indicate unsuccessful booking
    }
    
    // Override toString() method to represent Flight object as a string
    @Override
    public String toString() {
        return "Flight " + flightNumber + ", " + origin + " to " + destination + ", " + departureTime + ", " + originalPrice;
    }
    
    public static void main(String[] args) { // Sample test to ensure the flight is created with the desired inputs
        Flight test = new Flight(1030, 100, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000.00);
        System.out.println(test.toString());
    }
}


