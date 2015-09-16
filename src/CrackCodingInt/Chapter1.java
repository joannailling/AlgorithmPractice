
package CrackCodingInt;

import java.util.Scanner;

public class Chapter1 {
    
    private Scanner scan;
    
    public boolean onePointOne(String inString) {
        // Implement an algorithm to determine if a string has all unique 
        // characters. What if you can not use additional data structures?
        for (int i = 0; i < inString.length(); i ++) {
            for (int j = i+1; j < inString.length(); j ++) {
                if ((inString.charAt(i)) == (inString.charAt(j))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public String onePointTwo(String inString) {
        // Write code to reverse a C-Style String  (C-String means that “abcd” is 
        // represented as five characters, including the null character )
        char temp;
        char[] chars = inString.toCharArray();
        int lo = 0;
        int hi = chars.length - 2;
        while (lo < hi) {
            temp = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = temp;
            lo++;
            hi--;
        } 
        return String.valueOf(chars);
    }
    
    public String onePointThree(char[] input) {
        // Design an algorithm and write code to remove the duplicate characters 
        // in a string without using any additional buffer  NOTE: One or two 
        // additional variables are fine. An extra copy of the array is not 
        int len = input.length;
        int tail = 1; 
        if (len >= 2) { //char arrays of length 0 or 1 will not have duplicate chars
            for (int i = 0; i < len; i++) {
                int j = 0;
                while (j < tail && !(input[i]==input[j])) {
                    j++;
                }
                if (j == tail) {
                    input[tail] = input[i];
                    tail++;
                }
            }
            while (tail < len) { //clear all chars in array with index >= tail
                input[tail] = 0;
                tail++;
            }
        }
        return String.valueOf(input);
    }
    
    public void test() {
        scan  = new Scanner(System.in);
        
        System.out.print("Enter a problem number: ");
        int problemNum = Integer.valueOf(scan.nextLine());
        System.out.print("Enter number of repetitions: ");
        int repetitions = Integer.valueOf(scan.nextLine());
        System.out.println("");
        
        switch(problemNum) {
            case 1 : // 1.1 determine if string has all unique characters
                for (int i = 0; i < repetitions; i++ ){
                    System.out.print("Enter a String to determine whether characters are unique: ");
                    System.out.println(String.valueOf(onePointOne(scan.nextLine())));
                }
                break;      
            case 2 : // 1.2 reverses a string
                for (int i = 0; i < repetitions; i++ ){
                    System.out.print("Enter a String to reverse: ");
                    System.out.println(onePointTwo(scan.nextLine()));
                }
                break;
            case 3 : // 1.3 removes duplicate characters from a string
                for (int i = 0; i < repetitions; i++ ){
                    System.out.print("Enter a String to remove duplicates: ");
                    System.out.println(onePointThree(scan.nextLine().toCharArray()));
                }
                break;
            default:
                System.out.println("Invalid problem number.");
                break;         
        }
    } 

    public static void main(String[] args) {
        Chapter1 c1 = new Chapter1();
        c1.test();
    }
}
