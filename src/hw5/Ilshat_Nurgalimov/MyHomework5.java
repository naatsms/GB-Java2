/**
 *
 * Java 2. Lesson 5. My homework.
 * @author Ilshat Nurgalimov
 * @version dated 08.11.2017.
 * @task 5
 * @mark
 */
public class MyHomework5 {
    private static final int size = 10000000;
    private static final int h = size / 2;


    public static void main(String[] args) {
        createAndPopulateAnArray();
        createAndPopulateAnArrayUsingThreads();
        System.out.println("Main exit.");
    }
    public static void createAndPopulateAnArray() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println("The first method took: " + (b - a) + " milliseconds.");
    }
    public static void createAndPopulateAnArrayUsingThreads() {
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        for (int i = 0; i < size; i++) arr[i] = 1.0f;

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h - 1, arr2, 0, h);
        MyThread t1 = new MyThread("Thread-1", arr1);
        MyThread t2 = new MyThread("Thread-2", arr2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(t1.arr, 0, arr, 0, h);
        System.arraycopy(t2.arr, 0, arr, h - 1, h);
        long b = System.currentTimeMillis();
        System.out.println("The second method took: " + (b - a) + " milliseconds.");
    }
}

class MyThread extends Thread {
    float[] arr;

    MyThread(String name, float[] arr) {
        super(name);
        this.arr = arr;
    }

    @Override
    public void run() {
        System.out.println("Start " + getName());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
