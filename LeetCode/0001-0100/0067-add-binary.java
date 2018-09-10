class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int pos_a = a.length() - 1;
        int pos_b = b.length() - 1;
        char char_a, char_b;
        char carry = '0';
        int r;
        
        while (pos_a >= 0 && pos_b >= 0) {
            char_a = a.charAt(pos_a);
            char_b = b.charAt(pos_b);
            r = char_a + char_b + carry - 144;
            if (r == 3) {
                sb.insert(0, '1');
                carry = '1';
            } else if (r == 2) {
                sb.insert(0, '0');
                carry = '1';
            } else {
                sb.insert(0, r);
                carry = '0';
            }
            
            pos_a--;
            pos_b--;
        }
        while (pos_a >= 0) {
            char_a = a.charAt(pos_a);
            r = char_a  + carry - 96;
            if (r == 3) {
                sb.insert(0, '1');
                carry = '1';
            } else if (r == 2) {
                sb.insert(0, '0');
                carry = '1';
            } else {
                sb.insert(0, r);
                carry = '0';
            }
            
            pos_a--;
        }
        while (pos_b >= 0) {
            char_b = b.charAt(pos_b);
            r = char_b  + carry - 96;
            if (r == 3) {
                sb.insert(0, '1');
                carry = '1';
            } else if (r == 2) {
                sb.insert(0, '0');
                carry = '1';
            } else {
                sb.insert(0, r);
                carry = '0';
            }
            
            pos_b--;
        }
        if (carry == '1') {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}