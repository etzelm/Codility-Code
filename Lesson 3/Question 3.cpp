#include <iostream>
#include<vector>

int solution(std::vector<int> &A) {
    auto sum = 0, leftsum = 0, tmp1=0;             //Initialize Sum, Left Sum, Temp
    long long min1;                                  //Initialize Return Variable

    for (int i=0; i<A.size(); i++) {                //Iterate through array O(n)
        sum += A[i];                                //Generate Vector A's Sum
    }

    for (int j=0; j<A.size()-1; j++) {                //Iterate through array again, still O(n)
        sum -= A[j];                                //Update sum to represent right sum
        leftsum += A[j];                            //Update leftsum to represent left sum
        tmp1 = (leftsum - sum) > 0 ? (leftsum - sum) : (-1*(leftsum - sum));     //Generate Equilibrium Index
        std::cout << tmp1 << "\n";
        min1 = min1 < tmp1 ? min1 : tmp1;                //Compare to min value so far and save if less
    }
    std::cout << "min is: " << min1 << "\n";
    return min1;                              //With two for loops, non-nested, O(n) complexity(time and space)
}

int main() {
    int myints[] = {333,111,22,422,43};
    std::vector<int> test (myints, myints + sizeof(myints) / sizeof(int) );
    std::cout << solution(test);

}
