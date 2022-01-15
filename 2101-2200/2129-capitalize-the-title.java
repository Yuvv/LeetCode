import java.util.stream.*;

/*
 * 2129-capitalize-the-title.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/15
 */
public class Solution {
    public String capitalizeTitle(String title) {
        return Stream.of(title.split(" "))
                .map(s -> {
                    s = s.toLowerCase();
                    if (s.length() > 2) {
                        return s.substring(0, 1).toUpperCase() + s.substring(1);
                    }
                    return s;
                }).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "Capitalize The Title"
        System.out.println(s.capitalizeTitle("capiTalIze tHe titLe"));
    }
}