from typing import List


class Solution:
    """
    https://leetcode.com/problems/duplicate-zeros/
    把数组里面的 0 重复一遍，数组后面的数往后退
    """
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        arr_len = len(arr)
        i = 0
        q = list()

        while i < arr_len:
            if len(q) > 0:
                last = q.pop(0)
                q.append(arr[i])
                arr[i] = last
            if arr[i] == 0 and i < arr_len - 1:
                i += 1
                q.append(arr[i])
                arr[i] = 0
            i += 1



if __name__ == "__main__":
    s = Solution()
    arr1 = [1, 0, 2, 3, 0, 4, 5, 0]
    s.duplicateZeros(arr1)
    print(arr1)   # [1,0,0,2,3,0,0,4] excepted
    arr2 = [0, 0, 0, 1, 2, 4]
    s.duplicateZeros(arr2)
    print(arr2)  # [0, 0, 0, 0, 0, 0] excepted
