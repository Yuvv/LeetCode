# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        dummy_head = ListNode(-1e10)
        dummy_head.next = None
        cur = head
        while cur:
            p_prev = dummy_head
            p = dummy_head.next
            while p and p.val < cur.val:
                p_prev = p
                p = p.next
            p_prev.next = cur
            cur = cur.next
            p_prev.next.next = p
        return dummy_head.next


if __name__ == "__main__":
    s = Solution()
    unsorted_list = ListNode(4)
    unsorted_list.next = ListNode(2)
    unsorted_list.next.next = ListNode(1)
    unsorted_list.next.next.next = ListNode(3)
    result = s.insertionSortList(unsorted_list)
    while result:
        print(result.val, end='->')
        result = result.next
    print()  # 1->2->3->4   expected
