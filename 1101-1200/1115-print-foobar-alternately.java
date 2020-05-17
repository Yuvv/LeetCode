import java.util.concurrent.Semaphore;

/*
 * 1115-print-foobar-alternately.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/05/17
 */
class FooBar {
    private int n;

    private final Semaphore fooSemaphore;
    private final Semaphore barSemaphore;

    public FooBar(int n) {
        this.n = n;
        fooSemaphore = new Semaphore(1);
        barSemaphore = new Semaphore(1);
        try {
            barSemaphore.acquire();
        } catch (Exception e) {
            // nothing to do
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            fooSemaphore.release();
        }
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Argument `n` required");
            return;
        }
        int n = Integer.parseInt(args[0]);
        Runnable fooPrinter = () -> System.out.print("foo");
        Runnable barPrinter = () -> System.out.print("bar");

        FooBar foobar = new FooBar(n);
        Thread fooThread = new Thread(new Runnable() {
            public void run() {
                try {
                    foobar.foo(fooPrinter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread barThread = new Thread(new Runnable() {
            public void run() {
                try {
                    foobar.bar(barPrinter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        fooThread.start();
        barThread.start();

        fooThread.join();
        barThread.join();
    }
}