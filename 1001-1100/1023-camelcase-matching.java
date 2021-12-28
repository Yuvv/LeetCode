import java.util.*;

/*
 * 1023-camelcase-matching.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/28
 */
public class Solution {
    boolean isUpper(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    List<String> camelSplit(String s) {
        List<String> resList = new ArrayList<>();
        int beg = 0;
        int cur = 0;
        while (cur < s.length()) {
            char ch = s.charAt(cur);
            if (isUpper(ch)) {
                if (cur > beg) {
                    resList.add(s.substring(beg, cur));
                }
                beg = cur;
            }
            cur++;
        }
        if (cur > beg) {
            resList.add(s.substring(beg, cur));
        }
        return resList;
    }

    boolean subsquence(String a, int ai, String b, int bi) {
        // check if a is subsquence of b
        if (ai >= a.length()) {
            return true;
        }
        if (bi >= b.length()) {
            return false;
        }
        boolean res = false;
        if (a.charAt(ai) == b.charAt(bi)) {
            res = subsquence(a, ai + 1, b, bi + 1);
        }
        if (!res) {
            res = subsquence(a, ai, b, bi + 1);
        }
        return res;
    }

    boolean matches(List<String> pattern, List<String> query) {
        int i = 0;
        int j = 0;
        while (i < pattern.size() && j < query.size()) {
            String is = pattern.get(i);
            boolean iFirstCharUpper = isUpper(is.charAt(0));
            String js = query.get(j);
            boolean jFirstCharUpper = isUpper(js.charAt(0));
            if ((iFirstCharUpper ^ jFirstCharUpper) == false) {
                if (!subsquence(is, 0, js, 0)) {
                    return false;
                }
                i++;
                j++;
            } else if (iFirstCharUpper && !jFirstCharUpper) {
                j++;
            } else if (!iFirstCharUpper && jFirstCharUpper) {
                i++;
            }
        }

        return i >= pattern.size() && j >= query.size();
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> resList = new ArrayList<>(queries.length);
        List<String> patternSplit = camelSplit(pattern);
        for (String query : queries) {
            List<String> querySplit = camelSplit(query);
            resList.add(matches(patternSplit, querySplit));
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [true, false, true, true, false]
        System.out.println(s.camelMatch(
            new String[] {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},
            "FB"
        ));
        // [true,false,true,false,false]
        System.out.println(s.camelMatch(
            new String[] {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},
            "FoBa"
        ));
        // [false,true,false,false,false]
        System.out.println(s.camelMatch(
            new String[] {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},
            "FoBaT"
        ));
    }
}