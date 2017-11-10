/**
 * Java. Level 2. Lesson 5. HomeWork5
 * 1. Необходимо написать два метода, которые делают следующее:
 *    1) Создают одномерный длинный массив, например: 
 *        static final int size = 10000000;
 *        static final int h = size / 2;
 *        float[] arr = new float[size];
 *    2) Заполняют этот массив единицами;
 *    3) Засекают время выполнения: long a = System.currentTimeMillis();
 *    4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 *        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 *    5) Проверяется время окончания метода System.currentTimeMillis();
 *    6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 *    Отличие первого метода от второго:
 *        Первый просто бежит по массиву и вычисляет значения.
 *    Второй разбивает массив на два массива, в двух потоках высчитывает 
 *        новые значения и потом склеивает эти массивы обратно в один.
 *    Пример деления одного массива на два:
 *        System.arraycopy(arr, 0, a1, 0, h);
 *        System.arraycopy(arr, h, a2, 0, h);
 *    Пример обратной склейки:
 *        System.arraycopy(a1, 0, arr, 0, h);
 *        System.arraycopy(a2, 0, arr, h, h);
 *    Примечание:
 *        System.arraycopy() – копирует данные из одного массива в другой:
 *        System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, 
 *        массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
 *    По замерам времени:
 *        Для первого метода надо считать время только на цикл расчета:
 *            for (int i = 0; i < size; i++) {
 *                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 *            }
 *        Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 *
 * @author Anton Simagin
 * @version dated Nov 8, 2017
 * @task 5
 * @mark
 */
import java.util.*;

class HomeWork5 {
    private static final int size = 10000000;
    private static float[] arr = new float[size];
    private static float[] arr1 = new float[size];
    public static final int h = size / 2;
 
    public static void main(String[] args) {        
        firstMethod();
        secondMethod();
        arraysEquals();
    }

    private static void firstMethod() {
        long delta;

        for(int i = 0; i < arr.length; i++)
            arr[i] = 1;
        
        delta = System.currentTimeMillis(); 
        for(int i = 0; i < arr.length; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5)
                * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.out.println("First method time: " + (System.currentTimeMillis() - delta));
    }

    private static void secondMethod() {
        MyThread t1;
        MyThread t2;
        long delta;
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for(int i = 0; i < arr1.length; i++)
            arr1[i] = 1;

        delta = System.currentTimeMillis(); 
        System.arraycopy(arr1, 0, a1, 0, h);
        System.arraycopy(arr1, h, a2, 0, h);

        t1 = new MyThread("Thread #1", a1, 0);
        t2 = new MyThread("Thread #2", a2, h);
        try {
            t1.thread.join();
            t2.thread.join();
        } catch (InterruptedException ex) {
            System.out.println("main - interrupted");  
        }

        System.arraycopy(a1, 0, arr1, 0, h);
        System.arraycopy(a2, 0, arr1, h, h);       
        System.out.println("Second method time: " + (System.currentTimeMillis() - delta));
    }

    private static void arraysEquals() {
        if(Objects.deepEquals(arr, arr1))
            System.out.println("The Arrays are DEEP equals!");
        else
            System.out.println("The Arrays arent DEEP equals....");
    }
}

class MyThread implements Runnable {
    private float[] halfArray = new float[HomeWork5.h];
    private int firstElement;
    public Thread thread;
    
    MyThread(String name, float[] halfArray, int firstElement) {
        this.halfArray = halfArray;
        this.firstElement = firstElement;
        thread = new Thread(this, name);
        thread.start();
    }

    public void run() {
        for(int i = 0, j = firstElement; i < halfArray.length; i++, j++)
            halfArray[i] = (float)(halfArray[i] * Math.sin(0.2f + j / 5)
                * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
    }
}