class Solution {
    public int solution(int K, int[] A) {
        
        // Initialize two helper variables to track 
        // the length of the current ropes we're tying
        // together and the amount of strings we've tied
        // together that have a length greater than or 
        // equal to the given value of K
        int currentLength=0, ropeCount=0;
        
        // Iterate over the given rope lengths
        for (int rope : A) {
            
            // Tie the current rope to the previous 
            // string we have created, if there is one
            currentLength += rope;
            
            // If the current string is greater than
            // or equal to K, we increment the rope count
            // and reset the helper variable we use to 
            // track our string length
            if (currentLength >= K) {
                
                ropeCount++;
                currentLength = 0;
                
            }
            
        }

        // Return the count of strings we've tied together
        return ropeCount;
        
    }
}