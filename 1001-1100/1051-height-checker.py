from typing import List


class Solution:
    """
    https://leetcode.com/problems/height-checker/
    找出非正序排序的数
    """

    def heightChecker(self, heights: List[int]) -> int:
        sorted_heights = sorted(heights)
        result = 0
        idx = 0
        stu_len = len(heights)
        while idx < stu_len:
            if heights[idx] != sorted_heights[idx]:
                result += 1
            idx += 1

        return result

if __name__ == "__main__":
    s = Solution()
    # 3  expected
    print(s.heightChecker([1, 1, 4, 2, 1, 3]))
    # 5 expected
    print(s.heightChecker([1, 1, 6, 2, 3, 4, 5, 6]))
