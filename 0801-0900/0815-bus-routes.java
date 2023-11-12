import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * 0815-bus-routes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/12
 */
public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        LinkedList<Integer> queue = new LinkedList<>(); // bus queue
        Set<Integer> visited = new HashSet<>();  // record all visited bus
        Map<Integer, List<Integer>> stationMap = new HashMap<>(); // station -> all bus include self
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                stationMap.computeIfAbsent(station, k -> new ArrayList<>()).add(i);
                if (station == source) {
                    queue.addLast(i);
                    visited.add(i);
                }
            }
        }

        // bfs
        int busCount = 1; // source bus already visited
        while (!queue.isEmpty()) {  
            int size = queue.size();
            while (size > 0) {
                Integer current = queue.pollFirst();
                for (int station : routes[current]) {
                    if (station == target) {
                        return busCount;
                    }
                    for (Integer b : stationMap.get(station)) {
                        if (visited.contains(b)) {
                            continue;
                        }
                        queue.addLast(b);
                        visited.add(b);
                    }
                }
                size--;
            }
            busCount++;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        // 2
        System.out.println(s.numBusesToDestination(
                new int[][] { { 1, 2, 7 }, { 3, 6, 7 } },
                1, 6));
        // -1
        System.out.println(s.numBusesToDestination(
                new int[][] { { 7, 12 }, { 4, 5, 15 }, { 6 }, { 15, 19 }, { 9, 12, 13 } },
                1, 6));
        if (args.length > 0) {
            Scanner scanner = new Scanner(Files.newInputStream(Paths.get(args[0])));
            String input = scanner.nextLine();
            String[] sub = input.substring(2, input.length() - 2).split("], \\[");
            int[][] routes = new int[sub.length][];
            for (int i = 0; i < sub.length; i++) {
                String[] sSub = sub[i].split(",");
                routes[i] = new int[sSub.length];
                for (int j = 0; j < sSub.length; j++) {
                    routes[i][j] = Integer.parseInt(sSub[j].trim());
                }
            }
            int source = Integer.parseInt(scanner.next());
            int target = Integer.parseInt(scanner.next());
            System.out.println(s.numBusesToDestination(routes, source, target));
        }
    }
}
