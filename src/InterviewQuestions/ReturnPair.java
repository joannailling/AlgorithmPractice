
package InterviewQuestions;

public class ReturnPair {
    private char letter;
    private int occurrences;
    
    public char getLetter() {
        return letter;
    }
    
    public int getOccurrences() {
        return occurrences;
    }
    
    public void setLetter(char c) {
        letter = c;
    }
    
    public void setOccurrences(int i) {
        occurrences = i;
    }
    
    @Override
    public String toString() {
        return "(\"" + String.valueOf(letter) + "\", " + String.valueOf(occurrences) + ")";
    }
    
    public ReturnPair(char c, int i) {
        letter = c;
        occurrences = i;
    }
    
 
}
