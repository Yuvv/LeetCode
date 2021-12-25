import java.util.*;;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
 * 1019-next-greater-node-in-linked-list.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/25
 */
public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> resList = new ArrayList<>();
        TreeMap<Integer, List<Integer>> valIdxMap = new TreeMap<>();
        int idxCount = 0;
        while (head != null) {
            Iterator<Map.Entry<Integer, List<Integer>>> it = valIdxMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, List<Integer>> entry = it.next();
                if (entry.getKey() >= head.val) {
                    break;
                }
                for (Integer idx : entry.getValue()) {
                    resList.set(idx, head.val);
                }
                it.remove();
            }
            // default '0'
            resList.add(0);
            valIdxMap.computeIfAbsent(head.val, k -> new ArrayList<>()).add(idxCount);
            idxCount++;
            head = head.next;
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [5,5,0]
        System.out.println(Arrays.toString(
            s.nextLargerNodes(new ListNode(2, new ListNode(1, new ListNode(5))))
        ));
        // [7,0,5,5,0]
        System.out.println(Arrays.toString(
            s.nextLargerNodes(new ListNode(2, new ListNode(7, new ListNode(4, new ListNode(3, new ListNode(5))))))
        ));
    }

}