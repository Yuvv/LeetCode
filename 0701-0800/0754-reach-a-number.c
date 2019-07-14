/*
 * File: 0754-reach-a-number.c
 * Date: 2019/07/14
 * Author: Yuvv <yuvv_th@outlook.com>
 */

#include <stdio.h>
#include <math.h>


int reachNumber(int target) {
    target = abs(target);
    int pos = 0;
    int adder = 1;
    while (pos < target) {
        pos += adder;
        adder++;
    }
    int right_dis = pos - target;
    if (right_dis % 2 == 0) {
        return adder - 1;
    } else {
        right_dis += adder;
        if (right_dis % 2 == 0) {
            return adder;
        } else {
            return adder + 1;
        }
    }
}


int main(int argc, char** argv) {
    printf("=> %d\n", reachNumber(3));   // 2 expectec
    printf("=> %d\n", reachNumber(2));   // 3 expectec
    printf("=> %d\n", reachNumber(30));  // 8 expectec
    printf("=> %d\n", reachNumber(-159));  // 18 expectec

    return 0;
}
