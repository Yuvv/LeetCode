class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]), i+1};
            } else {
                map.put(numbers[i], i+1);
            }
        }
        return new int[]{-1, -1};
    }
    /*
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        int[] re = new int[2];
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum > target) high --;
            else if(sum < target) low ++;
            else{
                re[0] = low + 1; re[1] = high + 1; break;
            }
        }
        return re;
    }
     */
}