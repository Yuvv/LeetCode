/* generate a palindrome larger than given number k.
 * k may consists of 1000000 digits
 */
#include <iostream>

using namespace std;

int plusOne(char* str, int len) {
    int i;
    for (i = len - 1; i >= 0; i--) {
        if (str[i] == '9') {
            str[i] = '0';
        } else {
            str[i] = str[i] + 1;
            break;
        }
    }
    if (i == -1) {
        for (i = len; i > 0; i--) {
            str[i] = str[i - 1];
        }
        str[0] = '1';
        len += 1;
    }
    return len;
}

int arrayLen(char* str) {
    int i = 0;
    while(str[i] != '\0') {
        i++;
    }
    return i;
}

int midPlus(char* str, int len) {
    int mid = (len + 1) / 2;
    while (str[mid - 1] == '9') {
        str[mid - 1] = '0';
        str[len - mid] = str[mid - 1];
        mid--;
    }
    str[mid - 1] += 1;
    str[len - mid] = str[mid - 1];

    return len - mid;
}

void nextPalindrome(char* str, int len) {
    int i = (len + 1) / 2;
    int lastPlusPos = len;
    while (i > 0) {
        if (str[i - 1] > str[len - i] || lastPlusPos < len - i) {
            str[len - i] = str[i - 1];
            lastPlusPos = len - i;
        } else if (str[i - 1] < str[len - i]) {
            lastPlusPos = midPlus(str, len);
            continue;
        }
        i -= 1;
    }
}

int main(int argc, char** argv) {
    int total = 0;
    char str[1000001];
    int len = 0;
    // char tmp;

    cin >> total;
    while (total--) {
        cin >> str;
        len = arrayLen(str);

        len = plusOne(str, len);
        nextPalindrome(str, len);
        str[len] = '\0';
        cout << str << endl;
    }
    return 0;
}