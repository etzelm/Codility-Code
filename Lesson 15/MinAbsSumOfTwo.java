import java.util.*;

class Solution {
    public int solution(int[] A) {
        
        // Initialize helper variables to help us keep track 
        // our places on the left and right side of the 
        // given array as well as the current and minimum 
        // sum that we have seen so far
        int leftIter = 0, rightIter = A.length - 1, sum = 0,
            minSum = Math.abs(A[leftIter] + A[rightIter]);

        // Sort the array, no such mention of elements being 
        // attached to the indexes theyre originally given
        Arrays.sort(A);

        // Iterate over the given array until the left 
        // iterator passed over the right one. Generate each
        // current sum were looking at and compare it to 
        // the minimum one weve tracked so far
        while (leftIter <= rightIter) {
            sum = A[leftIter] + A[rightIter];
            minSum = Math.min(minSum, Math.abs(sum));
            if (sum <= 0) leftIter++;
            else rightIter--;
        }

        // Return the minimum sum that we tracked
        return minSum;

    }
}
