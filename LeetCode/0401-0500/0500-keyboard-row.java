class Solution {

    static final String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static final Map<Character, Integer> aplhabetRowMap = new HashMap<>();
    static {
        aplhabetRowMap.put('q', 0);
        aplhabetRowMap.put('w', 0);
        aplhabetRowMap.put('e', 0);
        aplhabetRowMap.put('r', 0);
        aplhabetRowMap.put('t', 0);
        aplhabetRowMap.put('y', 0);
        aplhabetRowMap.put('u', 0);
        aplhabetRowMap.put('i', 0);
        aplhabetRowMap.put('o', 0);
        aplhabetRowMap.put('p', 0);

        aplhabetRowMap.put('a', 1);
        aplhabetRowMap.put('s', 1);
        aplhabetRowMap.put('d', 1);
        aplhabetRowMap.put('f', 1);
        aplhabetRowMap.put('g', 1);
        aplhabetRowMap.put('h', 1);
        aplhabetRowMap.put('j', 1);
        aplhabetRowMap.put('k', 1);
        aplhabetRowMap.put('l', 1);

        aplhabetRowMap.put('z', 2);
        aplhabetRowMap.put('x', 2);
        aplhabetRowMap.put('c', 2);
        aplhabetRowMap.put('v', 2);
        aplhabetRowMap.put('b', 2);
        aplhabetRowMap.put('n', 2);
        aplhabetRowMap.put('m', 2);
    }

    /**
     * 找出单词是否仅使用键盘的某一行就可以敲出来
     * https://leetcode.com/problems/keyboard-row/description/
     */
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        int rowIndex;
        boolean flag;
        char chr;
        for (String s: words) {
            if (s.isEmpty()) {
                continue;
            }
            chr = s.charAt(0);
            if (chr < 'a') {
                chr += 32;
            }
            if (!aplhabetRowMap.containsKey(chr)) {
                continue;
            }
            rowIndex = aplhabetRowMap.get(chr);
            flag = true;
            for (int i = 1; i < s.length(); i++) {
                chr = s.charAt(i);
                if (chr < 'a') {
                    chr += 32;
                }
                if (rows[rowIndex].indexOf(chr) < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(s);
            }
        }

        String[] result = new String[list.size()];
        return list.toArray(result);
    }
}