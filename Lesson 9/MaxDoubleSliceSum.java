class Solution {
    public int solution(int[] A) {
        
        // Initialize two arrays that we will fill using Kadane's Algorithm
        // and a helper variable to track the MaxDoubleSliceSum
        int[] frontSlices = new int[A.length];
        int[] backSlices = new int[A.length];
        int maxSum = 0;
        
        // Iterate over the given array from the front but skip the first 
        // element as it can't be included in a double slice by definition.
        // Use Kadane's algorithm to fill frontSlices[iter] with the maxSum
        // seen so far in the iteration
        for (int iter = 1; iter < A.length-1; iter++) {
            frontSlices[iter] = Math.max(frontSlices[iter-1] + A[iter], 0);
        }
        
        // Do the same work as before but from the back this time, exclude
        // the last element as it can't be included in a double slice
        for (int iter = A.length-2; iter > 0; iter--){
            backSlices[iter] = Math.max(backSlices[iter+1]+A[iter], 0);
        }

        // Once more iterate over the given array and find the largest 
        // sum of frontSlices[iter-1] + backSlices[iter+1]
        for (int iter = 1; iter < A.length-1; iter++){
            maxSum = Math.max(maxSum, frontSlices[iter-1]+backSlices[iter+1]);
        }
        
        // Return the MaxDoubleSliceSum we have found
        return maxSum;
        
    }
}