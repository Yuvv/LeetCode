import java.util.*;

/*
 * 0430-flatten-a-multilevel-doubly-linked-list.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/17
 */
public class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(head);

        Node nHead = new Node();
        Node cursor = nHead;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.next != null) {
                stack.push(node.next);
                node.next = null;
            }
            if (node.child != null) {
                stack.push(node.child);
                node.child = null;
            }
            node.prev = cursor;
            cursor.next = node;
            cursor = node;
        }

        // 要把 head 的前置指针置为 null
        nHead.next.prev = null;
        return nHead.next;
    }
}


class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
