import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;

/**
 *
 * Java. Level 2. Lesson 2. My homework
 * @author Ilshat Nurgalimov
 * @version 28.10.2017.
 * @task 2
 * @mark
 */

public class HW2 {
    /**
     *
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого
     * размера необходимо бросить исключение ArrayIndexOutOfBoundsException.
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
     * элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     * должно быть брошено исключение ArithmeticException, с детализацией в какой именно ячейке лежат неверные данные.
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения ArithmeticException и
     * ArrayIndexOutOfBoundsException, и вывести результат расчета.
     * 4. * Вариант повышенной сложности: данные берутся из текстового файла.
     */
    private static int indexArray1;
    private static int indexArray2;

    public static void main(String[] args) {
        String[][] wrongSizeArray = new String[3][5];
        String[][] notNumberArray = new String[4][4];
        notNumberArray = fillTheArray(notNumberArray);
        notNumberArray[2][1] = "A";
        String[][] array = new String[4][4];
        array = fillTheArray(array);
        String[][] textArray = new String[4][4];
        try {
            textArray = fillTheArrayFromTheFile(textArray);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                //System.out.println(sumOfNumbers(wrongSizeArray));
                //System.out.println(sumOfNumbers(notNumberArray));
                System.out.println(sumOfNumbers(array));
                System.out.println(sumOfNumbers(textArray));
            } catch(ArrayIndexOutOfBoundsException ex) {
                System.out.println("Not the correct size of the array!");
            } catch(ArithmeticException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("End of program execution!");
    }

    public static int sumOfNumbers(String[][] array) throws ArrayIndexOutOfBoundsException, ArithmeticException {
        if(array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 ||
                array[3].length != 4) throw new ArrayIndexOutOfBoundsException();
        try {
            return convertStringToNumberAndAdd(array);
        } catch (NumberFormatException exception){
            throw new ArithmeticException("In the cell is not a number, a cell index [" + indexArray1 + "] ["
                    + indexArray2 + "]");
        }
    }
    public static String[][] fillTheArray(String [][] arr) {
        int a = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                arr[i][j] = Integer.toString(a);
                a++;
            }
        }
        return arr;
    }
    public static String[][] fillTheArrayFromTheFile(String [][] arr) throws IOException {
        int b;
        FileReader file = new FileReader("C://JAVA/GB/Java2/2/HW2/src/text.txt");
        char text = ' ';
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                String s = "";
                while ((b = file.read()) != -1){
                    if(text == (char)b){
                        break;
                    }else{
                        s += Character.toString((char)b);
                    }
                }
                arr[i][j] = s;
            }
        }
        file.close();
        return arr;
    }
    public static int convertStringToNumberAndAdd(String [][] arr) throws NumberFormatException {
        int amount = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                indexArray1 = i;
                indexArray2 = j;
                amount += parseInt(arr[i][j]);
            }
        }
        return amount;
    }
}