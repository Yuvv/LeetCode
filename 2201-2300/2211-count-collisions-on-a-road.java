import java.util.LinkedList;

/*
 * 2211-count-collisions-on-a-road.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/13
 */
public class Solution {
    public int countCollisions(String directions) {
        int total = 0;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < directions.length(); i++) {
            char ch = directions.charAt(i);
            if (stack.isEmpty()) {
                if (ch == 'R' || ch == 'S') {
                    stack.push(ch);
                }
            } else {
                if (ch == 'S') {
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        stack.pop();
                        total++;
                    }
                    stack.push(ch);
                } else if (ch == 'L') {
                    if (stack.peek() == 'R') {
                        total++;
                        while (!stack.isEmpty() && stack.peek() == 'R') {
                            stack.pop();
                            total++;
                        }
                    } else if (stack.peek() == 'S') {
                        total++;
                    }
                    stack.push('S');
                } else { // ch == 'R'
                    stack.push(ch);
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 24
        System.out.println(s.countCollisions("LSSSLLSSSSLRRSLLLSLSLRRLLLLLRSSRSRRSLLLSSS"));
        // 5
        System.out.println(s.countCollisions("RLRSLL"));
        // 0
        System.out.println(s.countCollisions("LLRR"));
        // 4
        System.out.println(s.countCollisions("RRLL"));
    }
}