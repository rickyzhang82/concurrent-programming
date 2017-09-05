package chapter4;

/**
 * Created by 13 on 2017/5/6.
 */
public class DeadLock extends Thread {
    protected Object tool;
    static Object fork1 = new Object();
    static Object fork2 = new Object();

    public DeadLock(Object object) {
        this.tool = object;

        if (tool == fork1) {
            this.setName("Philosopher A");
        }
        if (tool == fork2) {
            this.setName("Philosopher B");
        }
    }

    public void run() {
        if (tool == fork1) {
            synchronized (fork1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (fork2) {
                    System.out.println("Philosopher A is eating now.");
                }
            }
        }
        if (tool == fork2) {
            synchronized (fork2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (fork1) {
                    System.out.println("Philosopher B is eating now.");
                }
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        DeadLock philosopherA = new DeadLock(fork1);
        DeadLock philosopherB = new DeadLock(fork2);

        philosopherA.start();
        philosopherB.start();

        Thread.sleep(1000);
    }
}
