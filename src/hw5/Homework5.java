public class Homework5 {

    public static void main(String[] args) {
        Homework5 e1 = new Homework5();
        e1.method1();
        e1.method2();
    }

    public void method1 () {

        final int size = 10000000;
        float arr[] = new float[size];

        System.out.println("Create array1. Put 1 into each [i].");
        for(int i = 0; i<arr.length; i++) {
            arr[i]=1;
        }

        System.out.println("Make Math");
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<arr.length; i++) {
            arr[i]=(float)(arr[i] * Math.sin(0.2f+ i/5)* Math.cos(0.2f+ i/5) * Math.cos(0.4f + i/2));
        }
        long fintime = System.currentTimeMillis();

        long elapsedtime = fintime - startTime;
        System.out.println("Finish time: " + elapsedtime);

    }

    public void method2 () {

        final int size = 10000000;
        final int size2 = size /2;
        float arr[] = new float[size];
        float a1[] = new float[size2];
        float a2[] = new float[size2];

        System.out.println("Create array2. Put 1 into each [i].");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        System.out.println("Make 2 new arrays 'a1' , 'a2'.");
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr,0,a1,0,size2);
        System.arraycopy(arr,size2,a2,0, size2);

        try {
            System.out.println("Waiting for threads.");
            MyThread mt1 = new MyThread("Child #1", a1);
            MyThread2 mt2 = new MyThread2("Child #2", a2);
            mt1.thread.join();
            mt2.thread.join();
        }
        catch (InterruptedException e) {
            System.out.println("Error");
        }

            System.out.println("Assamble arr");
            System.arraycopy(a1, 0, arr, 0, size2);
            System.arraycopy(a2, 0, arr, size2, size2);

        long fintime = System.currentTimeMillis();
        long elapsedtime = fintime - startTime;

        System.out.println("Finish time: " + elapsedtime);

    }
}


class MyThread implements Runnable {
    Thread thread;
    static Math1 m1 = new Math1();
    float arr[];

    MyThread(String name, float[] arr) {
     thread = new Thread(this, name);
        this.arr = arr;
        thread.start();
    }

    public void run() {

        System.out.println(thread.getName() + " is started.");
        arr = m1.math1(arr);
        System.out.println(thread.getName() + " is complete.");
    }

}

class Math1 {
      float arr[];
    float[] math1(float[] nums) {
        for(int i = 0; i<nums.length; i++) {
            nums[i]=(float)(nums[i] * Math.sin(0.2f+ i/5)* Math.cos(0.2f+ i/5) * Math.cos(0.4f + i/2));
        }

        return arr;
    }
}

class MyThread2 implements Runnable {
    Thread thread;
    static Math2 m2 = new Math2();
    float arr[];

    MyThread2(String name, float[] arr) {
        thread = new Thread(this, name);
        this.arr = arr;
        thread.start();
    }

    public void run() {

        System.out.println(thread.getName() + " is started.");
        arr = m2.math2(arr);
        System.out.println(thread.getName() + " is complete.");
    }

}

class Math2 {
    float arr[];
    float[] math2(float[] nums) {
        for(int i = 0 , j = 5000000; i<nums.length; i++ ,j++) {
            nums[i]=(float)(nums[i] * Math.sin(0.2f+ j/5)* Math.cos(0.2f+ j/5) * Math.cos(0.4f + j/2));
        }

        return arr;
    }
}