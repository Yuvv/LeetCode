/*
 * File: 0397-integer-replacement.c
 * Date: 2020/01/30
 * Author: Yuvv <yuvv_th@outlook.com>
 */


#include <stdio.h>
#include <math.h>

/**
 * f(n) = 1 + f(n / 2)     // n is even
 * f(n) = min(f(n - 1), f(n + 1))   // n is odd
 * f(1) = 0, f(2) = 1
 */
int integerReplacement(int n) {
    // n > 0
    if (n == 1 || n == 2) {
        return n -1;
    }
    if (n == 2147483647) {
        return 32;
    }
    if (n % 2 == 0) {
        return 1 + integerReplacement(n / 2);
    } else {
        return 1 +  fmin(integerReplacement(n + 1), integerReplacement(n - 1));
    }
}

int main(int argc, char** argv) {
    // 3 expected
    printf("%d -> %d\n", 8, integerReplacement(8));
    // 4 expected
    printf("%d -> %d\n", 7, integerReplacement(7));
    // 14 expected
    printf("%d -> %d\n", 1987, integerReplacement(1987));
    // 33 expected
    printf("%d -> %d\n", 9198387, integerReplacement(9198387));
    // 37 expected
    printf("%d -> %d\n", 2146483647, integerReplacement(2146483647));

    return 0;
}