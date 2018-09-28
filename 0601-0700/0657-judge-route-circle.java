class Solution {
    /**
     * 找出路径是否成环（回到原点）
     * https://leetcode.com/problems/judge-route-circle/description/
     */
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
            case 'U':
                y++;
                break;
            case 'D':
                y--;
                break;
            case 'R':
                x++;
                break;
            case 'L':
                x--;
                break;
            default:
                break;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        return false;
    }
}