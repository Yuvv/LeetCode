/*
 * 1603-design-parking-system.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/02
 */
public class ParkingSystem {
    private int bigCnt;
    private int medCnt;
    private int smlCnt;
    public ParkingSystem(int big, int medium, int small) {
        bigCnt = big;
        medCnt = medium;
        smlCnt = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 3:
                if (smlCnt > 0) {
                    smlCnt--;
                    return true;
                }
                return false;
            case 2:
                if (medCnt > 0) {
                    medCnt--;
                    return true;
                }
                return false;
            case 1:
                if (bigCnt > 0) {
                    bigCnt--;
                    return true;
                }
                return false;
            default:
                return false;
        }
    }
}