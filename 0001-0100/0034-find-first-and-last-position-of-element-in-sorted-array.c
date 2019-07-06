/*
 * Filename: 0034-find-first-and-last-position-of-element-in-sorted-array.c
 * Created Date: 2019/07/06
 * Author: Yuvv <yuvv_th@outlook.com>
 *
 * Copyright (c) 2019
 */

 #include <stdio.h>
 #include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* searchRange(int* nums, int numsSize, int target, int* returnSize){
    *returnSize = 2;
    // 这里不加 static 的话会报 load null pointer 的错误，因为`int result[2]`是一个自动变量的数组退出函数后就被清空了。。。
    // static int result[2] = {-1, -1};
    // 加了 static 之后又因为多个用例重复运行，读到的值还是上次的值。。。
    int* result = malloc(sizeof(int) * 2);
    result[0] = -1;
    result[1] = -1;
    if (numsSize == 0) {
        return result;
    }
    int begin = 0, end = numsSize - 1;
    int mid;
    while (begin <= end) {
        mid = (begin + end) / 2;
        if (nums[mid] == target) {
            break;
        } else if (nums[mid] > target) {
            end = mid - 1;
        } else {
            begin = mid + 1;
        }
    }
    if (nums[mid] == target) {
        begin = mid - 1;
        while (begin >= 0) {
            // 不把他写到下面就会报 AddressSanitizer heap-buffer-overflow
            if (nums[begin] != target) {
                break;
            }
            begin--;
        }
        result[0] = begin + 1;
        end = mid + 1;
        while (end < numsSize) {
            if (nums[end] != target) {
                break;
            }
            end++;
        }
        result[1] = end - 1;
    }
    return result;
}

int main(int argc, char** argv) {
    int* resultSize = malloc(sizeof(int));
    int* result;
    int nums[6] = {5, 7, 7, 8, 8, 8};
    result = searchRange(nums, 6, 8, resultSize);
    printf("[%d, %d]\n", result[0], result[1]);  // [3, 4] expected
    result = searchRange(nums, 6, 6, resultSize);
    printf("[%d, %d]\n", result[0], result[1]);  // [-1, -1] expected
    free(resultSize);
    free(result);

    return 0;
}