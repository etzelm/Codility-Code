class Solution {
    public int solution(int[] A) {
        
        // Initialize helper variables to track the 
        // sum we are currently tracking and the max
        // sum we've seen so far. Set to first element 
        // to catch simple length one base case
        int maxSum = A[0], hold = A[0];
           
        // Start iterating from second element in given 
        // array if there is one. The solution relies on 
        // checking if current sum is better than previous 
        // sum and resetting to the current value we're 
        // iterating over if it isnt. Checking if we need 
        // to update the maxSum helper is the last step
        for(int iter = 1; iter < A.length; iter++){
            if (A[iter] < hold + A[iter]) {
                hold += A[iter];
            } else {
                hold = A[iter];
            }
            if (maxSum < hold) maxSum = hold;
        }
        
        // Return the value we built up in the variable
        return maxSum;
    }
}