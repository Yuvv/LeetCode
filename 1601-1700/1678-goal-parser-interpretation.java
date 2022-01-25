/*
 * 1678-goal-parser-interpretation.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/25
 */
public class Solution {
    public String interpret(String command) {
        return command.replaceAll("\\(al\\)", "al").replaceAll("\\(\\)", "o");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "Goal"
        System.out.println(s.interpret("G()(al)"));
        // "Goooooal"
        System.out.println(s.interpret("G()()()()(al)"));
        // "alGalooG"
        System.out.println(s.interpret("(al)G(al)()()G"));
    }
}