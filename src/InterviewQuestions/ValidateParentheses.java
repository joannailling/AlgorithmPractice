
package InterviewQuestions;

/*
 * "(these are valid parentheses)" => true
 * "[{}()]" => true
 * ":(" => false
 * "([)]" => false
 * ":\(" => true
 */

import java.util.Stack;

class ValidateParentheses {
    
    public boolean isOpenParen(char c) {
        if (c=='(' || c=='{'  || c=='[') {
            return true;
        } else {
            return false;
        }
    }
  
    public boolean isCloseParen(char c) {
        if (c==')' || c=='}' || c==']') {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validateParens(String inString) {
        Stack<Character> myStack = new Stack<>();
        Character prev = null;
        char curr;
        for (int i = 0; i < inString.length(); i++) {
            curr = inString.charAt(i);
            if (this.isOpenParen(curr)) {
                if (!(prev!=null && prev=='\\')) {
                    myStack.push(curr);
                }
            }  else if (this.isCloseParen(curr)) {
                if (!(prev!=null && prev=='\\')) {
                    if (myStack.empty()) {
                        return false; 
                    } else {
                        char peek = myStack.peek(); // peek is the open paren
                        boolean match = (curr == ')' && peek == '(') || // curr is the close paren
                                        (curr == ']' && peek == '[') ||
                                        (curr == '}' && peek == '{');
                        if (!match) {
                            return false;
                        } else {
                            char pop = myStack.pop();
                        } 
                    }
                }
            }
            prev = curr;
        }
        if (myStack.empty()) {
            return true;
        } else {
            return false;
        }
    } 
  
    public static void main(String[] args) {
        ValidateParentheses vp = new ValidateParentheses();
    
        System.out.println(vp.validateParens("(these are valid parentheses)"));
        System.out.println(vp.validateParens("[{}()]"));
        System.out.println(vp.validateParens(":("));
        System.out.println(vp.validateParens("([)]"));
        System.out.println(vp.validateParens(":\\("));
        System.out.println(vp.validateParens("\\):"));
    }
}