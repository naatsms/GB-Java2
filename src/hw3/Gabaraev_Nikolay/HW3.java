 /*
 * @author Nikolay Gabaraev
 * @version dated Nov 03, 2017
 * @task 3
 * @mark
 */

import java.util.*;

public class HW3 {

    public static void main(String[] args) {

        WordList();

       Phonebook ph = new Phonebook();
       ph.add("+7(916)-888-22-12", "Петров");
        ph.add("+7(916)-999-33-13", "Иванов");
        ph.add("+7(916)-222-33-12", "Сидоров");
        ph.add("+7(916)-333-23-17", "Иванов");
        ph.add("+7(916)-555-66-33", "Яковлев");
        ph.get();
        ph.getName("Яковлев");
        ph.getName("Иванов");
        
    }

   static void WordList() {
        int i = 1;
        int j = 1;
       ArrayList<String> list = new ArrayList<String>();
        list.add("Яблоко");
        list.add("Апельсин");
        list.add("Манго");
        list.add("Ананас");
        list.add("Мандарин");
        list.add("Банан");
        list.add("Яблоко");
        list.add("Финик");
        list.add("Арбуз");
        list.add("Дыня");
        list.add("Манго");
        list.add("Киви");
        list.add("Курага");
        list.add("Инжир");
        list.add("Яблоко");

        System.out.println("============= Создаем список =============");
        for(Object o : list) {
            System.out.println("Item ?:" + i + " " + o);
            i++;
        }

      HashSet<String> hs = new HashSet<>(list);
        System.out.println("============= Исключаем повторения =============");
        for(Object o : hs) {
            System.out.println("Item ?:" + j + " " + o);
            j++;
        }

        System.out.println("============= Считаем слова =============");
        for(Object o : hs) {
            int y = 0;
            for(Object d : list){
                if( o == d) {
                    y++;
                }
                }
            System.out.println(o + " присутствует в списке " + y + " раз");
            }

        }
}

   class Phonebook {

          private Map<String, String> ph = new HashMap<String, String>();
          private String name;
          private String telNum;

          public  String add (String telNum, String name) {
              ph.put(telNum, name);
              return (name);
          }

           public void get () {
               System.out.println("============= Создаем справочник =============");
               Set<Map.Entry<String, String>> set = ph.entrySet();
               for (Map.Entry<String, String> o : set)
                   System.out.println(o.getKey() + ": " + o.getValue());
           }

           public  void getName(String name) {
               System.out.println("============= Поиск по списку =============");
               Set<Map.Entry<String, String>> set = ph.entrySet();
               for (Map.Entry<String, String> o : set)
                   if( name == o.getValue()) {
                       System.out.println(o.getKey() + ": " + o.getValue());
                   }

           }
     }