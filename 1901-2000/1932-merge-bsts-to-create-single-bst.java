import java.util.*;

/*
 * 1932-merge-bsts-to-create-single-bst.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/12
 */
public class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<TreeNode, TreeSet<Integer>> leaves = new HashMap<>(trees.size());
        Map<Integer, TreeNode> leafRootMap = new HashMap<>(trees.size());
        for (TreeNode node : trees) {
            TreeSet<Integer> set = findLeaf(node);
            leaves.put(node, set);
            for (Integer nv : set) {
                if (leafRootMap.containsKey(nv)) {
                    // same leaf is illegal, unless node is leaf
                    if (node.left == null && node.right == null) {
                        continue;
                    } else {
                        TreeNode prevNode = leafRootMap.get(nv);
                        if (prevNode.left != null || prevNode.right != null) {
                            return null;
                        }
                    }
                }
                leafRootMap.put(nv, node);
            }
        }

        LinkedList<TreeNode> queue = new LinkedList<>(trees);
        boolean rootFounded = false;
        while (queue.size() > 1) {
            TreeNode node = queue.pollFirst();
            boolean found = false;
            if (leafRootMap.containsKey(node.val)) {
                TreeNode cand = leafRootMap.get(node.val);
                Set<Integer> leafVals = leaves.get(cand);
                if (leafVals.contains(node.val)) {
                    TreeSet<Integer> otherLeafVals = leaves.get(node);
                    if (merge(cand, node, otherLeafVals)) {
                        leafVals.remove(node.val);
                        leafVals.addAll(otherLeafVals);
                        leaves.remove(node);
                        leafRootMap.remove(node.val);
                        for (Integer nv : otherLeafVals) {
                            leafRootMap.put(nv, cand);
                        }
                        found = true;
                    }
                }
            }
            if (!found) {
                if (rootFounded) {
                    return null;
                }
                queue.addLast(node);
                rootFounded = true;
            }
        }

        return queue.poll();
    }

    private boolean merge(TreeNode root, TreeNode another, TreeSet<Integer> anotherLeaveVals) {
        Integer first = anotherLeaveVals.first();
        Integer last = anotherLeaveVals.last();
        while (root != null) {
            if (root.val > another.val) {
                // move left
                if (last >= root.val) {
                    return false;
                }
                root = root.left;
            } else if (root.val < another.val) {
                // move right;
                if (first <= root.val) {
                    return false;
                }
                root = root.right;
            } else {
                break;
            }
        }
        if (root == null || root.left != null || root.right != null) {
            System.out.println("panic");
            return false;
        }
        root.left = another.left;
        root.right = another.right;
        return true;
    }

    private TreeSet<Integer> findLeaf(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node.left == null && node.right == null) {
                set.add(node.val);
                continue;
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        return set;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // []
        System.out.println(s.canMerge(Arrays.asList(
            new TreeNode(1, null, new TreeNode(2)),
            new TreeNode(3, new TreeNode(1), null),
            new TreeNode(2, null, new TreeNode(3))
        )));
        // [3,2,5,1,null,4]
        System.out.println(s.canMerge(Arrays.asList(
            new TreeNode(2, new TreeNode(1), null),
            new TreeNode(3, new TreeNode(2), new TreeNode(5)),
            new TreeNode(5, new TreeNode(4), null)
        )));
        // []
        System.out.println(s.canMerge(Arrays.asList(
            new TreeNode(5, new TreeNode(3), new TreeNode(8)),
            new TreeNode(3, new TreeNode(2), new TreeNode(6))
        )));
        // []
        System.out.println(s.canMerge(Arrays.asList(
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(3, new TreeNode(2), null)
        )));
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "[" + val + ", " + left + ", " + right + "]";
    }
}


/**
[[2,1,3],[1],[3]]
[[1,null,2],[3,1],[2,null,3]]
[[2,1,3],[3,2]]
[[2,1],[3,2,5],[5,4]]
[[2,1],[3,2,5],[5,4]]
[[5,3,8],[3,2,6]]
[[5,4],[3]]
[[2,1],[3,2,5],[5,4],[6,5]]
[[2,1],[3,2,5],[5,4],[6,null,7]]
*/

