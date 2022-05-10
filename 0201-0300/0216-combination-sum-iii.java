import java.util.*;

/*
 * 0216-combination-sum-iii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/10
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 1-9 每个数字最多用一次，最大值只只能是 15
        if (n > 45) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> resList = new ArrayList<>();
        // 在queue中记录一个 list ，然后在这些 list 中逐个添加元素去判断即可
        LinkedList<List<Integer>> queue = new LinkedList<>();
        int toProcessCount = 0;
        for (int i = 1; i <= 9; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(i);
            queue.add(list);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            if (list.size() == k + 1) {
                if (list.get(list.size() - 1) == n) {
                    list.remove(list.size() - 1);
                    resList.add(list);
                }
            } else {
                if (list.get(list.size() - 1) < n) {
                    int val = list.remove(list.size() - 1);
                    for (int i = list.get(list.size() - 1) + 1; i <= 9; i++) {
                        List<Integer> newList = new ArrayList<>(list);
                        newList.add(i);
                        newList.add(val + i);
                        queue.add(newList);
                    }
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,2,4]]
        System.out.println(s.combinationSum3(3, 7));
        // [[1,2,6],[1,3,5],[2,3,4]]
        System.out.println(s.combinationSum3(3, 9));
        // []
        System.out.println(s.combinationSum3(4, 1));
    }
}