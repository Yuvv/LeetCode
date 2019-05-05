from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.

        https://leetcode.com/problems/move-zeroes/submissions/
        将数组中的 0 移到最后
        """
        last_index = 0
        for ele in nums:
            if ele != 0:
                nums[last_index] = ele
                last_index += 1

        while last_index < len(nums):
            nums[last_index] = 0
            last_index += 1



if __name__ == "__main__":
    lst = [0, 1, 4, 0, 6, 0]
    s = Solution()
    s.moveZeroes(lst)
    print(lst)
