/**
 * 0592-fraction-addition-and-subtraction
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/1/3
 */
public class Solution {
    public String fractionAddition(String expression) {
        Fraction res = new Fraction(0, 1);
        int i = 0;
        while (i < expression.length()) {
            int j = i;
            while (j < expression.length() && expression.charAt(j) != '/') {
                j++;
            }
            int nu = Integer.parseInt(expression.substring(i, j));
            j++;
            i = j;
            while (j < expression.length() && expression.charAt(j) >= '0' && expression.charAt(j) <= '9') {
                j++;
            }
            int de = Integer.parseInt(expression.substring(i, j));

            res = res.add(new Fraction(nu, de));
            i = j;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "0/1"
        System.out.println(s.fractionAddition("-1/2+1/2"));
        // "1/3"
        System.out.println(s.fractionAddition("-1/2+1/2+1/3"));
        // "-1/6"
        System.out.println(s.fractionAddition("1/3-1/2"));
    }
}

class Fraction {
    int nu;
    int de;

    public Fraction(int nu, int de) {
        this.nu = nu;
        this.de = de;
        if (nu != 0) {
            // gcd
            if (nu < 0) {
                nu = -nu;
            }
            int t = 1;
            while (t != 0) {
                t = nu % de;
                nu = de;
                de = t;
            }
            this.nu /= nu;
            this.de /= nu;
        }
        if (this.nu == 0) {
            this.de = 1;
        }
    }

    public Fraction add(Fraction other) {
        return new Fraction(
                this.nu * other.de + this.de * other.nu,
                this.de * other.de);
    }

    @Override
    public String toString() {
        return nu + "/" + de;
    }
}
