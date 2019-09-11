import java.util.*;

class Solution {
    public int solution(int[] A) {
        
        // Catch the simple base case of a length 1 array
        if (A.length == 1) return 0;
            
        // Instantiate a stack to help us determine if the given array 
        // has a leader value in it as a whole without any break down
        // into sub-arrays.
        Stack<Integer> intStack = new Stack<Integer>();
       
        // Go through all the given values in A. If we can follow the 
        // simple procedure of popping a value onto the stack only if 
        // that value can be peeked from the top of the stack then we 
        // can determine if we have a possible leader in the given array
        for (int value : A) {
            if (intStack.isEmpty()) intStack.push(value);
            else if (intStack.peek() == value) intStack.push(value);
            else intStack.pop();
        }
    
        // If the stack is empty there is guarenteed to be no leader 
        // for the given array as a whole and any of its sub-array 
        // pair breakdowns as described in the problem
        if (intStack.isEmpty()) return 0;

        // Otherwise we have a possible leader for the given array 
        // and can count the number of occurences the value has in 
        // the given array
        int leader = intStack.peek(), maxCount = 0;
        for (int value : A) {
            if (value == leader) maxCount++;
        }
        
        // If the number of occurences is not greater than half the 
        // size of the given array than we know that there is actually 
        // no leader for the given array after all
        if (maxCount <= A.length/2) return 0;
        
        // Otherwise we have now confirmed the existance of a leader 
        // in the given array and we can proceed to recheck the 
        // values in the given array to see if any of the sub-array 
        // pairs have equileaders as described in the problem
        int counter = 0, leaderCount = 0;
        for (int iter=0; iter<A.length; iter++) {
            
            if (A[iter] == leader) leaderCount++; 
            
            if (leaderCount > (iter+1)/2 
                        && (maxCount-leaderCount) > (A.length-iter-1)/2) {
                counter++;    
            }
            
        }
        
        return counter;
        
    }
}