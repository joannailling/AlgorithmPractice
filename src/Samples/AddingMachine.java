
package Samples;

import java.util.Scanner;

/**
 * @author jmilling
 */
public class AddingMachine {
    /** Write a program that simulates an adding machine. Input to the program will be 
    * integers, submitted one per line.  Input should be handled as follows: 
    * a nonzero value should be added into a subtotal; 
    * a zero value should cause the subtotal to be printed and reset to zero; 
    * two consecutive zeroes should cause the total of all the values input to 
    * be printed and the program to be terminated. **/
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean keepLooping = true;
        int subtotal = 0;
        int grandtotal = 0;      
        Integer number = null;
        while (keepLooping == true) {
            Integer prevNumber = number;
            number = scan.nextInt();
            subtotal = subtotal + number;
            grandtotal = grandtotal + number;
            if (number != null && number == 0) {
                if (prevNumber == 0) {
                    keepLooping = false;
                } else {
                    System.out.println("Subtotal: " + String.valueOf(subtotal));
                    subtotal = 0;
                }
            }           
        }
        System.out.println("Total: " + String.valueOf(grandtotal));
        
    }
    
   
    
}
