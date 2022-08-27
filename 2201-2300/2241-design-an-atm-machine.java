/*
 * 2241-design-an-atm-machine.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/27
 */
public class ATM {
    static final int[] BASE = new int[] {20, 50, 100, 200, 500};

    private long[] arr;

    public ATM() {
        this.arr = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            arr[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] res = new int[arr.length];
        for (int i = BASE.length - 1; i >= 0; i--) {
            if (amount >= BASE[i] && arr[i] > 0) {
                res[i] = (int) Math.min(arr[i], (long) amount / BASE[i]);
                amount -= res[i] * BASE[i];
            }
        }
        //
        if (amount > 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < res.length; i++) {
            arr[i] -= res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[] {0,0,1,2,1});
        // [0,0,1,0,1]
        atm.withdraw(600);
        atm.deposit(new int[] {0,1,0,1,1});
        // [-1]
        atm.withdraw(600);
        // [0,1,0,0,1]
        atm.withdraw(550);
    }
}