import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * 2895-minimum-processing-time
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/29
 */
class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        processorTime.sort(Comparator.naturalOrder());
        tasks.sort(Comparator.reverseOrder());
        int max = 0;
        for (int i = 0; i < processorTime.size(); i++) {
            max = Math.max(max, processorTime.get(i) + tasks.get(i * 4));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 16
        System.out.println(s.minProcessingTime(
                new ArrayList<>(Arrays.asList(8, 10)),
                new ArrayList<>(Arrays.asList(2, 2, 3, 1, 8, 7, 4, 5))));
    }
}
