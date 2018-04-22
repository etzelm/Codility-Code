#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> &A, int K) {
    if (A.empty()) return A;                    //Catch an empty vector
    for (int i=0; i<K; ++i) {                   //Create loop of size K
        auto it = A.begin();                    //Create iterator pointing to front
        A.insert(it, A.back());                 //Insert last element at the front
        A.pop_back();                           //Pop the last element off
    }
    return A;                                   //Return new vector
}
