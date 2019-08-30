import java.util.*;

class Solution {
    
    public int solution(int[] A) {
        
        // Catch simple case before unnecessary work is done
        if (A.length == 1) return A[0];
        
        // Use a Set to determine if we've seen an int before
        Set<Integer> intSet = new HashSet<Integer>();
        // Use a Map to check which int we didnt see twice
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        // Do a single loop over the given array to check/grab values
        for (int iter=0; iter<A.length; iter++) {
            // True if first time int is added to Set, mark for sticking out
            if (intSet.add(A[iter])) map.put(A[iter], true);
            // Otherwise its the second time seeing int, mark for compliance
            else {
                intSet.remove(A[iter]);
                map.put(A[iter], false);
            }
        }
        
        // Iterate over values in Set and use Map to find non-compliance
        for (int value : intSet) {
            if (map.get(value)) return value;
        }
        
        return -1;
        
    }
}
