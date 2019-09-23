class Solution {
    
    public int solution(int N, int M) {

        // All we need to do is return the least 
        // common multiple by doing a little math 
        // and recursively generating the greatest 
        // common denominator
        return N / greatestCommonDenom(N, M);
        
    }
    
    // Recursive function to generate GCD
    public int greatestCommonDenom(int N, int M) {
        
        // Catch the end case where there is no 
        // remainder and we can return the GCD 
        // up the stack 
        if (N % M == 0) return M;
        
        // Otherwise there is a remainder and we 
        // keep recusively calling this function, 
        // this time passing the remainder along
	    return greatestCommonDenom(M, N % M);
	    
	}
	
}