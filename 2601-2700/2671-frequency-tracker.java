import java.util.*;

/**
 * 2671-frequency-tracker
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/02
 */
public class FrequencyTracker {
    private Map<Integer, Integer> cntMap;
    private Map<Integer, Set<Integer>> freqMap;

    public FrequencyTracker() {
        this.cntMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public void add(int number) {
        if (cntMap.containsKey(number)) {
            Integer freq = cntMap.get(number);
            cntMap.put(number, freq + 1);
            freqMap.get(freq).remove(number);
            freqMap.computeIfAbsent(freq + 1, k -> new HashSet<>()).add(number);
        } else {
            cntMap.put(number, 1);
            freqMap.computeIfAbsent(1, k -> new HashSet<>()).add(number);
        }
    }

    public void deleteOne(int number) {
        if (cntMap.containsKey(number)) {
            Integer freq = cntMap.get(number);
            if (freq == 1) {
                cntMap.remove(number);
            } else {
                cntMap.put(number, freq - 1);
            }
            freqMap.get(freq).remove(number);
            freqMap.computeIfAbsent(freq - 1, k -> new HashSet<>()).add(number);
        }
    }

    public boolean hasFrequency(int frequency) {
        Set<Integer> v = freqMap.get(frequency);
        return v != null && v.size() > 0;
    }

    public static void main(String[] args) {
        FrequencyTracker ft = new FrequencyTracker();
        ft.add(1);
        ft.deleteOne(1);
        System.out.println(ft.hasFrequency(1)); // false
    }
}
