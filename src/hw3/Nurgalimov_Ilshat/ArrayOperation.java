import java.io.*;
import java.util.*;

public class ArrayOperation {

    public static ArrayList fillTheArray(ArrayList array) {
        array.add("hello");
        array.add("Hello");
        array.add("car");
        array.add("boy");
        array.add("world");
        array.add("World");
        array.add("hi");
        array.add("bye");
        array.add("Bye");
        array.add("bye");
        return array;
    }
    public static ArrayList fillTheArrayFromFile(ArrayList array, String fileName) throws IOException {
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            buffer.append(reader.readLine() + "\n");
        }
        if(buffer.length() > 0) {
            String[] tempArr = buffer.toString().split(" ");
            for (String temp : tempArr) {
                array.add(temp);
            }
        }
        return array;
    }

    public static void printUniqueWords(ArrayList<String> array) {
        Set<String> tempArray = new TreeSet<>();
        for (String arr : array) {
            String a = arr.toLowerCase();
            tempArray.add(a);
        }
        for (String tempArr : tempArray) {
            int count = 0;
            for (String arr : array) {
                String a = arr.toLowerCase();
                if(tempArr.equals(a)) count++;
            }
            System.out.println("\"" + tempArr + "\"" + " repeated in the list = " + count);
        }
        System.out.println();
    }
}
