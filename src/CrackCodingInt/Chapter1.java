
package CrackCodingInt;

import java.util.Scanner;

public class Chapter1 {
    
    private Scanner scan;
    
    public boolean onePointOne(String inString) {
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
    
    public static void main(String[] args) {
        Chapter1 c1 = new Chapter1();
        c1.testOnePointOne();
    }
}
