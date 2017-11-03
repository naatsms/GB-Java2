import java.lang.*;
/**
 * Java. Level 2. Lesson 2. homework
 *
 * @author Savchuk Kirill
 * @version dated Okt 30, 2017
 */
public class J2Lesson2 {
    public static void main(String[] args) {
        String[][] Arr1 = {{"1", "1", "1m","1"}, {"1", "n1", "1", "1"},
                {"1mm", "1", "1","jhkh"},{"1", "1kj", "1", "1"}};
        try {
            System.out.println(arra(Arr1));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
    }

    public static String arra(String[][] Arr2){
       if(Arr2.length != 4 || Arr2[0].length != 4 || Arr2[1].length != 4 ||
               Arr2[2].length != 4 || Arr2[3].length != 4){
           throw new ArrayIndexOutOfBoundsException();
        }else{
           String result = "";
           int sum = 0;
           for(int i = 0; i < Arr2.length; i++){
               for(int j = 0; j< Arr2.length; j++){
                   try{
                       sum += Integer.parseInt(Arr2[i][j]);
                   }catch(java.lang.NumberFormatException e){
                       result += "  ArithmeticException Array[" + i + "]" + "[" + j  + "]";
                   }
               }
           }
           result += "  Summa: " + sum;
           return result;
        }
    }
}