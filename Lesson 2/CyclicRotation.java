class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        
        // Check for simple cases where no work is actually needed
        if (A.length <= 1) return A;

        // Need to do the same work per each rotation out of K
        for (int outerIter=0; outerIter < K; outerIter++) {
            // Instantiate two iterators to hold the values moving 
            // at any given time in the following for loop
            int currentIter = A[0];
            int nextIter = A[1];
            
            // Iterate over the given array and rotate the values inside
            for (int innerIter=0; innerIter < A.length; innerIter++) {
                // If at the end, bring that value to the front
                if (innerIter == A.length - 1) A[0] = currentIter;
                // Otherwise move the current value to the right
                else A[innerIter+1] = currentIter;
                // Set the current iterator to the next iteration
                currentIter = nextIter;
                // As long as we arent looking for elements that don't 
                // exist, store the new next iteration in its iterator
                if (innerIter+2 < A.length) nextIter = A[innerIter+2];
            }
        }
        
        return A;
    }
}
