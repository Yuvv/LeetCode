#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2058-find-the-minimum-and-maximum-number-of-nodes-between-critical-points.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-11-01


from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        idx_list = []

        pre_node = head
        head = head.next
        i = 1
        while head:
            if head.next:
                if head.val > pre_node.val and head.val > head.next.val:
                    # local maxima
                    idx_list.append(i)
                if head.val < pre_node.val and head.val < head.next.val:
                    # local minima
                    idx_list.append(i)

            # iter
            i += 1
            pre_node = head
            head = head.next

        # get min
        if len(idx_list) < 2:
            return [-1, -1]
        dis_max = idx_list[-1] - idx_list[0]
        dis_min = min(idx_list[i] - idx_list[i - 1] for i in range(1, len(idx_list)))
        return [dis_min, dis_max]


def build_test_case(lst) -> ListNode:
    head = ListNode(lst[0])
    cur = head
    for i in lst[1:]:
        cur.next = ListNode(i)
        cur = cur.next
    return head


if __name__ == '__main__':
    s = Solution()
    # [-1, -1]
    print(s.nodesBetweenCriticalPoints(build_test_case([3, 1])))
    # [1, 3]
    print(s.nodesBetweenCriticalPoints(build_test_case([5, 3, 1, 2, 5, 1, 2])))
    # [1, 21]
    head = build_test_case([1, 2, 3, 4, 5, 3, 2, 2, 3, 4, 5, 56, 6, 7, 8, 56, 5, 3, 32, 12, 5, 3, 4, 5, 3, 2, 4])
    print(s.nodesBetweenCriticalPoints(head))
