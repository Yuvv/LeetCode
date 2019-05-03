from typing import List

class Solution:
    """
    找出能够被自身的数字整除的数（自除数）
    https://leetcode.com/problems/self-dividing-numbers/
    """
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        result = []
        for num in range(left, right + 1):
            if self.isSDN(num):
                result.append(num)
        return result

    def isSDN(self, num) -> bool:
        that_num = num
        while that_num > 0:
            value = that_num % 10
            if value == 0:
                return False
            if num % value > 0:
                return False
            that_num //= 10
        return True


if __name__ == "__main__":
    s = Solution()
    # [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]  expected
    print(s.selfDividingNumbers(1, 22))