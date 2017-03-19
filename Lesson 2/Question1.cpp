#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> &A) {
    auto xor_sum = 0;                           //Create hold for the xor sum
    for(int i = 0; i<A.size(); i++) {           //Iterate through each element of array
        xor_sum ^= A[i];                        //xor the sum with the current member of the array
    }
    return xor_sum;                             //The remaining value is the odd element out
}

int main() {
    int myints[] = {9,3,9,3,9,7,9};
    vector<int> test (myints, myints + sizeof(myints) / sizeof(int) );
    cout << solution(test);
}
