import java.util.*;

/*
 * 0385-mini-parser.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/13
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        LinkedList<NestedInteger> stack = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9' || ch == '-') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                int val = Integer.parseInt(s.substring(i, j));
                NestedInteger ni = new NestedInteger(val);
                if (stack.isEmpty()) {
                    stack.push(ni);
                } else {
                    stack.peek().add(ni);
                }
                i = j - 1;
            } else if (ch == '[') {
                stack.push(new NestedInteger());
            } else if (ch == ']') {
                NestedInteger ni = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(ni);
                } else {
                    stack.peek().add(ni);
                }
            }
            i++;
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 324
        System.out.println(s.deserialize("324"));
        // [123,[456,[789]]]
        System.out.println(s.deserialize("[123,[456,[789]]]"));
    }
}



// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger();

    // Constructor initializes a single integer.
    public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
