import java.util.*;

class Solution {
    public int solution(int[] A) {
        
        // Use a Set to keep track of the values seen in the area
        Set<Integer> intSet = new HashSet<Integer>();
        for (int value : A) {
            intSet.add(value);
        }
        
        // Iterate over the expected values contained in the area
        // and return zero if one is missing
        for (int iter=1; iter<A.length+1; iter++) {
            if (!(intSet.contains(iter))) return 0;
        }
        
        // Return 1 if none of the expected values are missing
        return 1;
        
    }
}