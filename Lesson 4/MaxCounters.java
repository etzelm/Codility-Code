import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] A) {
        
        // Initialize array to return and max value tracker
        int[] returnArray = new int[N];
        int maxValue = 0;
        
        // Iterate over each value in the given array so that we can perform the necessary work
        for (int value : A) {
            // If the value is less than N then increment the returnArray at that point and update 
            // the maxValue tracker
            if (value <= N) {
                returnArray[value-1] += 1;
                maxValue = (maxValue < returnArray[value-1]) ? 
                    returnArray[value-1] : maxValue;
            }
            // Otherwise we need to efficiently propagate the returnArray with the maxValue we have
            // so far by using System.arraycopy to copy the first element we set to maxValue at location
            // zero to location one and then in another single action copy those values into locations 
            // three and four. This continues efficiently until were done with the necessary work. 
            else {
                if (returnArray.length > 0) returnArray[0] = maxValue;
                for (int iter = 1; iter < returnArray.length; iter += iter) {
                    System.arraycopy(returnArray, 0, returnArray, iter, 
                        ((returnArray.length - iter) < iter) ? (returnArray.length - iter) : iter);
                }
            }
        }
        
        return returnArray;
        
    }
}