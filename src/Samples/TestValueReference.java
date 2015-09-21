package Samples;

/**
 *
 * @author jmilling
 */
public class TestValueReference {
    
    public void testString(String inString) {
        // this doesn't modify the original string
        inString = inString.toUpperCase();
    }
    
    public void testString2(String inString) {
        // this doesn't modify the original string either
        for (char c : inString.toCharArray()) {
            c = Character.toUpperCase(c);
        }
    }

    
    public void testCharArray(char[] chars1, char[] chars2) {
        // this type of for loop will alter the char array in place
        for (int i = 0; i < chars1.length; i++) {
            chars1[i] = Character.toUpperCase(chars1[i]);
        }
        
        // this type of for loop leaves the char array intact
        for (char c : chars2) {
            c = Character.toUpperCase(c);
        }
    }
    
    public static void main(String[] args) {
        TestValueReference t = new TestValueReference();
        
        System.out.println("As String:");
        String s1 = "hello world";
        System.out.println("\tBefore: " + s1);
        t.testString2(s1);
        System.out.println("\tAfter: " + s1);
        
        System.out.println("As char[]:");
        char[] c1 = new String("hello").toCharArray();
        char[] c2 = new String("goodbye").toCharArray();      
        System.out.println("\tBefore: " + String.valueOf(c1) + " " + String.valueOf(c2));
        t.testCharArray(c1, c2);
        System.out.println("\tAfter: " + String.valueOf(c1)+ " " + String.valueOf(c2));
    }
    
    
}
