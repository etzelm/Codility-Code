class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        
        // Subtract start from end to get travel distance, divide by jump distance 
        // to get the number of jumps
        if (((Y - X) % D) == 0) return ((Y - X) / D);
        // If there is a remainder, add an extra hop
        else return ((Y - X) / D) + 1;
        
    }
}