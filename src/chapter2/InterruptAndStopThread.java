package chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class InterruptAndStopThread {
    public static void main(String args[]) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Current thread is interrupted!");
                        break;
                    }
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt(); // set interrupt flag again, since interrupting up from sleep clears interrupt flag.
                    }
                    System.out.println("Running!");
                    Thread.yield();
                }
            }
        };

        thread.start();
        Thread.sleep(2000);
        thread.interrupt();//trigger thread interruption
    }
}
