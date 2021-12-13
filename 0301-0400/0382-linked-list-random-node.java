import java.util.Random;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
 * 0382-linked-list-random-node.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/13
 */
public class Solution {

    private ListNode head;
    private ListNode cursor;
    private int len;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        ListNode cur = head;
        this.len = 0;
        while (cur != null) {
            this.len++;
            cur = cur.next;
        }
        this.cursor = head;
        this.random = new Random();
    }

    public int getRandom() {
        int rnd = random.nextInt(len);
        while (rnd > 0) {
            this.cursor = this.cursor.next;
            if (this.cursor == null) {
                this.cursor = this.head;
            }
            rnd--;
        }
        return this.cursor.val;
    }

    public static void main(String[] args) {
        Solution s = new Solution(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        // ~~~
        System.out.println(s.getRandom());
        // ~~~
        System.out.println(s.getRandom());
        // ~~~
        System.out.println(s.getRandom());
        // ~~~
        System.out.println(s.getRandom());
    }
}