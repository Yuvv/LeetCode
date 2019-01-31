/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 删除一个元素
     * https://leetcode.com/problems/delete-node-in-a-linked-list/
     *
     * @param node 当前节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}