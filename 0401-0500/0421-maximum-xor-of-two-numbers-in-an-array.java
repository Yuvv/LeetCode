/*
 * 0421-maximum-xor-of-two-numbers-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/02
 */
public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        TrieNode root = new TrieNode();
        for (int num : nums) {
            root.add(num);
        }
        for (int num : nums) {
            max = Math.max(max, root.findMax(num));
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 28
        System.out.println(s.findMaximumXOR(new int[] {3,10,5,25,2,8}));
        // 127
        System.out.println(s.findMaximumXOR(new int[] {14,70,53,83,49,91,36,80,92,51,66,70}));
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
            } else {
                node = node.bits[idx];
            }
            i--;
        }
        return max;
    }
}