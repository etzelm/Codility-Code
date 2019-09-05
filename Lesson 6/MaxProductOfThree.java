// [-3, 1, 2, -2, 5, 6]
// [-10, -2, -4]
// [-5, 5, -5, 4]

import java.util.*;

class Solution {
    public int solution(int[] A) {
        
        // Initialize some helper variables
        int maxValue=-1000000000, hold=0, N=A.length;
        
        // Sort the given array
        Arrays.sort(A);
        
        // Check the largest three numbers first
        hold = A[N-1] * A[N-2] * A[N-3];
        if (maxValue < hold) maxValue = hold;
        
        // Lastly there could be two large negative 
        // values that can cancel each other out 
        // when used with the largest value
        hold = A[0] * A[1] * A[N-1];
        if (maxValue < hold) maxValue = hold;
        
        return maxValue;
        
    }
}
