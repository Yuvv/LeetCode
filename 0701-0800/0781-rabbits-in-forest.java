
public class Solution {
    public int numRabbits(int[] answers) {
        int[] cntArr = new int[1001];
        for (int ans : answers) {
            cntArr[ans]++;
        }

        int res = 0;
        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] == 0) {
                continue;
            }
            res += (cntArr[i] + i) / (i+1) * (i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 11
        System.out.println(s.numRabbits(new int[]{10,10,10}));
        // 5
        System.out.println(s.numRabbits(new int[]{1,1,2}));
    }
}
