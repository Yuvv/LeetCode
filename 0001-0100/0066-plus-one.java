class Solution {
    public int[] plusOne(int[] digits) {
        int sum = digits[digits.length - 1] + 1;
        int carry = sum / 10;
        digits[digits.length - 1] = sum % 10;
        
        // carry > 0 时逐步加上去
        for (int i=digits.length-2; carry>0 && i>=0; i--) {
            sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        
        if (carry == 0) {
            return digits;
        }
        
        int[] nDigits = new int[digits.length + 1];
        nDigits[0] = carry;
        for (int i=0; i<digits.length; i++) {
            nDigits[i+1] = digits[i];
        }
        return nDigits;
    }
}