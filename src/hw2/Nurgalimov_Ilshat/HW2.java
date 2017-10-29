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

    public static void main(String[] args) {

        String[][] wrongSizeArray = new String[3][5];
        System.out.println(convertStringToNumber(wrongSizeArray));

        String[][] notNumberArray = new String[4][4];
        System.out.println(convertStringToNumber(notNumberArray));

        String[][] array = new String[4][4];
        int a = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                array[i][j] = Integer.toString(a);
                a++;
            }
        }
        System.out.println(convertStringToNumber(array));

        String[][] textArray = new String[4][4];
        try {
            int b;
            FileReader file = new FileReader("text.txt");
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
                    textArray[i][j] = s;
                }
            }
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(convertStringToNumber(textArray));
    }

    public static String convertStringToNumber(String[][] array) {
        int sum = 0;
        try {
            if(array.length != 4 || array[0].length != 4) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j < 4; j++) {
                        if(isDigit(array[i][j])) {
                            sum += parseInt(array[i][j]);
                        } else {
                            throw new ArithmeticException("Inside the cell is not the number! " +
                                    "Cell array [" + i + "] [" + j + "]");
                        }
                    }
                }
            }
            return "Sum of numbers = " + sum;
        } catch(ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
            return "Invalid array size!";
        } catch (ArithmeticException exception) {
            exception.printStackTrace();
            return "Not a number!";
        }
    }

    public static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}