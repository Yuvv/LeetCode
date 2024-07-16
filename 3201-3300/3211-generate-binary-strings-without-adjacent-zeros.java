import java.util.*;

/**
 * 3211-generate-binary-strings-without-adjacent-zeros.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/16
 */
public class Solution {
    public List<String> validStrings(int n) {
        List<String> resList = new ArrayList<>();
        dfs(new StringBuilder(), n, resList);
        return resList;
    }

    private void dfs(StringBuilder sb, int n, List<String> resList) {
        if (sb.length() == n) {
            resList.add(sb.toString());
            return;
        }
        int len = sb.length();
        // '0'
        if (sb.length() == 0 || sb.charAt(sb.length()-1) != '0') {
            sb.append('0');
            dfs(sb, n, resList);
        }
        sb.delete(len, sb.length());
        // '1'
        sb.append('1');
        dfs(sb, n, resList);
        sb.delete(len, sb.length());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["010","011","101","110","111"]
        System.out.println(s.validStrings(3));
        // ["0", "1"]
        System.out.println(s.validStrings(1));
    }
}
