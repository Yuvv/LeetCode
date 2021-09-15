import java.util.*;

/*
 * 0874-walking-robot-simulation.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/15
 */
public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 0=right, 1=up, 2=left, 3=down
        int direction = 1;
        int x = 0, y = 0;
        int maxDis = 0;
        Map<Integer, TreeSet<Integer>> xMap = new HashMap<>(obstacles.length);
        Map<Integer, TreeSet<Integer>> yMap = new HashMap<>(obstacles.length);
        for (int[] xy : obstacles) {
            xMap.computeIfAbsent(xy[0], k -> new TreeSet<>()).add(xy[1]);
            yMap.computeIfAbsent(xy[1], k -> new TreeSet<>()).add(xy[0]);
        }
        for (int cmd : commands) {
            if (cmd == -1) {
                direction += 3;
                direction %= 4;
            } else if (cmd == -2) {
                direction += 1;
                direction %= 4;
            } else {
                Integer next = null;
                switch (direction) {
                    case 0:
                        if (yMap.containsKey(y)) {
                            next = yMap.get(y).ceiling(x + 1);
                        }
                        if (next != null) {
                            x = Math.min(x + cmd, next - 1);
                        } else {
                            x += cmd;
                        }
                        break;
                    case 1:
                        if (xMap.containsKey(x)) {
                            next = xMap.get(x).ceiling(y + 1);
                        }
                        if (next != null) {
                            y = Math.min(y + cmd, next - 1);
                        } else {
                            y += cmd;
                        }
                        break;
                    case 2:
                        if (yMap.containsKey(y)) {
                            next = yMap.get(y).floor(x - 1);
                        }
                        if (next != null) {
                            x = Math.max(x - cmd, next + 1);
                        } else {
                            x -= cmd;
                        }
                        break;
                    case 3:
                        if (xMap.containsKey(x)) {
                            next = xMap.get(x).floor(y - 1);
                        }
                        if (next != null) {
                            y = Math.max(y - cmd, next + 1);
                        } else {
                            y -= cmd;
                        }
                        break;
                    default:
                        // error
                        break;
                }
                maxDis = Math.max(maxDis, x * x + y * y);
            }
        }
        return maxDis;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 25
        System.out.println(s.robotSim(new int[] {4,-1,3}, new int[0][]));
        // 65
        System.out.println(s.robotSim(new int[] {4,-1,4,-2,4}, new int[][]{{2,4}}));
        // 202
        System.out.println(s.robotSim(new int[] {4,-1,4,-2,4,3,5,-1,3,-2,4,-1,3,-1,2,-1,4,-1,5,-1,3,-1,2},
                new int[][]{{2,4},{4,5},{2,3},{0,1},{1,6}}));
    }
}