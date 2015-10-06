
package InterviewQuestions;

import java.util.Scanner;

public class Anagram {
    
    // Write a function to determine whether two strings are anagrams of each other
    // There must be the same number of each letter - for instance, "letter" and "teller" should return false
    
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            int[] charsA = new int[256];
            int[] charsB = new int[256];
            for(int i=0; i<a.length(); i++) {
                charsA[(int)a.charAt(i)] += 1;
                charsB[(int)b.charAt(i)] += 1;
            }
            for(int j=0; j<256; j++) {
                if(charsA[j] != charsB[j]) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two strings to determine whether they are anagrams: ");
        System.out.print("String 1: ");
        String strA = scan.nextLine();
        System.out.print("String 2: ");
        String strB = scan.nextLine();
        
        Anagram a = new Anagram();
        System.out.println(String.valueOf((a.isAnagram(strA, strB))));
    }
    
}
