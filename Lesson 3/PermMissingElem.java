import java.util.*;

class Solution {
    public int solution(int[] A) {
        
        // Use a Set to keep track of the elements in the given array
        Set<Integer> intSet = new HashSet<Integer>();
        for (int value : A) {
            intSet.add(value);
        }
        
        // Iterate over all the possible numbers, checking to see if 
        // a number we iterate over isnt in the Set. Return if it isnt
        for (int iter=1; iter<A.length+2; iter++) {
            if (!intSet.contains(iter)) return iter;
        }
        
        return -1;
    }
}