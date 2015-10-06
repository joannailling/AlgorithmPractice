package InterviewQuestions;

import java.util.Scanner;

public class LongestRecurringChar {
    
    public ReturnPair longest(String s) {
        int max = 0;
        char maxChar = ' ';
        int count = 1;
        char[] chars = s.toCharArray();
        
        for(int i=0; i<chars.length-1; i++) {
            if (chars[i]==chars[i+1]) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    maxChar = chars[i];
                }
                count = 1;
            }    
        }
        if (max < count) {
            max = count;
            maxChar = chars[chars.length-1];
        }
        return new ReturnPair(maxChar, max);
    }
    
    public static void main(String[] args) {
        LongestRecurringChar s = new LongestRecurringChar();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter String to determine longest consecutively repeated character: ");
        ReturnPair rp = s.longest(scan.nextLine());
        System.out.println(rp.toString());
    }
    
}
