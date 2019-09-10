import java.util.*;

class Solution {
    public int solution(String S) {
        
        // Catch the simple empty base case
        if (S.isEmpty()) return 1;
        
        // Instantiate a stack to help us keep track of the 
        // opening parentheses we see, popping them off if
        // we come across a closing parenthesis 
        Stack<String> stringStack = new Stack<String>();
        
        // Iterate over the given string and push opening 
        // parentheses onto the stack. If we see a closing 
        // parenthesis pop an opening one off the stack, 
        // unless the stack is empty and we can return 0 
        // knowing the parentheses aren't properly nested
        for (int iter=0; iter<S.length(); iter++) {
            if (S.charAt(iter) == '(') stringStack.push("(");
            else if (!stringStack.isEmpty()) stringStack.pop();
            else if (stringStack.isEmpty()) return 0;
        }
        
        // If the stringStack is empty at this point we can 
        // return 1 for properly nested parentheses,
        // otherwise return 0.
        if (stringStack.isEmpty()) return 1;
        else return 0;
        
    }
}