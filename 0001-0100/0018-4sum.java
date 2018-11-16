class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.putIfAbsent(nums[i] + nums[j], new ArrayList<>());
                List<List<Integer>> temp = map.get(nums[i] + nums[j]);
                List<Integer> curPair = new ArrayList<>(2);
                curPair.add(i);
                curPair.add(j);
                temp.add(curPair);
            }
        }

        Set<NSum<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[i] - nums[j])) {
                    for (List<Integer> pair : map.get(target - nums[i] - nums[j])) {
                        if (i != pair.get(0) && j != pair.get(0) &&
                                i != pair.get(1) && j != pair.get(1)) {
                            set.add(new NSum<>(nums[i], nums[j], nums[pair.get(0)], nums[pair.get(1)]));
                        }
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (NSum<Integer> each: set) {
            result.add(each.nums);
        }

        return result;
    }
}

class NSum<T> {
    List<T> nums;
    private String numStr;

    public NSum(T... nums) {
        this.nums = new ArrayList<>();
        Arrays.sort(nums);
        Collections.addAll(this.nums, nums);
        this.numStr = Arrays.toString(nums);
    }

    @Override
    public int hashCode() {
        return numStr.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof NSum) {
            NSum other = (NSum) o;
            if (nums.size() != other.nums.size()) {
                return false;
            }
            for (int i = 0; i < other.nums.size(); i++) {
                if (!other.nums.get(i).equals(nums.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}