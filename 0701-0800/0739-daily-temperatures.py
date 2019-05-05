from typing import List


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        """
        https://leetcode.com/problems/daily-temperatures/
        查找数组中下一个较大数的位置。
        解法：建一个栈，然后顺序遍历，如果找到较大数就出栈，否则添加 0，因此栈中应该为非增数组
        """
        stack = []
        result = []
        for i, ele in enumerate(T):
            result.append(0)
            while len(stack) > 0:
                ele_index = stack.pop()
                if ele > T[ele_index]:
                    result[ele_index] = i - ele_index
                else:
                    stack.append(ele_index)
                    break
            stack.append(i)
        return result


if __name__ == "__main__":
    s = Solution()
    # [1, 1, 4, 2, 1, 1, 0, 0] expected
    print(s.dailyTemperatures([93, 74, 75, 71, 69, 72, 76, 73]))
