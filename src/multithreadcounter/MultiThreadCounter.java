/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multithreadcounter;

/**
 *
 * @author Lenovo-User
 */
public class MultiThreadCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Create three threads with different priorities
        Thread counter1 = new Thread(new Counter(5, 5), "Counter 1");
        counter1.setPriority(Thread.NORM_PRIORITY + 1);

        Thread counter2 = new Thread(new Counter(10, 10), "Counter 2");
        counter2.setPriority(Thread.NORM_PRIORITY);

        Thread counter3 = new Thread(new Counter(100, 100), "Counter 3");
        counter3.setPriority(Thread.NORM_PRIORITY - 1);

        // Start the threads
        counter1.start();
        counter2.start();
        counter3.start();
    }
}

class Counter implements Runnable {
    private int start;
    private int step;

    public Counter(int start, int step) {
        this.start = start;
        this.step = step;
    }

    @Override
    public void run() {
        int count = start;
        while (count <= 1000) {
            System.out.println(Thread.currentThread().getName() + ": " + count);
            count += step;

            try {
                // Let other threads execute
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    
    

