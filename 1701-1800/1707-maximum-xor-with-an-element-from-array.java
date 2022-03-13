import java.util.Arrays;

/*
 * 1707-maximum-xor-with-an-element-from-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/02
 */
public class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        TrieNode root = new TrieNode();

        int[][] qis = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            qis[i] = new int[] {queries[i][0], queries[i][1], i};
        }

        Arrays.sort(nums);
        Arrays.sort(qis, (a, b) -> Integer.compare(a[1], b[1]));

        int[] res = new int[queries.length];

        int j = 0;
        for (int i = 0; i < qis.length; i++) {
            int[] query = qis[i];
            while (j < nums.length && nums[j] <= query[1]) {
                root.add(nums[j]);
                j++;
            }
            res[query[2]] = root.findMax(query[0]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,3,7]
        System.out.println(Arrays.toString(s.maximizeXor(new int[] {0,1,2,3,4}, new int[][] {{3,1},{1,3},{5,6}})));
        // [15,-1,5]
        System.out.println(Arrays.toString(s.maximizeXor(new int[] {5,2,4,6,6,3}, new int[][] {{12,4},{8,1},{6,3}})));
        // [1050219420,844498962,540190212,539622516,330170208]
        System.out.println(Arrays.toString(s.maximizeXor(
            new int[] {536870912,0,534710168,330218644,142254206},
            new int[][] {
                {558240772,1000000000},
                {307628050,1000000000},
                {3319300,1000000000},
                {2751604,683297522},
                {214004,404207941}
            }
        )));
    }
}

// 31-level bit trie
class TrieNode {
    // 0, 1
    TrieNode[] bits;

    public TrieNode() {
        this.bits = new TrieNode[2];
    }

    // can be cached
    private boolean[] buildBitArr(int num) {
        boolean[] bitarr = new boolean[31];
        int i = 0;
        while (num > 0) {
            bitarr[i++] = (num & 1) > 0;
            num >>= 1;
        }
        return bitarr;
    }

    public void add(int num) {
        boolean[] bitarr = buildBitArr(num);

        // add
        int i = bitarr.length - 1;
        TrieNode node = this;
        while (i >= 0) {
            int idx = bitarr[i] ? 1 : 0;
            if (node.bits[idx] == null) {
                node.bits[idx] = new TrieNode();
            }
            node = node.bits[idx];
            i--;
        }
    }

    public int findMax(int num) {
        boolean[] bitarr = buildBitArr(num);
        int max = 0;
        // search
        int i = bitarr.length - 1;
        TrieNode node = this;
        while (i >= 0) {
            // there is no problem for the firs iteration
            max <<= 1;
            int idx = bitarr[i] ? 1 : 0;
            if (node.bits[1 - idx] != null) {
                max |= 1;
                node = node.bits[1 - idx];
            } else if (node.bits[idx] == null) {
                return -1;
            } else {
                node = node.bits[idx];
            }
            i--;
        }
        return max;
    }
}