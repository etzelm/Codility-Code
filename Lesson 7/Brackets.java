import java.util.*;

class Solution {
    public int solution(String S) {
        
        // Catch the simple empty base case
        if (S.isEmpty()) return 1;
        
        // Instantiate a stack to help us keep track of the 
        // opening parentheses, brackets, and curly braces we see, 
        // popping them off if we come across a closing pair
        Stack<String> stringStack = new Stack<String>();

        // Iterate over the given string and push opening 
        // parentheses, brackets, and curly braces onto the stack. 
        // If we see a closing item and its pair can be peeked 
        // from the top of the stack then pop the opening one 
        // off the stack. Otherwise, we know the given string  
        // isn't properly nested and we can return 0 
        for (int iter=0; iter<S.length(); iter++) {
            
            if (S.charAt(iter) == '(') stringStack.push("(");
            else if (S.charAt(iter) == '[') stringStack.push("[");
            else if (S.charAt(iter) == '{') stringStack.push("{");
            else if (S.charAt(iter) == ')' 
                        && !stringStack.isEmpty()
                        && stringStack.peek() == "(") {
                stringStack.pop();
            } else if (S.charAt(iter) == ']' 
                        && !stringStack.isEmpty()
                        && stringStack.peek() == "[") {
                stringStack.pop();
            } else if (S.charAt(iter) == '}' 
                        && !stringStack.isEmpty()
                        && stringStack.peek() == "{") {
                stringStack.pop();
            } else return 0;
            
        }
        
        // If the stringStack is empty at this point we can 
        // return 1 for properly nested parentheses, brackets, 
        // and curly braces. Otherwise, return 0.
        if (stringStack.isEmpty()) return 1; 
        else return 0;
        
    }
}