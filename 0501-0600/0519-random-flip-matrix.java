import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 0519-random-flip-matrix.java
 *
 * @date 2024/1/16
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    private List<int[]> list;
    private Random random;
    private int m;
    private int n;

    public Solution(int m, int n) {
        this.random = new Random(System.currentTimeMillis());
        this.m = m;
        this.n = n;
        this.list = new ArrayList<>();
        this.list.add(new int[] { 0, m * n - 1 });
    }

    public int[] flip() {
        if (this.list.isEmpty()) {
            return new int[] {};
        }
        int idx = random.nextInt(list.size());
        int[] range = list.get(idx);
        if (range[0] == range[1]) {
            list.remove(idx);
            return new int[] { range[0] / n, range[0] % n };
        } else {
            int val = random.nextInt(range[0], range[1] + 1);
            if (val == range[0]) {
                range[0] = val + 1;
            } else if (val == range[1]) {
                range[1] = val - 1;
            } else {
                list.add(new int[] { val + 1, range[1] });
                range[1] = val - 1;
            }
            return new int[] { val / n, val % n };
        }
    }

    public void reset() {
        this.list.clear();
        this.list.add(new int[] { 0, m * n - 1 });
    }

    public static void main(String[] args) {
        Solution s = new Solution(3, 1);
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
        s.reset();
        System.out.println(Arrays.toString(s.flip()));
    }
}
