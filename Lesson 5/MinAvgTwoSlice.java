class Solution {
    public int solution(int[] A) {

        int minLocation = 0;
        double minSlice = (A[0] + A[1]) / 2;
        double currentSlice;
        
        for (int iter=0; iter<A.length-2; iter++) {
            
            currentSlice = ( (double) (A[iter] + A[iter+1]) ) / 2;
            if (currentSlice < minSlice) {
                minSlice = currentSlice;
                minLocation = i;
            }
            
            currentSlice = ( (double) (A[i] + A[i+1] + A[i+2]) ) / 3;
            if (currentSlice < minSlice) {
                minSlice = currentSlice;
                minLocation = i;
            }
        }

        currentSlice = ( (double) (A[A.length-2] + A[A.length-1]) ) / 2;
        if (currentSlice < minSlice) {
            minSlice = currentSlice;
            minLocation = A.length - 2;
        }

        return minLocation;
    }
}

/* class Solution {
    public int solution(int[] A) {
        
        int[] prefixSums = new int[A.length+1];
        double minSlice = 1000000000, currentSlice = 0, numer = 0, denom = 0;
        int iter, iter2, minLocation = 1000000000;
        
        for (iter=0; iter<A.length; iter++) {
            prefixSums[iter+1] = prefixSums[iter] + A[iter];
        }
        
        iter2 = prefixSums.length-1;
        for (iter=0; iter<prefixSums.length; iter++) {
            int hold = (iter+2 > prefixSums.length-1) ? prefixSums.length-1 : iter+2;
            numer = (double) (prefixSums[hold] - prefixSums[0]);
            denom = (double) (iter+2);
            currentSlice = numer/denom;
            if (currentSlice < minSlice) {
                minSlice = currentSlice;
                minLocation = 0;
            }

            numer = (double) (prefixSums[prefixSums.length-1] - prefixSums[iter]);
            denom = (double) (prefixSums.length-iter-1);
            currentSlice = numer/denom;
            
            if (currentSlice < minSlice) {
                minSlice = currentSlice;
                minLocation = iter;
            }

            if (iter2 > iter) {
                denom = iter2 - iter;
                currentSlice = (prefixSums[iter2] - prefixSums[iter])/denom;
                if (currentSlice < minSlice) {
                    minSlice = currentSlice;
                    minLocation = iter;
                }
            }
            
            iter2--;
        }
        
        return minLocation-1;
    }
} */