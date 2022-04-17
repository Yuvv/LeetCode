import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/*
 * 1226-the-dining-philosophers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/17
 */
public class DiningPhilosophers {

    private final ReentrantLock lock;
    private final Condition[] conditions;
    private final int[] forks;

    public DiningPhilosophers() {
        lock = new ReentrantLock(true);
        conditions = new Condition[5];
        forks = new int[5];
        for (int i = 0; i < 5; i++) {
            conditions[i] = lock.newCondition();
            forks[i] = 1;
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = (philosopher + 4) % 5;
        int right = (philosopher + 6) % 5;
        lock.lock();
        try {
            while (forks[left] == 0) {
                conditions[left].wait();
            }
            pickLeftFork.run();
            while (forks[right] == 0) {
                conditions[right].wait();
            }
            pickRightFork.run();

            eat.run();

            putRightFork.run();
            forks[right] = 1;
            conditions[right].signal();
            putLeftFork.run();
            forks[left] = 1;
            conditions[left].signal();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        DiningPhilosophers dp = new DiningPhilosophers();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));


        for (int i = 0; i < 5; i++) {
            executor.execute(new Philosopher(i, 20, dp));
        }
        executor.shutdown();
    }
}


class Philosopher implements Runnable {
    private int no;
    private int times;
    private DiningPhilosophers ins;

    public Philosopher(int no, int times, DiningPhilosophers ins) {
        this.no = no;
        this.times = times;
        this.ins = ins;
    }

    @Override
    public void run() {
        while (times-- > 0) {
            try {
                ins.wantsToEat(
                        no,
                        () -> System.out.println(no + " pick left"),
                        () -> System.out.println(no + " pick right"),
                        () -> System.out.println(no + " eat"),
                        () -> System.out.println(no + " put left\n"),
                        () -> System.out.println(no + " put right")
                );
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}