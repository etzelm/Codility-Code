class Solution {
    public int solution(int A, int B, int K) {
        
        // This is purely a math problem. For int A, the number of integers 
        // in the range [1 ... A] that are divisible by K are A/K. We want 
        // the range [A ... B], so we just subtract A/K from B/K keeping 
        // track of if A is included in the count or not.
        return (B/K) - (A/K) + (A%K == 0 ? 1 : 0);
        
    }
}
// Inefficient, brute force solution
/* class Solution {
    public int solution(int A, int B, int K) {
        
        int counter = 0;
        
        for (int iter=A; iter < B+1; iter++) {
            if (iter%K == 0) counter++;
        }
        
        return counter;
    }
} */