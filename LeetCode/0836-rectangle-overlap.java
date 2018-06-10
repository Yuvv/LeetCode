class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean flag_x = false, flag_y = false;
        if (rec1[0] < rec2[0]) {
            if (rec2[0] < rec1[2]) {
                flag_x = true;
            }
        } else {
            if (rec1[0] < rec2[2]) {
                flag_x = true;
            }
        }
        if (rec1[1] < rec2[1]) {
            if (rec2[1] < rec1[3]) {
                flag_y = true;
            }
        } else {
            if (rec1[1] < rec2[3]) {
                flag_y = true;
            }
        }
        
        return flag_x && flag_y;
    }
}