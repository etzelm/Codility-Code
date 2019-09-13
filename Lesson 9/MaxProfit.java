class Solution {
    public int solution(int[] A) {
        
        // Catch the simple empty base case
        if (A.length == 0) return 0;
    
        // Initialize helper variables to track the maximum 
        // profit and minimum buy price that we see
        int maxProfit = 0, minimumPrice = A[0], hold = 0;
        
        // Iterate over the given array starting at the 
        // second value and check the helper variables
        // against the current work
        for (int iter=1; iter<A.length; iter++) {
            
            hold = A[iter] - minimumPrice;
            if (maxProfit < hold) maxProfit = hold;
            if (A[iter] < minimumPrice) minimumPrice = A[iter];
            
        }
        
        // Return the maximum profit we saw
        return maxProfit;
            
    }
}