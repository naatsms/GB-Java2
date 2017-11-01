import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Java. Level 2. Lesson 3. My homework
 * @author Ilshat Nurgalimov
 * @version 01.11.2017.
 * @task 3
 * @mark
 */
public class MyHomework3 {
    static final String FILE_NAME1 = "C://JAVA/GB/Java2Lesson3Homework3.txt";
    static final String FILE_NAME2 = "Java2Lesson3Homework3.txt";

    /**
     * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
     * уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое
     * слово.
     * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
     * В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать
     * номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае
     * однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
     * Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще
     * дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль
     * желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
     */

    public static void main(String[] args) {
        // first homework item
        ArrayList<String> wordArray = new ArrayList<>();
        wordArray = ArrayOperation.fillTheArray(wordArray);
        System.out.println(wordArray + "\n");
        ArrayOperation.printUniqueWords(wordArray);
        wordArray.clear();
        try {
            wordArray = ArrayOperation.fillTheArrayFromFile(wordArray, FILE_NAME2);
        } catch (IOException e) {
            System.out.println("Failed to fill array from file!\n");
        }
        try {
            wordArray = ArrayOperation.fillTheArrayFromFile(wordArray, FILE_NAME1);
        } catch (IOException e) {
            System.out.println("Failed to fill array from file!\n");
        }
        System.out.println(wordArray + "\n");
        ArrayOperation.printUniqueWords(wordArray);
        // second homework item
        Phonebook phonebook = new Phonebook();

        phonebook.add(2304578, "Ivanov");
        phonebook.add(5678794, "Ivanov");
        phonebook.add(3456783, "Petrov");
        phonebook.add(3456278, "Sidorov");
        phonebook.add(9786053, "Sidorov");
        phonebook.add(6475893, "Sidorov");

        phonebook.get("Ivanov");
        phonebook.get("Petrov");
        phonebook.get("Sidorov");
        phonebook.get("Akulshin");
    }
}
