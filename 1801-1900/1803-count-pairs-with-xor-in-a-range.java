/*
 * 1803-count-pairs-with-xor-in-a-range.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/28
 */
public class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Trie root = new Trie();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += root.getPairs(nums[i], high);
            cnt -= root.getPairs(nums[i], low - 1);
            root.insert(nums[i]);
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.countPairs(new int[] {1,4,2,7}, 2, 6));
        // 8
        System.out.println(s.countPairs(new int[] {9,8,4,2,1}, 5, 14));
    }
}

class Trie {
    static final int DEPTH = 14;

    int count;
    Trie[] next;

    public Trie() {
        count = 0;
        next = new Trie[2];
    }

    public void insert(int val) {
        Trie node = this;
        for (int i = DEPTH; i >= 0; i--) {
            int bitVal = (val >> i) & 1;
            if (node.next[bitVal] == null) {
                node.next[bitVal] = new Trie();
            }
            node = node.next[bitVal];
            node.count++;
        }
    }

    public int getPairs(int num, int k) {
        Trie node = this;
        int count = 0;
        for (int i = DEPTH; node != null && i >= 0; i--) {
            int bitNum = (num >> i) & 1;
            int bitK = (k >> i) & 1;
            if (bitNum > 0) {
                if (bitK > 0) {
                    if (node.next[1] != null) {
                        count += node.next[1].count;
                    }
                }
                node = node.next[1 - bitK];
            } else {
                if (bitK > 0) {
                    if (node.next[0] != null) {
                        count += node.next[0].count;
                    }
                }
                node = node.next[bitK];
            }
        }
        if (node != null) {
            count += node.count;
        }
        return count;
    }
}