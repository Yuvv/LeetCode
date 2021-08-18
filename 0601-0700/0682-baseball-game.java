import java.util.List;
import java.util.ArrayList;

/*
 * 0682-baseball-game.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/18
 */
public class Solution {
    public int calPoints(String[] ops) {
        List<Integer> resultList = new ArrayList<>(ops.length);
        for (String op : ops) {
            int size = resultList.size();
            if ("C".equals(op)) {
                resultList.remove(size - 1);
            } else if ("D".equals(op)) {
                resultList.add(resultList.get(size - 1) * 2);
            } else if ("+".equals(op)) {
                resultList.add(resultList.get(size - 1) + resultList.get(size - 2));
            } else {
                resultList.add(Integer.parseInt(op));
            }
        }
        return resultList.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 30
        System.out.println(s.calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}