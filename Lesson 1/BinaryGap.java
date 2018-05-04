class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        
        boolean flag = false;
        int count = 0, max_count = 0;
        
        while (N > 0 and (N%2 == 0)) {                                
            N /= 2;                                                  
        }

        for (int it = 0; it < 31; it++) {
            int mask = 1 << it;
            //System.out.printf("Bit: %d\n", ((N & mask) != 0 ? 1 : 0));
            if (((N & mask) != 0) && !flag) flag = true;
            else if ((!((N & mask) != 0)) && flag) count++;
            else if (((N & mask) != 0) && flag) {
                if (max_count < count) max_count = count;
                count = 0;
            }
        }
        
        return max_count;
    }
}