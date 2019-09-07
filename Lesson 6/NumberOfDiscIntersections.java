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
        // need to find: left + A[left] > N - 1 and why the sum 
        // array only needs to be of size N for our purposes
        // 
        // Initialize a helper variable for the length of A and a 
        // helper array to keep track of the sum of the farthest 
        // right points that are smaller than the farthest left 
        // points that are greater than zero in any of the given 
        // circles that happen at at that point on the number 
        // line(array index). 
        int N = A.length;
        int[] sumArray = new int[N];
        
        // Iterate over the given array and find the farthest 
        // right points of the given circles that are smaller 
        // than the farthest left points that are greater than 
        // zero and increment that spot on the sum array. If the 
        // equation doesnt hold increment the N - 1 position  
        for (int iter = 0; iter < N; iter++) {

            if (N - 1 - iter >= A[iter]){
                sum[iter + A[iter]]++;
            } else {
                sum[N - 1]++;  
            }
            
        }
        
        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1];  //sum[i] means that there are sum[i] number of values that <= i;
        }
        
        long ans = (long) n * (n - 1) / 2;
        
        for (int i = 0; i < n; i++) {
            int left;
            
            if (A[i] > i) {
                left = 0;
            } else {
                left = i - A[i];// Find the positive i-A[i].     
            }
            
            if (left > 0){
                ans -= sum[left - 1];//Find the number that is smaller than 1-A[i], sum[n-1] will never be used as we only need sum[n-1-1] at most.  
            } 
        }
        
        if (ans > 10000000) {
            return -1;    
        }
        
        return (int) ans;
    }
}