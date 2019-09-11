import java.util.*;

class Solution {
    public int solution(int[] A) {

        // Catch the simple base case where the array has one element
        if (A.length == 1) return 0;
        
        // Instantiate a Map of type Integer to Integer to help us keep 
        // track of the int values we have seen and how many times we 
        // have seen them
        Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();
        
        // Iterate over the given values in the array and check to see 
        // if they are already contained inside the map. If not put the 
        // value onto the map mapped to a count of one. Otherwise the 
        // value is already in the map with a count value associated to
        // it. Get the count value, increment it, and then check to see 
        // if its the dominator value. If so, return the iterator pointing 
        // at the given values location in the array, otherwise replace 
        // the counter value for this given value with the new incremented
        // temp value.
        for (int iter=0; iter<A.length; iter++) {
            
            if (!intMap.containsKey(A[iter])) intMap.put(A[iter], 1);
            else {
                int temp = intMap.get(A[iter]);
                temp++;
                if (temp > A.length / 2) return iter;
                intMap.replace(A[iter], temp);
            }
            
        }
        
        // If we can reach here it is guaranteed there is no dominator
        return -1;
        
    }
}