import java.util.TreeSet;

/*
 * 0649-dota2-senate.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/18
 */
public class Solution {
    public String predictPartyVictory(String senate) {
        TreeSet<Integer> rSet = new TreeSet<>();
        TreeSet<Integer> dSet = new TreeSet<>();
        for (int i = 0; i < senate.length(); i++) {
            char ch = senate.charAt(i);
            if (ch == 'R') {
                rSet.add(i);
            } else {
                dSet.add(i);
            }
        }
        int idx = 0;
        while (!rSet.isEmpty() && !dSet.isEmpty()) {
            Integer ri = rSet.ceiling(idx);
            Integer di = dSet.ceiling(idx);
            if (ri == null && di == null) {
                idx = 0;
            } else if (ri == null) {
                rSet.remove(rSet.first());
                idx = di + 1;
            } else if (di == null) {
                dSet.remove(dSet.first());
                idx = ri + 1;
            } else {
                if (ri < di) {
                    idx = ri + 1;
                    dSet.remove(di);
                } else {
                    idx = di + 1;
                    rSet.remove(ri);
                }
            }
        }
        if (dSet.isEmpty()) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // Radiant
        System.out.println(s.predictPartyVictory("RD"));
        // Dire
        System.out.println(s.predictPartyVictory("RDD"));
        // Dire
        System.out.println(s.predictPartyVictory("DDRRR"));
        // Radiant
        System.out.println(s.predictPartyVictory("RDDR"));
        // Radiant
        System.out.println(s.predictPartyVictory("RDDRRDRDDDRDRDRDRRRDRDRDRDRDDRDR"));
        // Radiant
        System.out.println(s.predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
}