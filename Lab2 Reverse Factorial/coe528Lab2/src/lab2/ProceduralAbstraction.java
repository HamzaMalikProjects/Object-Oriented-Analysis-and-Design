/*
 * This Java code demonstrates procedural abstraction by providing two functionalities:
 * 1. Reverse Factorial Program: It calculates the reverse factorial of a given positive integer.
 * 2. Nice Matrix Program: It checks if a given square matrix satisfies the "Nice" property, where
 *    the sum of each row, column, and main diagonal is the same.
 *
 * The program uses a menu-based system to allow the user to choose between these two operations
 * or to exit the program. It provides user-friendly prompts and messages throughout the execution.
 */

// Import necessary libraries
package lab2;
import java.util.Scanner;

/**
 * The ProceduralAbstraction class contains the main method and other methods for reverse factorial
 * calculation and checking the "Nice" property of a matrix.
 */

//import java.util.ArrayList;

/**
 *
 * @author Hamza Malik
 */

// Create a class named ProceduralAbstraction
public class ProceduralAbstraction {
    
    // Declare a static variable l and initialize it to 1.
    // It will be used in the reverseFactorial method to keep track of the current divisor.
    static int l = 1;

    // Method to find the reverse factorial of a given positive integer x
    public static int reverseFactorial(int x) {
        // If x is less than or equal to 1, return the value of l (the last divisor used).
        if (x <= 1) {
            int ph = l; // Store the value of l in ph (a placeholder).
            l = 1;     // Reset l back to 1 for future calculations.
            return ph; // Return the last divisor (the reverse factorial).
        }
        
        // Increment l by 1 and make a recursive call to reverseFactorial with x divided by l.
        // This will continue the factorial reduction process.
        l++;
        return reverseFactorial(x / l);
    }

    // Method to check if a given matrix arr satisfies the "Nice" property.
    // The "Nice" property requires the sum of each row, column, and main diagonal to be the same.
    public static boolean isMatrixNice(int[][] arr) {
        // Check if the matrix is square (number of rows equals the number of columns).
        if (arr.length == arr[0].length) {
            int m_sum = 0; // Store the sum of the first row in m_sum (matrix sum).

            // Calculate the sum of each row and compare it with m_sum.
            // If any row sum is different, the matrix is not "Nice," and we return false.
            for (int i = 0; i < arr.length; i++) {
                int trow = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    trow = trow + arr[i][j]; // Calculate the sum of the current row.
                }
                if (i == 0) {
                    m_sum = trow; // Store the sum of the first row in m_sum.
                } else {
                    if (m_sum != trow) {
                        // The sum of the current row is different from the first row, so the matrix is not "Nice."
                        System.out.println("The Sum Cannot be Calculated as the Matrix is not Nice ");
                        return false;
                    }
                }
            }
            
            // Calculate the sum of the main diagonal elements.
            int diagonal = 0;
            for (int i = 0; i < 2; i++) { // The loop runs twice to check both main diagonals.
                int tdiag = 0;
                for (int j = 0; j < arr.length; j++) {
                    tdiag = tdiag + arr[j][j]; // Calculate the sum of the current diagonal.
                }
                if (i == 0) {
                    diagonal = tdiag; // Store the sum of the main diagonal in the variable diagonal.
                } else {
                    if (diagonal != tdiag) {
                        // The sum of the current diagonal is different from the previous one, so the matrix is not "Nice."
                        return false;
                    }
                }
                if (diagonal != m_sum) {
                    // The sum of the main diagonal is different from the sum of rows, so the matrix is not "Nice."
                    return false;
                }
            }
            
            // If all conditions are met, the matrix is "Nice."
            System.out.println("The Sum of the Nice Matrix is: " + m_sum);
            return true;
        } else {
            // If the matrix is not square, it cannot be "Nice."
            return false;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in); // Create a Scanner object for user input.
        int options = 0, user, x;
        
        // Run a loop until the user chooses to end the program (by selecting option 3).
        while (options != 3) {
            // Print the menu for the user to choose options.
            System.out.println("=================================================================================");
            System.out.println("Welcome To The Abstraction Demo, Please Select One Of The Following Options!");
            System.out.println("Enter 1 Below To Run Reverse Factorial Program");
            System.out.println("Enter 2 Below To Run Nice Matrix Program");
            System.out.println("Enter 3 Below To Exit The Program");
            System.out.println("=================================================================================");

            // Read the user's choice from the input.
            user = scan1.nextInt();
            
            // Use a switch statement to perform actions based on the user's choice.
            switch (user) {
                case 1:
                    // Reverse Factorial Program
                    System.out.println("Enter an Integer below: ");
                    x = scan1.nextInt(); // Read the integer input from the user.
                    System.out.println(" ");
                    // Call the reverseFactorial method to calculate and print the result.
                    System.out.println("The Reverse Factorial for " + x + " is " + reverseFactorial(x / l));
                    break;
                
                case 2:
                    // NiceMatrix Program
                    System.out.println("Matrix #1: ");
                    System.out.println("2, 7, 6");
                    System.out.println("9, 5, 1");
                    System.out.println("4, 3, 8");
                    int[][] matrix1 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
                    // Check if matrix1 satisfies the "Nice" property and print the result.
                    System.out.println("Is the matrix above nice? " + isMatrixNice(matrix1));

                    System.out.println("");
                    System.out.println("Matrix #2: ");
                    System.out.println("-3, 1, 0");
                    System.out.println("4, -3, 4");
                    System.out.println("7, -9, 0");
                    int[][] matrix2 = {{-3, 1, 0}, {4, -3, 4}, {7, -9, 0}};
                    // Check if matrix2 satisfies the "Nice" property and print the result.
                    System.out.println("Is the matrix above nice? " + isMatrixNice(matrix2));
                    break;
                
                case 3:
                    // End the program
                    return;

                default:
                    // For invalid entry, inform the user.
                    System.out.println("Invalid choice! Please select a valid option (1, 2, or 3).");
            }
        }
    }
}

