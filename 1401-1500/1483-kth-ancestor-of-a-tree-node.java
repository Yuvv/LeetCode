import java.util.*;

/*
 * 1483-kth-ancestor-of-a-tree-node.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/07
 */
class TreeAncestor {
    // dp[node][i] = node's 2^i(th) parent
    // dp[node][i] = dp[dp[node][i-1]][i-1]
    private final int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        // save all children
        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        for (int i = 0; i < parent.length; i++) {
            map.computeIfAbsent(parent[i], k -> new HashSet<>()).add(i);
        }
        // init root node
        dp = new int[n][];
        dp[0] = new int[0];
        // parent[0] == -1
        LinkedList<Set<Integer>> parentQueue = new LinkedList<>();
        parentQueue.add(Collections.singleton(0));
        int level = 0;
        while (!parentQueue.isEmpty()) {
            Set<Integer> pNodes = parentQueue.poll();
            level++;
            int size = getSize(level);

            Set<Integer> levelChildren = new HashSet<>();
            for (Integer pNode : pNodes) {

                Set<Integer> children = map.get(pNode);
                if (children != null && !children.isEmpty()) {
                    levelChildren.addAll(children);
                    for (Integer child : children) {
                        dp[child] = new int[size];
                        dp[child][0] = pNode;
                        for (int i = 1; i < size; i++) {
                            dp[child][i] = dp[dp[child][i - 1]][i - 1];
                        }
                    }
                }
            }
            if (!levelChildren.isEmpty()) {
                parentQueue.add(levelChildren);
            }
        }
    }

    private int getSize(int level) {
        int size = 0;
        while (level > 0) {
            size++;
            level >>= 1;
        }
        return size;
    }

    public int getKthAncestor(int node, int k) {
        int count = 0;
        while (k > 0) {
            if (node == -1 || count >= dp[node].length) {
                return -1;
            }
            if (k % 2 == 1) {
                node = dp[node][count];
            }
            k >>= 1;
            count++;
        }
        return node;
    }
}

public class Solution {
    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[] {-1, 0, 0, 1, 1, 2, 2});
        // returns 1 which is the parent of 3
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        // returns 0 which is the grandparent of 5
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        // returns -1 because there is no such ancestor
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }
}

// TLE
class TreeAncestor_TimeLimit {

    private Map<Integer, Integer> map;

    public TreeAncestor_TimeLimit(int n, int[] parent) {
        map = new HashMap<>(n);
        for (int i = 0; i < parent.length; i++) {
            map.put(i, parent[i]);
        }
    }

    public int getKthAncestor(int node, int k) {
        if (k >= map.size()) {
            return -1;
        }
        while (k > 0 && node >= 0) {
            node = map.getOrDefault(node, -1);
            k--;
        }
        return node;
    }
}

// MLE
class TreeAncestor_MemLimit {
    private int[][] dp;

    public TreeAncestor_MemLimit(int n, int[] parent) {
        // save all chindren
        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        for (int i = 0; i < parent.length; i++) {
            map.computeIfAbsent(parent[i], k -> new HashSet<>()).add(i);
        }

        dp = new int[n][];
        dp[0] = new int[] {-1};
        // parent[0] == -1
        LinkedList<Integer> parentQueue = new LinkedList<>();
        parentQueue.add(0);
        while (!parentQueue.isEmpty()) {
            Integer pNode = parentQueue.poll();
            int[] pArr = dp[pNode];
            Set<Integer> children = map.get(pNode);
            if (children != null && !children.isEmpty()) {
                for (Integer child : children) {
                    dp[child] = new int[pArr.length + 1];
                    dp[child][0] = pNode;
                    System.arraycopy(pArr, 0, dp[child], 1, pArr.length);
                }
                parentQueue.addAll(children);
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        if (k > dp[node].length) {
            return -1;
        }
        return dp[node][k - 1];
    }
}