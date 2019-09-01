import java.util.*;

class Solution {
    public int solution(int[] A) {
        
        // Initialize variable to track largest consectutive positive integer seen
        // and initialize a set to keep track of all the values seen so far
        int smallValue = 0;
        Set<Integer> seenSet = new HashSet<Integer>();
        
        // Iterate over all the values in the array, keeping track of what comes up.
        // If we see the next consectutive positive integer we need to check that 
        // we havent already seen the one after that and so on.
        for (int value : A) {
            seenSet.add(value);
            if (value == smallValue+1) {
                int temp = value+1;
                while (seenSet.contains(temp)) {
                    temp++;
                }
                smallValue = temp-1;
            }
        }
        
        return smallValue+1;
    }
}