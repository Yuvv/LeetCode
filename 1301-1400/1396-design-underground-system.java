import java.util.*;

/*
 * 1396-design-underground-system.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/24
 */
public class UndergroundSystem {

    private Map<String, StationTimeRecord> stationMap;
    private Map<Integer, CustomerCheck> customerMap;

    public UndergroundSystem() {
        stationMap = new HashMap<>();
        customerMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        CustomerCheck cc = new CustomerCheck(id, stationName, t);
        customerMap.put(id, cc);
    }

    public void checkOut(int id, String stationName, int t) {
        CustomerCheck cc = customerMap.remove(id);
        String key = cc.inStationName + "-" + stationName;
        stationMap.computeIfAbsent(key, k -> new StationTimeRecord())
                .addCheckTime(t - cc.inTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        return stationMap.computeIfAbsent(key, k -> new StationTimeRecord())
                .getAverageTime();
    }

    public static void main(String[] args) {
        UndergroundSystem us = new UndergroundSystem();
        us.checkIn(45, "Leyton", 3);
        us.checkIn(32, "Paradise", 8);
        us.checkIn(27, "Leyton", 10);
        us.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        us.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        us.checkOut(32, "Cambridge", 22); // Custoker 32 "Paradise" -> "Cambridge" in 22-8 = 14
        // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        System.out.println(us.getAverageTime("Paradise", "Cambridge"));
        // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        System.out.println(us.getAverageTime("Leyton", "Waterloo"));
        us.checkIn(10, "Leyton", 24);
        // return 11.00000
        System.out.println(us.getAverageTime("Leyton", "Waterloo"));
        us.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
        System.out.println(us.getAverageTime("Leyton", "Waterloo"));

    }
}

class CustomerCheck {
    int id;
    String inStationName;
    int inTime;

    public CustomerCheck(int id, String stationName, int t) {
        this.id = id;
        this.inStationName = stationName;
        this.inTime = t;
    }
}

class StationTimeRecord {
    long total;
    int checkTimes;

    public StationTimeRecord() {
        this.total = 0L;
        this.checkTimes = 0;
    }

    public void addCheckTime(int elapsed) {
        this.total += elapsed;
        this.checkTimes++;
    }

    public double getAverageTime() {
        if (checkTimes == 0) {
            return -1D;
        }
        return total * 1D / checkTimes;
    }
}
