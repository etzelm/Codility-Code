import java.util.*;

class Solution {
    public int solution(int[] A) {
        
        // Initialize a Set to keep track of distinct elements
        // aka no duplicates
        Set<Integer> intSet = new HashSet<Integer>();
        
        // Add all the values into the set, duplicates have no 
        // effect in this process
        for (int value : A) {
            intSet.add(value);
        }
        
        // Return the number of elements in the set
        return intSet.size();
    }
}
