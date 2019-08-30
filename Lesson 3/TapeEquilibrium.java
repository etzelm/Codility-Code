class Solution {
    public int solution(int[] A) {

        // Initialize all the different helper variables
        int leftSum = 0, rightSum = 0, diffValue = 0, minValue = 1000000;
        
        // Generate the sum of all values in the array to keep track of 
        // what's being weighted against as we move right across the array
        for (int value : A) {
            rightSum += value;
        }
        
        // Start at the left of the array and generate the weights to keep
        // track of the lowest equilibrium point we see between the left
        // and right sides.
        for (int iter=0; iter<A.length-1; iter++) {
            leftSum += A[iter];
            rightSum -= A[iter];
            diffValue = (leftSum - rightSum) > 0 ? 
                            (leftSum - rightSum) : -(leftSum - rightSum);
            minValue = minValue < diffValue ? minValue : diffValue;
        }
        
        return minValue;
        
    }
}
