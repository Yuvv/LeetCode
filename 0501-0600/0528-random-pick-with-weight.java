import java.util.*;

/*
 * 0528-random-pick-with-weight.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/07
 */
public class Solution {
    private TreeMap<Integer, Integer> treeMap;
    private Random random;
    private int wSum;

    public Solution(int[] w) {
        random = new Random(System.currentTimeMillis());
        treeMap = new TreeMap<>();

        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            treeMap.put(sum, i);
        }
        wSum = sum;
    }

    public int pickIndex() {
        int val = random.nextInt(wSum);
        Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(val + 1);
        return entry.getValue();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[] {1, 3});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }
}
