/*
 * 0468-validate-ip-address.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/27
 */
public class Solution {
    static final String NEITHER = "Neither";
    static final String IPv6 = "IPv6";
    static final String IPv4 = "IPv4";

    public String validIPAddress(String queryIP) {
        if (queryIP.indexOf(':') >= 0) {
            // maybe IPv6
            String[] slices = queryIP.split(":");
            if (slices.length != 8) {
                return NEITHER;
            }
            for (String slice : slices) {
                if (slice.length() <= 0 || slice.length() > 4) {
                    return NEITHER;
                }
                for (int i = 0; i < slice.length(); i++) {
                    char ch = slice.charAt(i);
                    boolean ok = false;
                    if (!ok && ch >= '0' && ch <= '9') {
                        ok = true;
                    }
                    if (!ok && ch >= 'a' && ch <= 'f') {
                        ok = true;
                    }
                    if (!ok && ch >= 'A' && ch <= 'F') {
                        ok = true;
                    }
                    if (!ok) {
                        return NEITHER;
                    }
                }
            }
            return IPv6;
        } else {
            // maybe IPv4
            String[] slices = queryIP.split("\\.");
            if (slices.length != 4) {
                return NEITHER;
            }
            for (String slice : slices) {
                try {
                    int val = Integer.parseInt(slice);
                    if (val < 0 || val > 255) {
                        return NEITHER;
                    }
                    if (!slice.equals(val + "")) {
                        return NEITHER;
                    }
                } catch (Exception ex) {
                    return NEITHER;
                }
            }
            return IPv4;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // Neither
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        // IPv4
        System.out.println(s.validIPAddress("172.16.254.1"));
        // IPv6
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        // "Neither"
        System.out.println(s.validIPAddress("256.256.256.256"));
    }
}