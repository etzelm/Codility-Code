// ('TC', [0, 0, 1], [0, 1, 1])
// ('AC', [0, 0, 1], [0, 1, 1])

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        
        // Initialize a two dimensional array to track the prefix sums
        // of the first three nucleotide characters seen, the fourth can
        // be inferred via a lack of the first three. Other variables are 
        // for help with iteration, sums, and minimizing function calls
        int[][] prefixSums = new int[3][S.length()+1];
        int[] returnArray = new int[P.length];
        int a, c, g, iter;
        char temp;
        
        // Prefix sums are generated within a new array of size N+1, they 
        // help keep track of what was seen so far at any slice of the 
        // given array. They can be generated in O(N) time which can help 
        // to avoid iteration inside an iteration when having to work with 
        // different slices of an array per original iteration
        for (iter=0; iter<S.length(); iter++) {
            temp = S.charAt(iter);
            a = 0;c = 0;g = 0;
            if (temp == 'A') {
                a = 1;
            } else if (temp == 'C') {
                c = 1;
            } else if (temp == 'G') {
                g = 1;
            }
            prefixSums[0][iter+1] = prefixSums[0][iter] + a;
            prefixSums[1][iter+1] = prefixSums[1][iter] + c;
            prefixSums[2][iter+1] = prefixSums[2][iter] + g;
        }
        
        // Using the generated prefix sums we can check if any of the given 
        // slices of A from P and Q have seen a certain nucleotide character 
        // by checking that the prefix sum for that slice is greater than 0
        for (iter=0; iter<P.length; iter++) {
            if ((prefixSums[0][Q[iter]+1] - prefixSums[0][P[iter]]) > 0) {
                returnArray[iter] = 1;
            } else if ((prefixSums[1][Q[iter]+1] - prefixSums[1][P[iter]]) > 0) {
                returnArray[iter] = 2;
            } else if ((prefixSums[2][Q[iter]+1] - prefixSums[2][P[iter]]) > 0) {
                returnArray[iter] = 3;
            } else {
                returnArray[iter] = 4;
            }
        }
        
        return returnArray;
        
    }
}

// Correct but inefficient solution to problem
/* class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        
        int[] returnArray = new int[P.length];
        
        for (int iter=0; iter<P.length; iter++) {
            returnArray[iter] = helper(S, P[iter], Q[iter]);
        }
        
        return returnArray;S.
        
    }
    
    public int helper(String S, int left, int right) {
        String subString = S.substring(left, right+1);
        if (subString.contains("A")) {
            return 1;
        } else if (subString.contains("C")) {
            return 2;
        }
        else if (subString.contains("G")) {
            return 3;
        }
        else if (subString.contains("T")) {
            return 4;
        }
        return -1;
    }
} */