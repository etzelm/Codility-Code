import java.util.*;

class Solution {
    public int solution(int X, int[] A) {
        
        // Initialize a Set to contain the positions seen so far
        Set<Integer> intSet = new HashSet<Integer>();
        
        // Iterate over the array, trying to add each A[iter] position to the 
        // array. Once the set's size is equal to X it confirms the frog can  
        // cross the river and we return iter's current value as the earliest 
        // time the frog can cross the river
        for (int iter=0; iter<A.length; iter++) {
            intSet.add(A[iter]);
            if (intSet.size() == X) return iter; 
        }
        
        return -1;
    }
}