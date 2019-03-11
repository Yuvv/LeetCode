// 额(⊙﹏⊙)  leetcode 没有自己引 Optional
import java.util.Optional;

class Solution {
    /**
     * 找出字符串中相同字符
     * https://leetcode.com/problems/find-common-characters/submissions/
     *
     * @param A 字符串数组
     * @return 相同的字符数组
     */
    public List<String> commonChars(String[] A) {
        List<Map<Character, Integer>> counterList = new ArrayList<>(A.length);
        for (String a : A) {
            Map<Character, Integer> map = new HashMap<>(a.length());
            for (char c : a.toCharArray()) {
                map.putIfAbsent(c, 0);
                map.put(c, map.get(c) + 1);
            }
            counterList.add(map);
        }

        Optional<Map<Character, Integer>> result = counterList.stream().reduce((map1, map2) -> {
            Iterator<Map.Entry<Character, Integer>> entryIterator = map1.entrySet().iterator();
            while (entryIterator.hasNext()) {
                Map.Entry<Character, Integer> entry = entryIterator.next();
                if (map2.containsKey(entry.getKey())) {
                    entry.setValue(Math.min(map2.get(entry.getKey()), entry.getValue()));
                    map2.remove(entry.getKey());
                } else {
                    entryIterator.remove();
                }
            }
            return map1;
        });

        List<String> list = new ArrayList<>();
        result.ifPresent(map -> map.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                list.add(key.toString());
            }
        }));
        return list;
    }
}