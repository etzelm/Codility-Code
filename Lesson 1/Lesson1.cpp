#include <iostream>
#include <memory>
#include <string>

const auto INT_SIZE = sizeof(int)*8;                                        //Create const to represent maximum length of our string

int solution(int N){
    std::unique_ptr<std::string> bin(new std::string(INT_SIZE, '0'));       //Create string of 0's w/ maximum binary int length
    auto pos = INT_SIZE-1;                                                  //Create index set for last string char
    auto max_gap = 0, tmp_gap = 0;                                          //Create hold variables for comparing calculated gap

    while(N > 0 and (N%2 == 0)) {                                           //Check for leading zeros in given integer's binary representation
        N /= 2;                                                             //Skip leading zeros to catch certain edge cases, e.g. powers of 2
    }


    while(N > 0){                                                           //Ensure's O(log_n) time complexity because number of bits in N is log(N)
        if(N % 2){                                                          //Check for if we need to set a binary bit
            bin->operator[](pos) = '1';                                     //Set the correct binary bit
            max_gap = max_gap > tmp_gap ? max_gap : tmp_gap;                //Check if the current gap is the largest so far
            tmp_gap = 0;                                                    //Reset gap counter
        }else{
            ++tmp_gap;                                                      //Otherwise count the current zero as a gap member
        }
        N /= 2;                                                             //Go to the next bit
        --pos;                                                              //Decrement our index
    }

    return max_gap;                                                         //Return the calculated max gap
}

int main(){
    int n;

    std::cout << "Enter number to find its largest binary gap: ";
    std::cin >> n;

    std::cout << "Calculated gap: " << solution(n);

    return 0;
}
