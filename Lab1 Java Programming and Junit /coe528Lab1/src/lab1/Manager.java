package lab1;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class represents a Manager for flights and bookings.
 * It allows creating flights, displaying available flights, getting flight information,
 * and booking seats for passengers.
 * 
 * @author Hamza Malik
 */
public class Manager {
    ArrayList<Flight> flights; // Stores the list of flights
    ArrayList<Ticket> tickets; // Stores the list of tickets
    
    // Constructor
    public Manager() {
        flights = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    // Method to create flights
    public void createFlights() {
        int fn, cap; // Flight number and capacity
        String og, des, dt; // Origin, destination, and departure time
        double op; // Original price

        Scanner scan1 = new Scanner(System.in); // For the int values
        Scanner scan2 = new Scanner(System.in); // For the string values
        Scanner scan3 = new Scanner(System.in); // For the double values

        System.out.println("Enter Your Designated Flight Number?");
        fn = scan1.nextInt(); // Flight number
        System.out.println("Enter The Flight's Designated Capacity?");
        cap = scan1.nextInt(); // Capacity

        System.out.println("Enter The Flight's Designated Origin?");
        og = scan2.nextLine(); // Origin
        System.out.println("Enter The Flight's Designated Destination?");
        des = scan2.nextLine(); // Destination
        System.out.println("Enter The Flight's Designated Departure Time?");
        dt = scan2.nextLine(); // Departure time

        System.out.println("Enter The Flight's Original Price?");
        op = scan3.nextDouble(); // Original price

        Flight fl = new Flight(fn, cap, og, des, dt, op);
        flights.add(fl);

        System.out.println("The Following Flight Has Been Created:");
        System.out.println(fl);
    }
    
    // Method to display available flights based on origin and destination
    public void displayAvailableFlights(String origin, String destination) {
        int seats;
        String og, des;

        System.out.println("Here Are A List Of Available Flights:");
        for (int i = 0; i < flights.size(); i++) {
            og = flights.get(i).getOrigin();
            des = flights.get(i).getDestination();
            seats = flights.get(i).getNumberOfSeatsLeft();

            if (og.equals(origin) && des.equals(destination) && seats > 0) {
                System.out.println(flights.get(i));
            } else {
                System.out.println("There Are No Available Flights.");
            }
        }
    }
    
    // Method to get flight information based on flight number
    public Flight getFlight(int flightNumber) {
        for (int i = 0; i < flights.size(); i++) {
            if (flightNumber == flights.get(i).getFlightNumber()) {
                return flights.get(i);
            }
        }
        return null; // If flight number not found, return null
    }
    
    // Method to book a seat for a passenger
    public void bookSeat(int flightNumber, Passenger p) {
        double price;

        for (int i = 0; i < flights.size(); i++) {
            if (flightNumber == flights.get(i).getFlightNumber()) {
                if (flights.get(i).bookASeat()) { // If seat is available and booked successfully
                    price = p.applyDiscount(flights.get(i).getOriginalPrice());
                    Ticket t = new Ticket(p, flights.get(i), price);
                    tickets.add(t);
                    System.out.println("A Booking Has Been Made For Your Desired Flight: " + flightNumber);
                    break;
                } else {
                    System.out.println("The Flight You Are Trying To Book Is Full. Apologies For The Inconvenience.");
                }
            } else {
                System.out.println("The Flight You Are Searching For Does Not Exist. Please Try Again!");
            }
        }
    }
    
    public static void main(String[] args) { // Main method
        Manager mn = new Manager();
        Flight fl;
        Passenger p;
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        String input, des, origin, name;
        int option = 0, user, fn, ag, yearsOfMembership;

        while (option != 5) {
            System.out.println("Welcome! Please select one of the following options:");
            System.out.println("Enter 1 To Create A Flight");
            System.out.println("Enter 2 To Display Available Flights With A Designated Origin And Destination");
            System.out.println("Enter 3 To Get Flight Information Using A Flight Number");
            System.out.println("Enter 4 To Book A Seat For a Designated Flight Using A Flight Number");
            System.out.println("Enter 5 To Exit This Program");

            user = scan1.nextInt();
            switch (user) {
                case 1:
                    mn.createFlights();
                    break;
                case 2:
                    System.out.println("Enter The Flight's Origin:");
                    origin = scan1.nextLine();
                    System.out.println("Enter The Flight's Destination:");
                    des = scan1.nextLine();
                    mn.displayAvailableFlights(origin, des);
                    break;
                case 3:
                    System.out.println("Enter The Flight Number:");
                    fn = scan1.nextInt();
                    fl = mn.getFlight(fn);
                    if (fl == null) {
                        System.out.println("Flight " + fn + " Does Not Exist. Please Try Again!");
                    } else {
                        System.out.println("The Information For Your Flight " + fn + " Is As Follows:");
                        System.out.println(fl);
                    }
                    break;
                case 4:
                    System.out.println("Enter 'n' For A Non-Member Passenger Or 'm' For A Member Passenger:");
                    input = scan2.nextLine();
                    System.out.println("Enter The Passenger's Name:");
                    name = scan3.nextLine();
                    System.out.println("Enter The Passenger's Age:");
                    ag = scan3.nextInt();
                    System.out.println("Enter The Flight Number:");
                    fn = scan3.nextInt();
                    if (input.equals("n")) {
                        p = new NonMember(name, ag);
                        mn.bookSeat(fn, p);
                    } else if (input.equals("m")) {
                        System.out.println("Enter The Years Of Membership:");
                        yearsOfMembership = scan3.nextInt();
                        p = new Member(name, ag);
                        mn.bookSeat(fn, p);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid Input. Please Try Again!");
            }
            System.out.println("");
        }
    }
}




