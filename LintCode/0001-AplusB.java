public class Solution {
    /*
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // 投机取巧方式
        // return a - (-b);
        
        // 位运算方式
        int sum;
        int carry;
        do {
            sum = a ^ b;
            carry = a & b;
            a = carry << 1;
            b = sum;
        } while (carry > 0);
        
        return sum;
    }
}