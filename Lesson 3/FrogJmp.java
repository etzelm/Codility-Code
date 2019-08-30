class Solution {
    public int solution(int X, int Y, int D) {
        
        // Subtract start from end to get travel distance, divide by jump distance 
        // to get the number of jumps
        if (((Y - X) % D) == 0) return ((Y - X) / D);
        // If there is a remainder, add an extra hop
        else return ((Y - X) / D) + 1;
        
    }
}