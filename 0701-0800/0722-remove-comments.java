import java.util.*;

/*
 * 0722-remove-comments.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/14
 */
public class Solution {
    static final int MODE_CODE = 0;
    static final int MODE_BLOCK_COMMENT = 1;
    static final int MODE_STRING = 2;

    public List<String> removeComments(String[] source) {
        List<String> resList = new ArrayList<>();
        // default mode
        int mode = MODE_CODE;

        StringBuilder sb = new StringBuilder();
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (mode == MODE_CODE) {
                    if (ch == '/' && i < line.length() - 1) {
                        i++;
                        if (line.charAt(i) == '/') {
                            // line comment
                            break;
                        } else if (line.charAt(i) == '*') {
                            // block comment
                            mode = MODE_BLOCK_COMMENT;
                        } else {
                            sb.append(ch).append(line.charAt(i));
                        }
                    } else if (ch == '\"') {
                        // string
                        mode = MODE_STRING;
                        sb.append(ch);
                    } else {
                        sb.append(ch);
                    }
                } else if (mode == MODE_BLOCK_COMMENT) {
                    if (ch == '*' && i < line.length()) {
                        i++;
                        if (line.charAt(i) == '/') {
                            mode = MODE_CODE;
                        } else {
                            // move back
                            i--;
                        }
                    }
                } else if (mode == MODE_STRING) {
                    sb.append(ch);
                    if (ch == '\\') {
                        if (i < line.length() - 1) {
                            i++;
                        }
                        sb.append(line.charAt(i));
                    } else if (ch == '\"') {
                        mode = MODE_CODE;
                    }
                }
            }
            if (sb.length() > 0 && mode != MODE_BLOCK_COMMENT) {
                resList.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]
        System.out.println(s.removeComments(new String[] {
            "/*Test program */",
            "int main()",
            "{ ",
            "  // variable declaration ",
            "int a, b, c;",
            "/* This is a test",
            "   multiline  ",
            "   comment for ",
            "   testing */", "a = b + c;",
            "}"
        }));
    }
}