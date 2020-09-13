#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int countGoodTriplets(vector<int>& arr, int a, int b, int c) {
        int count = 0;
        int v_len = arr.size();
        int i, j, k;

        for (i = 0; i < v_len - 2; i++) {
            for (j = i + 1; j < v_len - 1; j++) {
                for (k = j + 1; k < v_len; k++) {
                    if (abs(arr[i] - arr[k]) > c) {
                        continue;
                    } else if (abs(arr[j] - arr[k]) > b) {
                        continue;
                    } else if (abs(arr[i] - arr[j]) > a) {
                        continue;
                    } else {
                        count++;
                    }
                }
            }
        }

        return count;
    }
};

int main(int argc, char** argv) {
    Solution s;

    vector<int> v1 = {3, 0, 1, 1, 9, 7};
    cout << s.countGoodTriplets(v1, 7, 2, 3) << endl;

    return 0;
}