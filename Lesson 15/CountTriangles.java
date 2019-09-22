import java.util.*;

class Solution {
    public int solution(int[] A) {
            
        // Catch simple cases that dont need to be considered aka triangles require three sides
        if (A.length < 3) return 0;

        // Sort the array, no such mention of elements being attached to the indexes theyre 
        // originally given
        Arrays.sort(A);
        
        // Initialize a helper variable to track our count of possible triangles
        int triangleCount = 0;
        
        // Find the maximal right iterator that can be a triangle for every left and middle 
        // iterator combination. With the given array being sorted now, all we need to do is count 
        // the triangles from the maximal right iter to the middle iter
        for (int leftIter = 0; leftIter < A.length; leftIter++) {

            int rightIter = leftIter + 1;
            for (int midIter = leftIter + 1; rightIter < A.length; rightIter++) {

                while (rightIter < A.length && A[leftIter] + A[midIter] > A[rightIter]) rightIter++;
                triangleCount += rightIter - midIter - 1;

            }
        }
        
        // Return the count of possible triangles we have build up
        return triangleCount;
        
    }
}