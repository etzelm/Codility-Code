class Solution {
    public int solution(int M, int[] A) {
        
        // Catch the simple empty/single base cases
        if (A.length <= 1) return A.length;
        
        // Instantiate a helper array to keep track of what
        // integers we will see when interating over the given
        // values. We also need two int iterators to help us 
        // keep track of the distinct slices we will see and a 
        // int variable to hold the count of distinct slices
        boolean[] seen = new boolean[M+1];
        int left = 0, right = 0, sliceCount = 0;
        
        // Iterate over the given values
        while (left < A.length && right < A.length) {
            
            // If we've seen this value before mark the left 
            // most value from the slice as not seen again and 
            // increment the left iterator, this will continue 
            // until the left iterator catchs up with the right
            // iterator. Otherwise we havent and the size of the 
            // current slice were looking at is also the number 
            // we need to increment the number of distinct slice 
            // count variable by. We also make sure to mark the 
            // value as seen and increment the right iterator
            if (seen[A[right]]) { 
                seen[A[left]] = false;
                left++;
            } else { 
                sliceCount += (right - left + 1);
                if (sliceCount >= 1000000000) return 1000000000;
                seen[A[right]] = true;
                right++;
            }

        }

        // Return the distinct slice count variable
        return sliceCount;
        
    }
}