// ([4, 3, 2, 1, 5], [0, 1, 0, 0, 0])
// ([4, 3, 2, 1, 5], [0, 1, 1, 1, 1])
// ([4, 3, 2, 1, 5], [0, 1, 1, 0, 1])
// ([4, 3, 1, 2, 5], [0, 1, 1, 0, 1])

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        // Initialize a helper variable to keep track of the 
        // amount of live fish and a stack to keep track of 
        // the fish that are travelling downstream together
        int fishCount = A.length;
        Stack<Integer> downStack = new Stack<Integer>();
        
        // Iterate over the given arrays and keep track of 
        // the fish fights as they happen
        for (int iter=0; iter<A.length; iter++) {
            
            // This handles the simple base case of the 
            // iteration finding the first fish fight to 
            // happen. If the downstream fish wins, put it
            // on the stack. Either way decrement the fish 
            // count and increment the iterator to move on 
            // to the next relevant fish in the arrays
            if (iter+1<A.length && B[iter] == 1 && 
                B[iter+1] == 0 && downStack.empty()) {
                
                if (A[iter] > A[iter+1]) {
                    downStack.push(A[iter]);
                }
                fishCount--;
                iter++;
                
            // This handles the case where the iteration 
            // finds the first two upstream fish next to
            // each other before any fish fights have 
            // happened. We push both onto the downstream
            // stack and increment the iterator to move on 
            // to the next relevant fish in the arrays
            } else if (iter+1<A.length && B[iter] == 1 && 
                B[iter+1] == 1 && downStack.empty()) {
                    
                downStack.push(A[iter]);
                downStack.push(A[iter+1]);
                iter++;
            
            // This handles the case where the downstream 
            // stack isnt empty and it comes across a 
            // upstream fish that is looking for a fight.
            // Pop the first downstream fish the upstream 
            // fish would come across off the stack and 
            // let them fight. If the upstream fish wins,
            // continue to pop downstream fish off the 
            // stack until either it loses or the stack 
            // is empty and it can swim on unimpeded. 
            // Otherwise push the winning downstream 
            // fish back onto the stack so that it can live
            // to fight another day
            } else if (!downStack.empty() && B[iter] == 0) {
                
                boolean flag = true;
                while (flag && !downStack.empty()) {
                    
                    int temp = downStack.pop();
                    if (temp > A[iter]) {
                        downStack.push(temp);
                        fishCount--;
                        flag = false;
                    } else {
                        fishCount--;
                    }
                    
                }
                
            // This handles the case where the downstream 
            // stack isnt empty and the iteration comes 
            // across another downstream fish. Just push it
            // onto the top of the stack and iterate on
            } else if (!downStack.empty() && B[iter] == 1) {
                downStack.push(A[iter]);
            }
            
        }
        
        return fishCount;
        
    }
}
