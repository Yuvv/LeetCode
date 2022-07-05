
/*
 * 0427-construct-quad-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/05
 */
public class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    public Node construct(int[][] grid, int fi, int fj, int n) {
        if (n == 1) {
            boolean val = true;
            if (grid[fi][fj] == 0) {
                val = false;
            }
            return new Node(val, true);
        }
        n /= 2;
        Node topLeft = construct(grid, fi, fj, n);
        Node topRight = construct(grid, fi, fj + n, n);
        Node bottomLeft = construct(grid, fi + n, fj, n);
        Node bottomRight = construct(grid, fi + n, fj + n, n);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if (topLeft.val == topRight.val
                    && topRight.val == bottomLeft.val
                    && bottomLeft.val == bottomRight.val) {
                // just return any one
                return topLeft;
            }
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
/**
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/