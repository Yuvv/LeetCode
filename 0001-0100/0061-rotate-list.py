#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0061-rotate-list.py
# @Date   : 2019/10/06
# @Author : Yuvv <yuvv_th@outlook.com>


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head is None or k == 0:
            # 空链表或不移动的直接返回
            return head

        ln_len = 1
        ln_head = head
        ln_tail = head

        while ln_tail is not None and ln_tail.next is not None:
            # 尾指针走到最后一个数的位置，同时计数
            ln_tail = ln_tail.next
            ln_len += 1

        # 移动数目取余（循环移动的情况）
        k %= ln_len

        if ln_len == 1 or k == 0:
            # 只有一个元素或循环移动的也直接返回
            return head

        # 将头指针移动到即将成为尾指针的位置
        for _ in range(0, ln_len - k - 1):
            ln_head = ln_head.next

        # 切割后拼接
        result_head = ln_head.next
        ln_head.next = None
        ln_tail.next = head
        return result_head



if __name__ == "__main__":
    s = Solution()
    # 1->2->3->4->5->NULL, k = 2  ==>  4->5->1->2->3->NULL
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    result_head = s.rotateRight(head, 2)
    while result_head:
        print(result_head.val, end='')
        print('->', end='')
        result_head = result_head.next
    print('NULL')

    # 0->1->2->NULL, k = 4  ==>  2->0->1->NULL
    head = ListNode(0)
    head.next = ListNode(1)
    head.next.next = ListNode(2)
    result_head = s.rotateRight(head, 4)
    while result_head:
        print(result_head.val, end='')
        print('->', end='')
        result_head = result_head.next
    print('NULL')
