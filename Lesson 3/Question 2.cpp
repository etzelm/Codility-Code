#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> &A) {
    if (A.empty()) return 1;
    auto xor_sum = 0;                           //Create hold for the xor sum
    for(int i = 0; i<A.size(); i++) {           //Iterate through each element of array
        xor_sum = xor_sum^A[i]^(i+1);         //xor the sum with the current member of the array
    }
    return (xor_sum^(A.size()+1));                   //The remaining value is the odd element out
}

int main() {
    int myints[] = {2, 3, 1, 5};
    vector<int> test (myints, myints + sizeof(myints) / sizeof(int) );
    cout << solution(test);
}
