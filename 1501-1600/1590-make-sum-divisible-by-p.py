#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1590-make-sum-divisible-by-p.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-11-06


from typing import List


class Solution:
    def minSubarray_tle(self, nums: List[int], p: int) -> int:
        n_nums = len(nums)
        prefix_sum = [0]
        for n in nums:
            prefix_sum.append((prefix_sum[-1] + n) % p)

        target_val = prefix_sum[-1]
        if target_val == 0:
            return 0

        min_len = n_nums
        for i in range(n_nums):
            for j in range(i + 1, n_nums + 1):
                v = (prefix_sum[j] - prefix_sum[i]) % p
                if v == target_val:
                    min_len = min(min_len, j - i)
                    # first one is best one
                    break
            # fast return
            if min_len == 1:
                return min_len
        if min_len == n_nums:
            return -1
        return min_len

    def minSubarray(self, nums: List[int], p: int) -> int:
        n_nums = len(nums)

        target_val = sum(e % p for e in nums) % p
        if target_val == 0:
            return 0

        min_len = n_nums
        rd = {0: -1}
        num_sum = 0
        for i, v in enumerate(nums):
            num_sum += v
            num_sum %= p
            cur_v = num_sum - target_val
            if cur_v < 0:
                cur_v += p
            if cur_v in rd:
                min_len = min(min_len, i - rd[cur_v])

            rd[num_sum] = i

            # fast return
            if min_len == 1:
                return min_len

        if min_len == n_nums:
            return -1
        return min_len


if __name__ == "__main__":
    s = Solution()
    # 7
    print(s.minSubarray(
            [8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2], 148
        )
    )
    # 1
    print(s.minSubarray([3, 1, 4, 2], 6))
    # 2
    print(s.minSubarray([6, 3, 5, 2], 9))
    # 0
    print(s.minSubarray([1, 2, 3], 3))
    # -1
    print(s.minSubarray([1, 2, 3], 7))
    # 0
    print(s.minSubarray([1000000000, 1000000000, 1000000000], 3))
