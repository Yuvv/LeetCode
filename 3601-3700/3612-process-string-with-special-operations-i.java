/**
 * 3612-process-string-with-special-operations-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/17
 */
public class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
            case '#':
                sb.append(sb.toString());
                break;
            case '*':
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length()-1);
                }
                break;
            case '%':
                sb.reverse();
                break;
            default:
                sb.append(ch);
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "ba"
        System.out.println(s.processStr("a#b%*"));
        // ""
        System.out.println(s.processStr("z*#"));
    }
}
