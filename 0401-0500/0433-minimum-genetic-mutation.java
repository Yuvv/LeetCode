import java.util.*;

/*
 * 0433-minimum-genetic-mutation.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/05
 */
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(bank.length);
        for (String b : bank) {
            bankSet.add(b);
        }
        if (!bankSet.contains(end)) {
            return -1;
        }
        LinkedList<String> list = new LinkedList<>();
        list.add(start);

        int mutTimes = 0;
        while (!list.isEmpty()) {
            int size = list.size();
            while (size > 0) {
                String ss = list.poll();
                if (ss.equals(end)) {
                    return mutTimes;
                }
                Iterator<String> it = bankSet.iterator();
                while (it.hasNext()) {
                    String other = it.next();
                    if (dis(ss, other) == 1) {
                        list.add(other);
                        it.remove();
                    }
                }
                size--;
            }
            mutTimes++;
        }

        return -1;
    }

    private int dis(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        }
        int dis = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                dis++;
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minMutation(
            "AAAAACCC", "AACCCCCC",
            new String[] {"AAAACCCC","AAACCCCC","AACCCCCC"}
        ));
        // 8
        System.out.println(s.minMutation(
            "AAAAAAAA", "CCCCCCCC",
            new String[] {"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA","CCCCCCCC"}
        ));
    }
}
