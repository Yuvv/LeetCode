import java.util.*;

/**
 * 0726-number-of-atoms.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/14
 */
public class Solution {
    public String countOfAtoms(String formula) {
        LinkedList<FormulaEntry> stack = new LinkedList<>();
        FormulaReader reader = new FormulaReader(formula);
        while (reader.hasNext()) {
            FormulaEntry ne = reader.next();
            switch (ne.type) {
                case 1:  // Atom&Count
                case 2:  // (
                    stack.push(ne);  // just push into stack
                    break;
                case 3:  // )
                    int cnt = 1;
                    if (reader.peekNextType() == 4) {
                        cnt = reader.next().count;
                    }
                    Iterator<FormulaEntry> it = stack.iterator();
                    while (it.hasNext()) {
                        ne = it.next();
                        if (ne.type == 2) {
                            it.remove();
                            break;
                        } else {
                            ne.count *= cnt;
                        }
                    }
                    break;
                case 4:  // number
                    break;
                default:
                    break;
            }
        }
        TreeMap<String, Integer> treemap = new TreeMap<>();
        while (!stack.isEmpty()) {
            FormulaEntry ne = stack.pop();
            treemap.put(ne.atom, treemap.getOrDefault(ne.atom, 0) + ne.count);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treemap.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "H2O"
        System.out.println(s.countOfAtoms("H2O"));
        // "H2MgO2"
        System.out.println(s.countOfAtoms("Mg(OH)2"));
        // "K4N2O14S4"
        System.out.println(s.countOfAtoms("K4(ON(SO3)2)2"));
    }
}

class FormulaEntry {
    int type; // 1-Atom&Count, 2-(, 3-), 4-Number
    String atom;
    int count;

    public FormulaEntry(int t, String atom, int count) {
        this.type = t;
        this.atom = atom;
        this.count = count;
    }
}

class FormulaReader {
    private final String formula;
    private int pos;

    public FormulaReader(String f) {
        this.formula = f;
        this.pos = 0;
    }

    public FormulaEntry next() {
        if (pos >= formula.length()) {
            return null;
        }
        char ch = formula.charAt(pos);
        pos++;
        if (ch == '(') {
            return new FormulaEntry(2, "(", 0);
        } else if (ch == ')') {
            return new FormulaEntry(3, ")", 0);
        } else if (ch >= '0' && ch <= '9') {
            FormulaEntry e = new FormulaEntry(4, "", ch - '0');
            while (pos < formula.length()) {
                ch = formula.charAt(pos);
                if (ch < '0' || ch > '9') {
                    break;
                }
                e.count = e.count * 10 + (ch - '0');
                pos++;
            }
            return e;
        } else {
            int beg = pos - 1;
            while (pos < formula.length()) {
                ch = formula.charAt(pos);
                if (ch < 'a' || ch > 'z') {
                    break;
                }
                pos++;
            }
            FormulaEntry e = new FormulaEntry(1, formula.substring(beg, pos), 0);
            while (pos < formula.length()) {
                ch = formula.charAt(pos);
                if (ch < '0' || ch > '9') {
                    break;
                }
                e.count = e.count * 10 + (ch - '0');
                pos++;
            }
            if (e.count == 0) {
                e.count = 1;
            }
            return e;
        }
    }

    public int peekNextType() {
        if (pos >= formula.length()) {
            return 0;
        }
        char ch = formula.charAt(pos);
        if (ch >= '0' && ch <= '9') {
            return 4;
        } else if (ch == '(') {
            return 2;
        } else if (ch == ')') {
            return 3;
        } else {
            return 1;
        }
    }

    public boolean hasNext() {
        return this.pos < this.formula.length();
    }
}
