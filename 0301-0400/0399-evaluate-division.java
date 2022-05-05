import java.util.*;

/*
 * 0399-evaluate-division.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/30
 */
public class Solution {

    private void preFill(Map<String, Double> map, Map<String, String> root, String a, String b, double value) {
        if (map.containsKey(a) && map.containsKey(b)) {
            return;
        }
        if (map.containsKey(a)) {
            if (!map.containsKey(b)) {
                map.put(b, map.get(a) / value);
                root.put(b, root.get(a));
            }
        } else if (map.containsKey(b)) {
            if (!map.containsKey(a)) {
                map.put(a, map.get(b) * value);
                root.put(a, root.get(b));
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build graph
        // map record expression's value
        Map<String, Double> map = new HashMap<>();
        // root record each expression's root (or union)
        Map<String, String> root = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            if (map.containsKey(a) && map.containsKey(b)) {
                continue;
            }
            if (map.containsKey(a)) {
                if (!map.containsKey(b)) {
                    map.put(b, map.get(a) / values[i]);
                    root.put(b, root.get(a));
                }
            } else if (map.containsKey(b)) {
                if (!map.containsKey(a)) {
                    map.put(a, map.get(b) * values[i]);
                    root.put(a, root.get(b));
                }
            } else {
                map.put(b, 1.0D);
                map.put(a, values[i]);
                root.put(b, a);
                root.put(a, a);
            }
            for (int j = i + 1; j < equations.size(); j++) {
                List<String> eqx = equations.get(j);
                String ax = eqx.get(0);
                String bx = eqx.get(1);
                preFill(map, root, ax, bx, values[j]);
            }
        }
        // calculate result
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            if (map.containsKey(a) && map.containsKey(b) && Objects.equals(root.get(a), root.get(b))) {
                res[i] = map.get(a) / map.get(b);
            } else {
                res[i] = -1D;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [6.00000,0.50000,-1.00000,1.00000,-1.00000]
        System.out.println(Arrays.toString(s.calcEquation(
            Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
            ),
            new double[] {2.0D, 3.0D},
            Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
            )
        )));
        // [3.75000,0.40000,5.00000,0.20000]
        System.out.println(Arrays.toString(s.calcEquation(
            Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c"),
                Arrays.asList("bc", "cd")
            ),
            new double[] {1.5D, 2.5D, 5.0D},
            Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("c", "b"),
                Arrays.asList("bc", "cd"),
                Arrays.asList("cd", "bc")
            )
        )));
    }
}


/*

[["a","b"],["b","c"],["bc","cd"],["c", "d"],["cd", "de"],["x","y"]]
[1.5,2.5,5.0,1.3,1.7,0.7]
[["a","c"],["c","b"],["bc","cd"],["cd","bc"],["d","c"],["de", "cd"],["de","dc"],["y","x"]]

[["a","b"], ["e","f"], ["b","e"]]
[3.4,1.4,2.3]
[["b","a"], ["a","f"], ["f","f"],["e","e"],["c","c"],["a","c"],["f","e"]]

[["a","b"],["c","d"]]
[1.0,1.0]
[["a","c"],["b","d"],["b","a"],["d","c"]]


*/