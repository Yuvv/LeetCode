/*
 * Filename: 1317-convert-integer-to-the-sum-of-two-no-zero-integers.c
 * Created Date: 2020/1/18
 * Author: Yuvv <yuvv_th@outlook.com>
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool isNoZeroInteget(int n) {
    while (n > 0) {
        if (n % 10 == 0) {
            return false;
        }
        n /= 10;
    }
    return true;
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getNoZeroIntegers(int n, int* returnSize) {
    int* result = malloc(sizeof(int) * 2);
    *returnSize = 2;

    result[0] = n / 2;
    result[1] = n - result[0];
    while (result[0] > 0 && (!isNoZeroInteget(result[0]) || !isNoZeroInteget(result[1]))) {
        result[0] -= 1;
        result[1] += 1;
    }
    return result;
}

int main(int argc, char** argv) {
    int returnSize;
    int* result;
    result = getNoZeroIntegers(12, &returnSize);
    printf("[%d, %d]\n", result[0], result[1]);
    result = getNoZeroIntegers(10101, &returnSize);
    printf("[%d, %d]\n", result[0], result[1]);
    return 0;
}