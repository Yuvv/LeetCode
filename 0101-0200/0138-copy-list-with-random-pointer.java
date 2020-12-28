
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/*
 * 0138-copy-list-with-random-pointer.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/12/28
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Integer> map = new HashMap<>();
        Map<Integer, Node> randomMap = new HashMap<>();
        int index = 0;
        Node cur = head;
        while (cur != null) {
            map.put(cur, index);
            randomMap.put(index, cur.random);
            index++;
            cur = cur.next;
        }

        //
        Node nHead = new Node(head.val);
        Node nCur = nHead;
        Map<Integer, Node> nMap = new HashMap<>();
        index = 0;
        nMap.put(index, nHead);
        cur = head.next;
        while (cur != null) {
            index++;
            nCur.next = new Node(cur.val);
            nMap.put(index, nCur.next);
            nCur = nCur.next;
            cur = cur.next;
        }

        //
        nCur = nHead;
        index = 0;
        while (nCur != null) {
            Node randomNode = randomMap.get(index);
            if (randomNode != null) {
                Integer randomIndex = map.get(randomNode);
                nCur.random = nMap.get(randomIndex);
            }
            index++;
            nCur = nCur.next;
        }
        return nHead;
    }

    public static void main(String[] args) {
        //
    }
}