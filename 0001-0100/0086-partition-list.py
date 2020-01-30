#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0086-partition-list.py
# @Date   : 2020/01/29
# @Author : Yuvv <yuvv_th@outlook.com>


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        result_head = ListNode(None)
        pre_cur = result_head
        post_cur = None
        while head is not None:
            if head.val < x:
                pre_cur_next = pre_cur.next
                pre_cur.next = head
                head = head.next
                pre_cur.next.next = pre_cur_next
                pre_cur = pre_cur.next
            else:
                if post_cur is None:
                    post_cur = head
                    pre_cur.next = post_cur
                else:
                    post_cur.next = head
                    post_cur = post_cur.next
                head = head.next
        if post_cur is not None:
            post_cur.next = None
        return result_head.next


if __name__ == "__main__":
    s = Solution()

    head = ListNode(1)
    head.next = ListNode(4)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(2)
    head.next.next.next.next = ListNode(5)
    head.next.next.next.next.next = ListNode(2)
    # head = 1->4->3->2->5->2, x = 3   ===>  1->2->2->4->3->5  expected
    result = s.partition(head, 3)
    while result is not None:
        print(result.val, '->', end='')
        result = result.next
    print('None')
