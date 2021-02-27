import java.util.*;

public class Solution {
    public void swapEntry(List<Map.Entry<Integer, Integer>> entryList, int i, int j) {
        if (i == j) {
            return;
        }
        Map.Entry<Integer, Integer> tmp = entryList.get(j);
        entryList.set(j, entryList.get(i));
        entryList.set(i, tmp);
    }

    public void partialQuickSort(List<Map.Entry<Integer, Integer>> entryList, int begin, int end, int k) {
        Map.Entry<Integer, Integer> entry = entryList.get(end);
        boolean sameRangeEqualsEntry = false;
        while (begin < end) {
            // deal with duplicated element
            if (entryList.get(begin).getValue().equals(entry.getValue()) && entryList.get(end).getValue().equals(entry.getValue())) {
                int i;
                for (i = begin + 1; i < end; i++) {
                    if (entryList.get(i).getValue() > entry.getValue()) {
                        break;
                    }
                }
                if (i == end) {
                    for (i = end - 1; i > begin; i--) {
                        if (entryList.get(i).getValue() < entry.getValue()) {
                            break;
                        }
                    }
                    if (i == begin) {
                        begin = end;
                        sameRangeEqualsEntry = true;
                    } else {
                        swapEntry(entryList, i, end);
                    }
                } else {
                    swapEntry(entryList, begin, i);
                }
            }

            while (begin < end && entryList.get(begin).getValue() > entry.getValue()) {
                begin++;
            }
            while (begin < end && entryList.get(end).getValue() < entry.getValue()) {
                end--;
            }
            // swap
            swapEntry(entryList, begin, end);

        }
        if (!sameRangeEqualsEntry) {
            // `sameRangeEqualsEntry` means all elements in [begin, end] equals entry, there is no need to set
            entryList.set(end, entry);
        }
        if (begin > k - 1) {
            partialQuickSort(entryList, 0, begin - 1, k);
        }
        if (begin < k - 1) {
            partialQuickSort(entryList, end + 1, entryList.size() - 1, k);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
        if (k < entryList.size()) {
            // partial quick sort
            partialQuickSort(entryList, 0, entryList.size() - 1, k);
        }
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // [1, 2] expected
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        // [1] expected
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1, 1, 1}, 1)));
    }
}