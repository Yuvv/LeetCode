import java.util.*;
/*
 * 1361-validate-binary-tree-nodes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/20
 */
public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] >= 0) {
                if (parent[leftChild[i]] >= 0 && parent[leftChild[i]] != i) {
                    return false;
                }
                parent[leftChild[i]] = i;
            }
            if (rightChild[i] >= 0) {
                if (parent[rightChild[i]] >= 0 && parent[rightChild[i]] != i) {
                    return false;
                }
                parent[rightChild[i]] = i;
            }
        }

        int[] dsu = new int[n];
        Arrays.fill(dsu, -1);
        for (int i = 0; i < n; i++) {
            Set<Integer> pathSet = new HashSet<>();
            int j = i;
            while (parent[j] >= 0 && dsu[j] < 0) {
                if (pathSet.contains(j)) {
                    // has ring
                    return false;
                }
                pathSet.add(j);
                j = parent[j];
            }
            if (parent[j] < 0) {
                pathSet.add(j);
            }
            int root = j;
            if (dsu[j] >= 0) {
                root = dsu[j];
            }
            for (int x : pathSet) {
                dsu[x] = root;
            }
        }

        Set<Integer> rootSet = new HashSet<>();
        for (int root : dsu) {
            rootSet.add(root);
        }

        return rootSet.size() == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.validateBinaryTreeNodes(
            4,
            new int[] {1,-1,3,-1},
            new int[] {2,-1,-1,-1}
        ));
        // false
        System.out.println(s.validateBinaryTreeNodes(
            6,
            new int[] {1,-1,-1,4,-1,-1},
            new int[] {2,-1,-1,5,-1,-1}
        ));
    }
}