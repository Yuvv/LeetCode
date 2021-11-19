import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
/*
 * 1436-destination-city.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/19
 */
public class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pt : paths) {
            map.put(pt.get(0), pt.get(1));
        }
        String key = paths.get(0).get(0);
        while (map.containsKey(key)) {
            key = map.get(key);
        }
        return key;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // "Sao Paulo"
        System.out.println(s.destCity(Arrays.asList(
            Arrays.asList("London", "New York"),
            Arrays.asList("New York", "Lima"),
            Arrays.asList("Lima", "Sao Paulo")
        )));
        // "A"
        System.out.println(s.destCity(Arrays.asList(
            Arrays.asList("B", "C"),
            Arrays.asList("D", "B"),
            Arrays.asList("C", "A")
        )));
        // "Z"
        System.out.println(s.destCity(Arrays.asList(
            Arrays.asList("A", "Z")
        )));
    }
}