class Solution {
    /**
     * 生成括号
     * https://leetcode.com/problems/generate-parentheses/
     *
     * @param n n对括号
     * @return 生成结果
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        addParentheses(list, "", 2 * n, n, n);
        return list;
    }

    private void addParentheses(List<String> list, String cur, int length, int left, int right) {
        if (cur.length() == length) {
            list.add(cur);
            return;
        }
        if (right > left) {
            if (left > 0) {
                addParentheses(list, cur + "(", length, left - 1, right);
            }
            if (right > 0) {
                addParentheses(list, cur + ")", length, left, right - 1);
            }
        } else if (right == left && left > 0) {
            addParentheses(list, cur + "(", length, left - 1, right);
        }
    }
}