import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * 1117-building-h2o.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/08/16
 */
public class H2O {

    Semaphore hSemaphore;
    Semaphore oSemaphore;

    public H2O() {
        hSemaphore = new Semaphore(2);
        oSemaphore = new Semaphore(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        hSemaphore.release(2);
    }

    public static void main(String[] args) throws Exception {
        H2O h2o = new H2O();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 30, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<>(12));
        for (int i = 0; i < 12; i++) {
            executor.execute(new HydrogenRunnable(h2o));
            executor.execute(new OxygenRunnable(h2o));
            executor.execute(new HydrogenRunnable(h2o));
        }
        executor.shutdown();
    }
}

class HydrogenRunnable implements Runnable {
    H2O h2O;

    public HydrogenRunnable(H2O h2O) {
        this.h2O = h2O;
    }

    @Override
    public void run() {
        try {
            h2O.hydrogen(() -> System.out.print('H'));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class OxygenRunnable implements Runnable {
    H2O h2O;

    public OxygenRunnable(H2O h2O) {
        this.h2O = h2O;
    }

    @Override
    public void run() {
        try {
            h2O.oxygen(() -> System.out.print('O'));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}