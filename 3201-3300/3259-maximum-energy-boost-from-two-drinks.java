/**
 * 3259-maximum-energy-boost-from-two-drinks.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/04
 */
public class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        long[] dpa = new long[energyDrinkA.length];
        long[] dpb = new long[energyDrinkB.length];

        dfs(dpa, energyDrinkA, dpb, energyDrinkB, 0);
        dfs(dpb, energyDrinkB, dpa, energyDrinkA, 0);

        return Math.max(dpa[0], dpb[0]);
    }

    private long dfs(long[] dpa, int[] energyDrinkA, long[] dpb, int[] energyDrinkB, int i) {
        if (i >= dpa.length) {
            return 0;
        }
        if (dpa[i] > 0) {
            return dpa[i];
        }
        dpa[i] = energyDrinkA[i] + Math.max(
            dfs(dpa, energyDrinkA, dpb, energyDrinkB, i+1),
            dfs(dpb, energyDrinkB, dpa, energyDrinkA, i+2));
        return dpa[i];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.maxEnergyBoost(new int[] {4, 1, 1}, new int[] {1,1,3}));
        // 5
        System.out.println(s.maxEnergyBoost(new int[] {1,3,1}, new int[] {3,1,1}));
    }
}
