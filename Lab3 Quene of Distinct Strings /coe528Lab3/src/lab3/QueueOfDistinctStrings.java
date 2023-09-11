/*
 * Overview: This program defines a class called QueueOfDistinctStrings, which represents a mutable, bounded collection
 *           of distinct strings that operates in FIFO (First-In-First-Out) order. The class implements methods to enqueue
 *           (add) and dequeue (remove) strings from the queue while ensuring that all elements in the queue are unique.
 *           The class also provides a method to check if the representation invariant holds for the queue and a toString()
 *           method to display the queue's elements, front, and end. Additionally, the program contains a main method for
 *           testing the functionality of the QueueOfDistinctStrings class.
 *
 * Abstraction Function:
 *   AF(z) = a queue q (where z is a QueueOfDistinctStrings Java object)
 *           where q.front = z.items.get(0)
 *           where q.end = z.items.get(z.items.size() - 1)
 *           for all integers i, (0 <= i < z.items.size()), q.add(z.items.get(i))
 *   The function represents a set of strings in a certain order, maintaining the front and end of the queue.
 *
 * Representation Invariant:
 *   - The list of strings z.items cannot be empty.
 *   - The first and last elements in z.items must be different.
 *   - The queue should not contain any null elements, and all elements in the queue must be unique/distinct.
 *
 * Note: This program assumes that the user will interact with the class through the main method for testing purposes.
 *       The class itself should be used to handle queue operations and maintain the integrity of the representation
 *       invariant for the queue.
 */
package lab3;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Hamza Malik
 */

/**
 * A mutable, bounded collection of distinct strings that operates in FIFO (First-In-First-Out) order.
 * The QueueOfDistinctStrings class represents a queue of distinct strings with front and end pointers.
 * The queue ensures that all strings in it are unique/distinct.
 */
public class QueueOfDistinctStrings {
// Overview: QueueOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// FIFO (First-In-First-Out) order.
/*
    
    
The abstraction function is:
    a) Write the abstraction function here
ab(z) = an abrtaction queue q (where x is a QueueOfDistinctStrings Java-obejct)
where q.front = x.items.get(0)
where q.end = x.items.get.(x.items.size()-1)
for all the in integers i, (0 <= i <x.items.size()), q.add(x.items.get(i))
   The function represents a set of strings with a certain location (front and end).
     
 The rep invariant is:
b) Write the rep invariant here
    this.items.size() cannot be empty
    this.items.get(0)!= ........ != this.items.get(this.items.size()-1)
    The stack's last string is not null, and the stack must include items. The stings in the list must also be unique/distinct.
     */

    
//the rep

    // (The rest of the code follows here)
    // The rep: a list of distinct strings representing the elements of the queue.
    private ArrayList<String> items;

    /**
     * Constructor: Creates a new QueueOfDistinctStrings object.
     * EFFECTS: Initializes an empty list of strings.
     */
    public QueueOfDistinctStrings() {
        items = new ArrayList<String>();
    }

    /**
     * Adds the given element at the end of the queue if it is not already in the queue.
     *
     * @param element The string to be added to the queue.
     * @throws Exception If the provided element is null.
     */
    public void enqueue(String element) throws Exception {
        if (element == null) {
            throw new Exception("Cannot Enqueue Null Element.");
        }
        if (!items.contains(element)) {
            items.add(element);
        }
    }

    /**
     * Removes and returns the element from the front of the queue.
     *
     * @return The string removed from the front of the queue.
     * @throws Exception If the queue is empty.
     */
    public String dequeue() throws Exception {
        if (items.size() == 0) {
            throw new Exception("Queue Is empty. Cannot Dequeue.");
        }
        return items.remove(0);
    }

    /**
     * Checks whether the representation invariant holds for this object.
     *
     * @return True if the representation invariant holds, otherwise false.
     */
    public boolean repOK() {
        // The representation invariant requires that the list should not be empty,
        // and all elements in the list are distinct.
        if (items.size() == 0) {
            return false;
        }
        Set<String> distinctItems = new HashSet<String>(this.items);
        return (distinctItems.size() == this.items.size());
    }

    /**
     * Returns a string representation of the queue that contains its elements, front, and end.
     * Overrides the default toString() method.
     *
     * @return A string representation of the QueueOfDistinctStrings object.
     */
    public String toString() {
        String front = items.get(0);
        String end = items.get(items.size() - 1);
        return "Front: " + front + "\nEnd: " + end + "\nQueue Of Distinct Strings: " + items;
    }

    public static void main(String[] args) throws Exception {
        QueueOfDistinctStrings q = new QueueOfDistinctStrings();
        q.enqueue("ab");
        q.enqueue("cd");
        q.enqueue("ae");
        q.enqueue("bd");
        q.dequeue();
        boolean x = q.repOK();
        System.out.println("repOK Output: " + x);
        String y = q.toString();
        System.out.println(y);
    }
}




