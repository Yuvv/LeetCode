class Solution {
    /**
     * 找出和为 0 的三个数
     * https://leetcode.com/problems/3sum/description/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> resultSetMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int a, b, c;
        int[] tmpArr;
        List<Integer> numSetList = new ArrayList<>(map.size());
        numSetList.addAll(map.keySet());

        int i, j;
        for (i = 0; i < numSetList.size(); i++) {
            a = numSetList.get(i);
            for (j = i + (map.get(a).size() > 1 ? 0 : 1); j < numSetList.size(); j++) {
                b = numSetList.get(j);
                c = 0 - a - b;
                if (b == a && c == b && map.get(c).size() < 3) {
                    continue;
                }
                if (c == a && map.get(a).size() < 2) {
                    continue;
                }
                if (c == b && map.get(b).size() < 2) {
                    continue;
                }
                if (map.containsKey(c)) {
                    tmpArr = sortThreeNum(a, b, c);
                    if (!resultSetMap.containsKey(tmpArr[0])) {
                        resultSetMap.put(tmpArr[0], new HashSet<>());
                    }
                    resultSetMap.get(tmpArr[0]).add(tmpArr[1]);
                }
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        resultSetMap.forEach((k, v) ->
                v.forEach(it -> {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(k);
                    list.add(it);
                    list.add(0 - k - it);
                    resultList.add(list);
                })
        );
        return resultList;
    }

    int[] sortThreeNum(int a, int b, int c) {
        int tmp;
        if (a > b) {
            tmp = b;
            b = a;
            a = tmp;
        }
        if (a > c) {
            tmp = c;
            c = a;
            a = tmp;
        }
        if (b > c) {
            tmp = c;
            c = b;
            b = tmp;
        }
        return new int[]{a, b, c};
    }
}

class Triple {
    public int a;
    public int b;
    public int c;

    public Triple(int a, int b) {
        int c = 0 - a - b;
        int tmp;
        if (a > b) {
            tmp = b;
            b = a;
            a = tmp;
        }
        if (a > c) {
            tmp = c;
            c = a;
            a = tmp;
        }
        if (b > c) {
            tmp = c;
            c = b;
            b = tmp;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int hashCode() {
        return ("" + a + ' ' + b + ' ' + c).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Triple) {
            Triple other = (Triple) o;
            return this.a == other.a && this.b == other.b && this.c == other.c;
        }
        return false;
    }

    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>(3);
        list.add(a);
        list.add(b);
        list.add(c);
        return list;
    }
}

class Pair {
    private int a;
    private int b;

    public Pair(int a, int b) {
        this.a = a <= b ? a : b;
        this.b = a <= b ? b : a;
    }

    @Override
    public int hashCode() {
        return ("" + a + ' ' + b).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair other = (Pair) o;
            return a == other.a && b == other.b;
        }

        return false;
    }
}