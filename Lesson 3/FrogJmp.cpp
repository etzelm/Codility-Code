#include <math.h>
#include <iostream>

int solution(int X, int Y, int D) {
    long double x = X, y = Y, d = D;
    long double tmp = ceil((y-x)/d);
    return(tmp);
}
