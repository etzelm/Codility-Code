class Solution {
    public int solution(int[] A, int[] B) {
        
        // Catch the simple empty and single size 
        // base cases, return the respective
        if (A.length <= 1) return A.length;
        
        // Initialize helper variables to keep track 
        // of the maximum count of non overlapping 
        // rope segments and the second edge of the 
        // last non-overlapping rope segments
        int maxCount = 1, lastEdge = B[0];

        // Iterate over the given rope segment 
        // lengths and greedly check that there 
        // isn't any overlap between the segments 
        // we're currently looking at before 
        // incrementing our helper variable
        for (int iter=1; iter < A.length; iter++) {

            if (A[iter] > lastEdge) {
                maxCount++;
                lastEdge = B[iter];
            }

        }
        
        // Return the helper variable we built up
        return maxCount;
        
    }
}