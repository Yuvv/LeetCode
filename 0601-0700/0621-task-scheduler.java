import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 0621-task-scheduler.java
 *
 * @author Yuvv<yuvv_th@outlook.com>
 * @date 2024/3/19
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> chMap = new HashMap<>();
        for (char ch : tasks) {
            chMap.put(ch, chMap.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            int v = b.val - a.val; // COUNT desc
            if (v == 0) {
                v = a.ch - b.ch; // CHAR asc
            }
            return v;
        });
        for (Map.Entry<Character, Integer> entry : chMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        //
        int consumeCnt = 0;
        int cnt = 0;
        LinkedList<Node> queue = new LinkedList<>();
        while (!pq.isEmpty() || !queue.isEmpty()) {
            if (pq.isEmpty()) {
                // add IDLE node
                queue.addLast(new Node('0', 0));
            } else {
                queue.addLast(pq.poll());
                consumeCnt++;
            }
            cnt++;
            if (consumeCnt >= tasks.length) {
                break;
            }
            if (queue.size() > n) {
                Node node = queue.pollFirst();
                node.val--;
                if (node.val > 0) {
                    pq.add(node);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        // 6
        System.out.println(s.leastInterval(new char[] {'A', 'C', 'A', 'B', 'D', 'B'}, 1));
        // 10
        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 3));
    }
}

class Node {
    char ch;
    int  val;

    public Node(char ch, int val) {
        this.ch = ch;
        this.val = val;
    }
}
