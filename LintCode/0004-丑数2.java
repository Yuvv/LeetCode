public class Solution {
    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        
        // TLE
        // Map<Integer, Boolean> map = new HashMap<>();
        // map.put(1, true);
        // map.put(2, true);
        // map.put(3, true);
        // map.put(5, true);
        
        // int curI = 1;
        // int curN = 1;
        // while(curI < n) {
        //     curN++;
        //     if(hasThat(map, curN)) {
        //         curI++;
        //         map.put(curN, true);
        //     }
        // }
        // return curN;
        
        int[] val = new int[n];
        val[0] = 1;
        
        int idx2 = 0,
            idx3 = 0,
            idx5 = 0;
            
        int counter = 1;
        int curMin = 0;
        
        while(counter < n) {
            curMin = minValue(val[idx2]*2, val[idx3]*3, val[idx5]*5);
            
            if(curMin == val[idx2]*2) {
                idx2++;
            }
            if(curMin == val[idx3]*3) {
                idx3++;
            }
            if(curMin == val[idx5]*5) {
                idx5++;
            }
            
            val[counter] = curMin;
            
            counter++;
        }
        
        return val[n-1];
    }
    
    int minValue(int a, int b, int c) {
        int d = a < b ? a : b ;
        return d < c ? d : c;
    }
    
    // boolean hasThat(Map<Integer, Boolean> map, int n) {
    //     if(n % 2 == 0) {
    //         return map.containsKey(n / 2);
    //     }
    //     if(n % 3 == 0) {
    //         return map.containsKey(n / 3);
    //     }
    //     if(n % 5 == 0) {
    //         return map.containsKey(n / 5);
    //     }
    //     return false;
    // }
}