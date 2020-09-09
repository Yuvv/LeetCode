import java.util.concurrent.AtomicInteger;

/*
 * 1195-fizz-buzz-multithreaded.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/09/10
 */
class FizzBuzz {
    private int n;
    private AtomicInteger counter;

    private Semaphore sem = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
        this.counter = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int val;
        while ((val = counter.get()) <= n) {
            sem.acquire();
            val = counter.get();
            if (val > n) {
                sem.release();
                break;
            }
            if (val % 3 == 0 && val % 5 != 0) {
                printFizz.run();
                val = counter.incrementAndGet();
            }
            sem.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int val;
        while ((val = counter.get()) <= n) {
            sem.acquire();
            val = counter.get();
            if (val > n) {
                sem.release();
                break;
            }
            if (val % 5 == 0 && val % 3 != 0) {
                printBuzz.run();
                val = counter.incrementAndGet();
            }
            sem.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int val;
        while ((val = counter.get()) <= n) {
            sem.acquire();
            val = counter.get();
            if (val > n) {
                sem.release();
                break;
            }
            if (val % 3 == 0 && val % 5 == 0) {
                printFizzBuzz.run();
                val = counter.incrementAndGet();
            }
            sem.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        int val;
        while ((val = counter.get()) <= n) {
            sem.acquire();
            val = counter.get();
            if (val > n) {
                sem.release();
                break;
            }
            int remainder3 = val % 3;
            int remainder5 = val % 5;
            if (remainder3 != 0 && remainder5 != 0) {
                printNumber.accept(val);
                val = counter.incrementAndGet();
            }
            sem.release();
        }
    }
}