import java.util.*;

class Solution {
    public int solution(int[] H) {
        
        // Initialize a stack to help us keep track of the heights we 
        // have previously seen in the given array. Also we need a 
        // helper int variable to count the amount of blocks we'll 
        // need to build the fence
        Stack<Integer> intStack = new Stack<Integer>();
        int counter = 0;
        
        // Iterate over the given array of height values so we can 
        // determine the amount of blocks needed to build the fence
        for (int value : H) {
            
            // This is the main point of the exercise. While the value 
            // we are currently looking at is less then the value 
            // stored on top of the stack we can pop that value and 
            // discard it because we cant reuse any of these heights to 
            // decrease the amount of blocks needed to build the fence
            while (!intStack.isEmpty() && value < intStack.peek()) {
                intStack.pop();
            }
            // If the value we are currently looking at is greater than 
            // the top value of the stack than there is a chance we could 
            // reuse this height to decrease the amount of blocks needed 
            // to build the fence. Push the value onto the stack
            if (!intStack.isEmpty() && value > intStack.peek()) {
                intStack.push(value);
                counter++;
            // Simple base case, push the value onto the stack
            } else if (intStack.isEmpty()) {
                intStack.push(value);
                counter++;
            }

            // Not necessary to show but when we come across a height that
            // is equal to a previous height seen without dipping below the 
            // height in the stack values to get to that previous equal height 
            // than we do not increment the brick count because we can use 
            // one brick instead of two
            
        }
        
        // Return the counter to show the minimum number of blocks needed to 
        // build a wall with the given heights in H
        return counter;
        
    }
}