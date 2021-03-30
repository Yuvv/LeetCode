import java.util.*;

/*
 * 0710-random-pick-with-blacklist.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/03/30
 */
public class Solution {

    private List<List<Integer>> whiteRanges;

    public Solution(int N, int[] blacklist) {
        whiteRanges = new ArrayList<>();
        Arrays.sort(blacklist);
        int begin = 0;
        int i = 0;
        for (i = 0; i < blacklist.length; i++) {
            if (blacklist[i] > begin) {
                whiteRanges.add(Arrays.asList(begin, blacklist[i]));
            }
            begin = blacklist[i] + 1;
        }
        if (begin < N) {
            whiteRanges.add(Arrays.asList(begin, N));
        }
    }

    public int pick() {
        int candidate = (int) (System.nanoTime() % whiteRanges.size());
        List<Integer> range = whiteRanges.get(candidate);

        return range.get(0) + (int) (System.nanoTime() % (range.get(1) - range.get(0)));
    }

    public static void main(String[] args) {
        Solution s = new Solution(100, new int[]{1, 5, 9, 33});

        for (int i = 0; i < 100; i++) {
            System.out.println(s.pick());
        }

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */