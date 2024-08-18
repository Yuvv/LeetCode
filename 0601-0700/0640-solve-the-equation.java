/**
 * 0640-solve-the-equation.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/18
 */
public class Solution {
    public String solveEquation(String equation) {
        int nx = 0;
        int nn = 0;
        boolean right = false;
        EquationReader reader = new EquationReader(equation);
        while (reader.hasNext()) {
            char sign = reader.nextSign();
            if (sign == '=') {
                right = true;
            } else if (sign == '+') {
                int n = reader.nextNumber();
                if (reader.hasX()) {
                    reader.nextX();
                    if (right) {
                        nx -= n;
                    } else {
                        nx += n;
                    }
                } else {
                    if (right) {
                        nn -= n;
                    } else {
                        nn += n;
                    }
                }
            } else if (sign == '-') {
                int n = reader.nextNumber();
                if (reader.hasX()) {
                    reader.nextX();
                    if (right) {
                        nx += n;
                    } else {
                        nx -= n;
                    }
                } else {
                    if (right) {
                        nn += n;
                    } else {
                        nn -= n;
                    }
                }
            }
        }
        if (nx == 0) {
            if (nn == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + (-nn / nx);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "x=2"
        System.out.println(s.solveEquation("x+5-3+x=6+x-2"));
        // "Infinite solutions"
        System.out.println(s.solveEquation("x=x"));
        // "x=0"
        System.out.println(s.solveEquation("2x=x"));
    }
}

class EquationReader {
    String equation;
    int pos;

    public EquationReader(String e) {
        this.equation = e;
        this.pos = 0;
    }

    public boolean hasNext() {
        return pos < equation.length();
    }

    public char nextSign() {
        char ch = equation.charAt(pos);
        if (ch >= '0' && ch <= '9' || ch == 'x') {
            // first number/x without sign
            return '+';
        }
        pos++;
        return ch;
    }

    public boolean hasNumber() {
        if (pos >= equation.length()) {
            return false;
        }
        char ch = equation.charAt(pos);
        return ch >= '0' && ch <= '9';
    }

    public int nextNumber() {
        if (!hasNumber()) {
            return 1;
        }
        int j = pos;
        while (j < equation.length() && equation.charAt(j) >= '0' && equation.charAt(j) <= '9') {
            j++;
        }
        int num = Integer.parseInt(equation.substring(pos, j));
        pos = j;
        return num;
    }

    public boolean hasX() {
        if (pos >= equation.length()) {
            return false;
        }
        char ch = equation.charAt(pos);
        return ch == 'x';
    }

    public char nextX() {
        char ch = equation.charAt(pos);
        pos++;
        return ch;
    }
}
