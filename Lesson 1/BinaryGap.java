class Solution {
    public int solution(int N) {
        
        boolean startFlag = false;
        int counter = 0, maxBGSeen = 0;
        
        // Try to remove leading zeros if possible
        while ((N > 0) && (N%2 == 0)) {
            N /= 2;
        }
        
        // Iterate over all bits in a 32 bit number to be safe (max size of Java8 int)
        // 2,147,483,647 is max size of 31 bits with a bit saved for int negation
        for (int iter = 0; iter < 31; iter++) {
            // Get the number for the bit we are currently iterating over
            int mask = 1 << iter;
            
            // Check if we have found the first one bit seen so far
            if (((N & mask) != 0) && !startFlag) startFlag = true;
            // If we have started counting and we find a zero bit, increment counter
            else if (((N & mask) == 0) && startFlag) counter++;
            // If we have started counting and we find a one bit, check max seen
            // so far and reset counter
            else if (((N & mask) != 0) && startFlag) {
                if (maxBGSeen < counter) maxBGSeen = counter;
                counter = 0;
            }
            
        }
        
        return maxBGSeen;
    }
}
