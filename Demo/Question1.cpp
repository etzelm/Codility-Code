#include <iostream>
#include <vector>
using namespace std;

int solution(vector<int> &A) {
    // write your code in C++14 (g++ 6.2.0)

    int sum = 0;                            //Initialize Sum
    int leftsum = 0;                        //Initialize Left Sum

    for (int i=0; i<A.size(); i++) {        //Iterate through array O(n)
        sum += A[i];                        //Generate Vector A's Size
    }

    for (int j=0; j<A.size(); j++) {        //Iterate through array again, still O(n)
        sum -= A[j];                        //Update sum to represent right sum
        if (leftsum == sum) {return j;}     //Check for equality between left and right
        leftsum += A[j];                    //Otherwise update leftsum for next iteration

    }

    return -1;                              //With two for loops, non-nested, O(n) complexity(time and space)
}

int main() {
    vector<int> second(4,100);
    cout << solution(second);


}
