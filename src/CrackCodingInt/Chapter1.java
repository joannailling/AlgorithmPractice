
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
    
    public void testOnePointOne() {
        scan  = new Scanner(System.in);
        for (int i = 0; i < 5; i++ ){
            System.out.print("Enter a String: ");
            boolean b = onePointOne(scan.nextLine());
            System.out.println(b);
        }
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
    
    public void testOnePointTwo() {
        scan  = new Scanner(System.in);
        for (int i = 0; i < 5; i++ ){
            System.out.print("Enter a String: ");
            String s = onePointTwo(scan.nextLine());
            System.out.println(s);
        }
    } 
    
    public static void main(String[] args) {
        Chapter1 c1 = new Chapter1();
        //c1.testOnePointOne();
        c1.testOnePointTwo();
    }
}
