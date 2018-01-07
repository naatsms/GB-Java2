import java.lang.*;
import java.util.*;

/**
 * Java. Level 2. Lesson 3. homework
 *
 * @author Savchuk Kirill
 * @version dated Nov 3, 2017
 */
class J2Lesson3 {
    public static void main(String[] args) {
        String[] Arr1 = {"Вася", "Петя", "Вася", "Рома", "Николай"};
        repeat(Arr1);
    }

    public static void repeat(String[] Arr2) {
        Set<String> set = new HashSet<String>(Arrays.asList(Arr2));
        System.out.println("Список уникальных элементов:");
        System.out.println(set);
        System.out.println("Список повторений:");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < Arr2.length; i++) {
            if (map.put(Arr2[i], map.get(Arr2[i])) == null) {
                map.put(Arr2[i], 1);
            } else map.put(Arr2[i], map.get(Arr2[i]) + 1);
        }
        System.out.println(map);
        Telephon book = new Telephon();
        book.addPhone("4767895","Savchuk");
        book.addPhone("89118499871","Ivanov");
        book.addPhone("89118400875","Petrov");
        book.addPhone("89118900876","Petrov");
        book.addPhone("89456400870","Ivanov");
        book.addPhone("89218456770","Ivanov");
        book.addPhone("89051234567","Sidorov");
        book.addPhone("89068456770","Sidorov");
        book.getPhone("Ivanov");
        book.getPhone("Petrov");
        book.getPhone("Savchuk");
        book.getPhone("Sidorov");
    }

}

class Telephon {
    private Map<String, String> map1 = new HashMap<String, String>();

    public void addPhone(String number, String surname ) {
        this.map1.put(number, surname);
    }

    public void getPhone(String surname) {
        Set<Map.Entry<String, String>> set = map1.entrySet();
        System.out.println("Все номера по фамилии " + surname + " :");
        for (Map.Entry<String, String> o : set)

            if(o.getValue() == surname) {
                System.out.println(o.getKey() + ": " + o.getValue());
            }
    }
}