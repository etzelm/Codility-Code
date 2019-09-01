import java.util.*;

class Solution {
    public int solution(int[] A) {
        
        // Initialize a counter variable and a set to keep track 
        // of the zeros that we have seen so far
        int counter = 0;
        Set<Integer> zeroSet = new HashSet<Integer>();
        
        // Iterate over all the values in the given array. If its 
        // a zero just add it to the set, otherwise its a one and 
        // we need to increment the counter by the amount of zeros 
        // that we have seen so far.
        for (int iter=0; iter<A.length; iter++) {
            if (A[iter] == 0) {
                zeroSet.add(iter);
            } else {
                counter += zeroSet.size();
                if (counter > 1000000000) return -1;
            }
        }
        
        return counter;
    }
}
