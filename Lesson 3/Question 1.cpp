#include <math.h>
#include <iostream>

int solution(int X, int Y, int D) {
    long double x = X;
    long double y = Y;
    long double d = D;
    long double tmp = ceil((y-x)/d);
    return(tmp);
}

int main() {
    std::cout<< solution(10,85,30);

}
