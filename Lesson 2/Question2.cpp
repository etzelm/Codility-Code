#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> &A, int K) {
    // write your code in C++14 (g++ 6.2.0)
    if(A.empty()) {return A;}                                               //Catch an empty vector
    for(int i=0; i<K; ++i) {                                                //Create loop of size K
        auto it = A.begin();                                                //Create iterator pointing to front
        A.insert(it, A.back());                                             //Insert last element at the front
        A.pop_back();                                                       //Pop the last element off
    }
    return A;                                                               //Return new vector
}

int main() {
    int myints[] = {1,2,3,4,5,6,7};
    vector<int> test (myints, myints + sizeof(myints) / sizeof(int) );
    vector<int> answer;
    answer = solution(test, 3);
    for(auto const& value: answer) {cout << value;}
}
