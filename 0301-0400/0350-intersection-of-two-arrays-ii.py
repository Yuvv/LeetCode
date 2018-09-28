class Solution:
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        d = dict()
        for num in nums1:
            if d.get(num) is None:
                d[num] = 1
            else:
                d[num] += 1
        res = list()
        for num in nums2:
            if d.get(num) and d.get(num) > 0:
                d[num] -= 1
                res.append(num)
        return res
