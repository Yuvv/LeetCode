import java.util.Random;
/*
 * 0384-shuffle-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/07/20
 */
public class Solution {

    private int[] arr;
    private int[] origin;

    private Random random = new Random();

    public Solution(int[] nums) {
        arr = nums;
        origin = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        arr = origin;
        origin = arr.clone();
        return arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < arr.length; i++) {
            randomAndSwap(arr, i);
        }
        return arr;
    }

    private void randomAndSwap(int[] arr, int i) {
        int j = random.nextInt(arr.length);
        if (j == i) {
            return;
        }
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */