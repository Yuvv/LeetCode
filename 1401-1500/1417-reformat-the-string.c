#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

char* reformat(char* s) {
    int sLen = strlen(s);
    if (sLen <= 1) {
        return s;
    }
    // 预留一个位置，解决顺序问题
    char* rs = malloc(sizeof(char) * (sLen + 2));
    rs[sLen + 1] = '\0';
    // 记录字母和数字的数量
    int numCount = 0, alphaCount = 0;
    // 记录字母和数字的位置
    int numPos = 1, alphaPos = 2;
    for (int i = 0; i < sLen; i++) {
        if (s[i] >= '0' && s[i] <= '9') {
            rs[numPos] = s[i];
            numCount++;
            numPos += 2;
            if (numPos > sLen) {
                numPos = 0;
            }
        } else if (s[i] >= 'a' && s[i] <= 'z') {
            rs[alphaPos] = s[i];
            alphaCount++;
            alphaPos += 2;
            if (alphaPos > sLen) {
                alphaPos = 0;
            }
        }
    }
    if (abs(numCount - alphaCount) > 1) {
        return "";
    }
    if (numPos > alphaPos) {
        rs[sLen] = '\0';
        return rs;
    }
    return rs + 1;
}

int main(int argc, char** argv) {
    // 01ab2c expected
    printf("%s\n", reformat("a0b1c2"));
    // `` expected
    printf("%s\n", reformat("12222"));
    // `1` expected
    printf("%s\n", reformat("1"));
    // `j` expected
    printf("%s\n", reformat("j"));
    // c2o0v1i9d expected
    printf("%s\n", reformat("covid2019"));

    return 0;
}
