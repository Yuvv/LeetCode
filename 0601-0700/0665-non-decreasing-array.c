/*
 * File: 0665-non-decreasing-array.c
 * Created Date: 2019/07/06
 * Author: Yuvv
 *
 * Copyright (c) 2019
 */

#include <stdio.h>
#include <stdbool.h>

bool checkPossibility(int* nums, int numsSize){
    if (numsSize <= 1) {
        return true;
    }
    int count = 0;
    int i = 1;
    int last = nums[0];
    int lastDecreasingIndex = -1;
    while (i < numsSize) {
        if (nums[i] < last) {
            count++;
            lastDecreasingIndex = i;
            if (count > 1) {
                return false;
            }
        }
        last = nums[i];
        i++;
    }
    if (count == 1) {
        if (lastDecreasingIndex >= 2 && lastDecreasingIndex < numsSize - 1) {
            // 递减位置的两数至少有一个在周边的两个数之间，详见 case3, case4
            bool firstInRange = nums[lastDecreasingIndex + 1] >= nums[lastDecreasingIndex - 1] && nums[lastDecreasingIndex - 2] <= nums[lastDecreasingIndex - 1];
            bool secondInRange = nums[lastDecreasingIndex + 1] >= nums[lastDecreasingIndex] && nums[lastDecreasingIndex - 2] <= nums[lastDecreasingIndex];
            return firstInRange || secondInRange;
        }
    }
    return count <= 1;
}

int main(int argc, char** argv) {
    bool result;
    int nums1[6] = {1, 2, 0, 3, 4, 5};
    result = checkPossibility(nums1, 6);
    printf("%d\n", result);   // true expected
    int nums2[4] = {2, 1, 4, 3};
    result = checkPossibility(nums2, 4);
    printf("%d\n", result);   // false expected
    int nums3[4] = {3, 4, 2, 3};
    result = checkPossibility(nums3, 4);
    printf("%d\n", result);   // false expected
    int nums4[5] = {1, 3, 5, 2, 4};
    result = checkPossibility(nums4, 5);
    printf("%d\n", result);   // false expected

    return 0;
}