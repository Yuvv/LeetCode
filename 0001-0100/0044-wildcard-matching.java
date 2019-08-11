import java.util.*;

class State {
    static char START = '^';
    static char END = '$';

    char val;
    List<State> nextList;

    public State(char _val) {
        val = _val;
        nextList = new ArrayList<>();
    }

    public boolean matchStringFrom(String s, int index) {
        if (index >= s.length()) {
            for (State state : nextList) {
                if (state.val == State.END) {
                    return true;
                }
            }
            return false;
        }
        for (State state : nextList) {
            if (state.val == '?' || state.val == '*' || state.val == s.charAt(index)) {
                if (state.matchStringFrom(s, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addNext(State s) {
        nextList.add(s);
    }
}

/*
 * 0044-wildcard-matching.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2019/07/31
 */
public class Solution {
    /**
     * 1. 构建状态机在数据量大起来就会超时
     * 2. 动态规划可以AC
     * https://leetcode.com/problems/wildcard-matching/
     */
    public boolean isMatchByStateMachine(String s, String p) {
        State state = buildStateMachine(p);
        return state.matchStringFrom(s, 0);
    }

    State buildStateMachine(String p) {
        State start = new State(State.START);
        State end = new State(State.END);
        int pLen = p.length();
        int i = 0;
        State prevState = start;
        while (i < pLen) {
            State curState = new State(p.charAt(i));
            prevState.addNext(curState);
            if (p.charAt(i) == '*') {
                curState.addNext(curState);
                while (i < pLen && p.charAt(i) == '*') {
                    i++;
                }
                if (i < pLen) {
                    State nextState = new State(p.charAt(i));
                    curState.addNext(nextState);
                    prevState.addNext(nextState);
                    prevState = nextState;
                } else {
                    curState.addNext(end);
                }
            } else {
                prevState = curState;
            }
            i++;
        }
        prevState.addNext(end);

        return start;
    }

    public boolean isMatch(String s, String p) {
        // dp table，长度多 1 表示初始状态
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // dp[i][j]  表示 s 的第 i 个自付与 p 的第 j 个字符匹配
        int i, j;
        dp[0][0] = true;
        for (i = 1; i <= s.length(); i++) {
            // p 的起始必须是 s 的起始，其它位置都不能匹配
            dp[i][0] = false;
        }
        for (j = 1; j <= p.length(); j++) {
            // p 的起始是 '*' 的话也能匹配上
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        }
        for (i = 1; i <= s.length(); i++) {
            for (j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false  expected
        System.out.println(s.isMatch("aa", "a"));
        // true  expected
        System.out.println(s.isMatch("aa", "*"));
        // false  expected
        System.out.println(s.isMatch("cb", "?a"));
        // true  expected
        System.out.println(s.isMatch("cbaxedb", "?*a*b"));
        // false  expected
        System.out.println(s.isMatch("acdcb", "a*c?b"));
        // false  expected
        System.out.println(s.isMatch(
            "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
            "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }
}