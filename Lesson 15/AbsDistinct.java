import java.util.*;

class Solution {
    public int solution(int[] A) {
        
        // Initialize a helper HashSet to track distinct 
        // values without any duplicates. 
        HashSet<Integer> intSet = new HashSet<Integer>();
        
        // Iterate over the given values and add the
        // absolute value to the set
        for (int value : A) {
            
            intSet.add((value < 0) ? -value : value);
            
        }
        
        // Return the size of the HashSet
        return intSet.size();
        
    }
}