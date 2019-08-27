class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int leftSum = 0, rightSum = 0, diffValue = 0, minValue = 1000000;
        
        for (int value : A) {
            rightSum += value;
        }
        
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
