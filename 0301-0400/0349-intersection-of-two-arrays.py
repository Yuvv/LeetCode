class Solution:
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        s = set(nums1)
        res = set()
        for num in nums2:
            if num in s:
                res.add(num)
        return list(res)
