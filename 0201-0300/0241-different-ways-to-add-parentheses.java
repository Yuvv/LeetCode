import java.util.*;

/*
 * 0241-different-ways-to-add-parentheses.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/24
 */
public class Solution {
    Map<String, List<Integer>> cachedResult;

    public List<Integer> diffWaysToCompute(String expression) {
        cachedResult = new HashMap<>();

        // split
        List<Node> nodeList = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < expression.length(); j++) {
            char ch = expression.charAt(j);
            if (ch == '+' || ch == '-' || ch == '*') {
                nodeList.add(new NumberNode(Integer.parseInt(expression.substring(i, j))));
                nodeList.add(new SignNode(ch));
                i = j + 1;
            }
        }
        // add last number
        nodeList.add(new NumberNode(Integer.parseInt(expression.substring(i))));

        return addParentheses(nodeList, 0, nodeList.size() - 1);
    }

    // recursive calculate each sub-expression
    public List<Integer> addParentheses(List<Node> nodeList, int from, int to) {
        String key = from + "," + to;
        if (cachedResult.containsKey(key)) {
            return cachedResult.get(key);
        }
        List<Integer> resList = new ArrayList<>();
        if (from == to) {
            resList.add(((NumberNode) nodeList.get(from)).val);
        } else {
            for (int i = from; i < to; i += 2) {
                List<Integer> ll = addParentheses(nodeList, from, i);
                List<Integer> rl = addParentheses(nodeList, i + 2, to);
                char sign = ((SignNode) nodeList.get(i + 1)).sign;
                for (Integer ln : ll) {
                    for (Integer rn : rl) {
                        resList.add(calc(ln, sign,rn));
                    }
                }
            }
        }
        cachedResult.put(key, resList);
        return resList;
    }

    private int calc(int left, char sign, int right) {
        if (sign == '+') {
            return left + right;
        } else if (sign == '-') {
            return left - right;
        } else {
            return left * right;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,2]
        System.out.println(s.diffWaysToCompute("2-1-1"));
        // [-34,-14,-10,-10,10]
        System.out.println(s.diffWaysToCompute("2*3-4*5"));
        // [1]
        System.out.println(s.diffWaysToCompute("1"));
        // [1]
        System.out.println(s.diffWaysToCompute("0+1+2-3*4-5+6*7+8-9"));
    }
}

class Node {
    boolean isSign;

    public Node(boolean isSign) {
        this.isSign = isSign;
    }
}

class NumberNode extends Node {
    int val;

    public NumberNode(int val) {
        super(false);
        this.val = val;
    }
}

class SignNode extends Node {
    char sign;

    public SignNode(char ch) {
        super(true);
        this.sign = ch;
    }
}