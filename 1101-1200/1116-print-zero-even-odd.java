import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/*
 * 1116-print-zero-even-odd.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/05/17
 */
class ZeroEvenOdd {
    private int n;

    private final Semaphore zeroSemaphore = new Semaphore(1);
    private final Semaphore oddSemaphore = new Semaphore(1);
    private final Semaphore evenSemaphore = new Semaphore(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
        try {
            oddSemaphore.acquire();
            evenSemaphore.acquire();
        } catch (Exception e) {
            //
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                oddSemaphore.release();
            } else {
                evenSemaphore.release();
            }
        }
        oddSemaphore.release();
        evenSemaphore.release();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            evenSemaphore.acquire();
            if (i > n) {
                zeroSemaphore.release();
                evenSemaphore.release();
                break;
            }
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            oddSemaphore.acquire();
            if (i > n) {
                zeroSemaphore.release();
                oddSemaphore.release();
                break;
            }
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        IntConsumer consumer = System.out::print;
        if (args.length == 0) {
            System.out.println("Argument `n` required");
            return;
        }
        int n = Integer.parseInt(args[0]);
        // `0102030405...0n` expected
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(consumer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(consumer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thirdThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(consumer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        firstThread.join();
        secondThread.join();
        thirdThread.join();
    }
}