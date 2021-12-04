import java.util.*;


/*
 * 1472-design-browser-history.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/04
 */
public class BrowserHistory {

    private ListNode<String> historyCursor;

    public BrowserHistory(String homepage) {
        this.historyCursor = new ListNode<>(homepage);
    }

    public void visit(String url) {
        historyCursor.next = new ListNode<>(url);
        historyCursor.next.prev = historyCursor;
        historyCursor = historyCursor.next;
    }

    public String back(int steps) {
        while (historyCursor.prev != null && steps > 0) {
            historyCursor = historyCursor.prev;
            steps--;
        }
        return historyCursor.val;
    }

    public String forward(int steps) {
        while (historyCursor.next != null && steps > 0) {
            historyCursor = historyCursor.next;
            steps--;
        }
        return historyCursor.val;
    }

}

class ListNode<T> {
    T val;
    ListNode prev;
    ListNode next;

    public ListNode(T val) {
        this(val, null, null);
    }

    public ListNode(T val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}