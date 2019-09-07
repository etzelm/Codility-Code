class Solution {

    public int solution(int[] A) {

        // Two of the given circles intersect if the following  
        // equation holds: 
        //
        // left circle            right circle
        // farthest right point > farthest left point
        // left + A[left]       > right - A[right]
        //
        // Any Farthest Left Point (right - A[right]) cannot have 
        // a larger value than N - 1 considering a 0 length radius 
        // for the circle at position N - 1. This means we only  
        // need to find: left + A[left] > N - 1 
        // 
        // Initialize a helper variable for the length of A, another 
        // to track the amount of intersections seen, and a 
        // helper array to keep track of the sum of the farthest 
        // right points that are smaller than the farthest possible 
        // left point in any of the given circles. This helps find the 
        // non-intersections so we can subtract them from the total 
        // possible intersections to get the correct answer.  
        // N * (N - 1) / 2 is the maximum number of insections(pairs) 
        // that can possibly come from N items
        int N = A.length;
        int[] sumArray = new int[N];
        long intersections = (long) N * (N - 1) / 2;
        
        // To find non-intersections iterate over the given array and 
        // find the farthest right point of the current circle. Then  
        // check if its smaller than the farthest possible left point 
        // and increment that spot on the sum array if it is
        for (int iter = 0; iter < N; iter++) {

            // Using the equation this way avoids integer overload
            if (N - 1 - iter > A[iter]) sumArray[iter + A[iter]]++;
            
        }
        
        // Iterate over the helper array and make the sums at any
        // point in the array cumulative for all values that are 
        // less than that point in the array
        for (int iter = 1; iter < N; iter++) {
            sumArray[iter] += sumArray[iter - 1];
        }
        
        // Iterate over the circle array once more and decrement 
        // the non-intersections from the total possible 
        // intersections when you find a positive farthest right 
        // point for the circle were currently looking at
        for (int iter = 0; iter < N; iter++) {
            
            if (A[iter] < iter) {
                intersections -= sumArray[iter - A[iter] - 1]; 
            }

        }
        
        if (intersections > 10000000) {
            return -1;    
        }
        
        return (int) intersections;
    }
}