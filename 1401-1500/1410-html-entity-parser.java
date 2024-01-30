import java.util.Map;
import java.util.HashMap;

/**
 * 1410-html-entity-parser.java
 *
 * @date 2024/1/30
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    private static Map<String, Character> markers;
    static {
        markers = new HashMap<>();
        markers.put("quot", '"');
        markers.put("apos", '\'');
        markers.put("amp", '&');
        markers.put("gt", '>');
        markers.put("lt", '<');
        markers.put("frasl", '/');
    }
    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '&') {
                boolean ok = false;
                int j = i + 1;
                while (j < text.length() && Character.isLowerCase(text.charAt(j))) {
                    j++;
                }
                if (j < text.length() && text.charAt(j) == ';') {
                    Character mc = markers.get(text.substring(i+1, j));
                    if (mc != null) {
                        sb.append(mc.charValue());
                        ok = true;
                        i = j;
                    }
                }
                if (!ok) {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "& is an HTML entity but &ambassador; is not."
        System.out.println(s.entityParser("&amp; is an HTML entity but &ambassador; is not."));
        // "and I quote: \"...\""
        System.out.println(s.entityParser("and I quote: &quot;...&quot;"));
    }
}
