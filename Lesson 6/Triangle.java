import java.util.*;

class Solution {
    public int solution(int[] A) {
            
        // Catch simple cases that dont need to be considered
        // aka triangles require three sides
        if (A.length < 3) return 0;

        // Sort the array, no such mention of elements being 
        // attached to the indexes theyre originally given
        Arrays.sort(A);
        
        // Iterate over the sorted array and check the one 
        // given triangle condition that isnt guarenteed to 
        // be true due to the array being sorted
        // A[P] + A[Q] > A[R] or A[P] > A[R] - A[Q]
        for (int iter=0; iter<A.length-2; iter++) {
            
            if (A[iter] > 0 && A[iter] > A[iter+2] - A[iter+1]) return 1;
            
        }
        
        return 0;
        
    }
}