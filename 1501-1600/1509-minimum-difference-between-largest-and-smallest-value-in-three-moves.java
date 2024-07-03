/**
 * 1509-minimum-difference-between-largest-and-smallest-value-in-three-moves.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/03
 */
public class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        // min4 = [a, b, c, d]
        // max4 = [e, f, g, h]
        // then, the result is MIN(h-d, g-c, f-b, e-a)
        int[] min4 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] max4 = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int n : nums) {
            putInMinArr(min4, n);
            putInMaxArr(max4, n);
        }
        int min = max4[0] - min4[0];
        min = Math.min(min, max4[1] - min4[1]);
        min = Math.min(min, max4[2] - min4[2]);
        min = Math.min(min, max4[3] - min4[3]);
        return min;
    }

    private void putInMinArr(int[] arr, int value) {
        if (value >= arr[3]) {
            return;
        }
        if (value < arr[0]) {
            arr[3] = arr[2];
            arr[2] = arr[1];
            arr[1] = arr[0];
            arr[0] = value;
        } else if (value < arr[1]) {
            arr[3] = arr[2];
            arr[2] = arr[1];
            arr[1] = value;
        } else if (value < arr[2]) {
            arr[3] = arr[2];
            arr[2] = value;
        } else if (value < arr[3]) {
            arr[3] = value;
        }
    }


    private void putInMaxArr(int[] arr, int value) {
        if (value <= arr[0]) {
            return;
        }
        if (value > arr[3]) {
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = arr[3];
            arr[3] = value;
        } else if (value > arr[2]) {
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = value;
        } else if (value > arr[1]) {
            arr[0] = arr[1];
            arr[1] = value;
        } else if (value > arr[0]) {
            arr[0] = value;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.minDifference(new int[] {5,3,2,4}));
        // 1
        System.out.println(s.minDifference(new int[] {1,5,0,10,14}));
        // 0
        System.out.println(s.minDifference(new int[] {3,100,20}));
    }
}
