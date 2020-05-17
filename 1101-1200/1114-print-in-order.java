import java.util.concurrent.CountDownLatch;

/*
 * 1114-print-in-order.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/05/17
 */
public class Foo {

    final CountDownLatch firstLatch;
    final CountDownLatch secondLatch;

    public Foo() {
        firstLatch = new CountDownLatch(1);
        secondLatch = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        firstLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstLatch.await();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        secondLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondLatch.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new PrintString("first"));
                } catch (InterruptedException e) {
                    //
                }
            }
        });
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(new PrintString("second"));
                } catch (InterruptedException e) {
                    //
                }
            }
        });
        Thread thirdThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(new PrintString("third"));
                } catch (InterruptedException e) {
                    //
                }
            }
        });

        thirdThread.start();
        firstThread.start();
        secondThread.start();

        thirdThread.join();
        secondThread.join();
        firstThread.join();
    }
}

class PrintString implements Runnable {

    private String str;

    public PrintString(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        System.out.print(str);
    }
}
