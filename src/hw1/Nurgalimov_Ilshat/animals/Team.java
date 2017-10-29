package animals;
import java.util.*;
/**
 * class Team.
 *
 * @author Ilshat Nurgalimov
 * @version 25.10.2017
 */
public class Team {
    /**
     * 2. Добавить класс Team, который будет содержать: название команды, массив из 4-х участников 
     * (т.е. в конструкторе можно сразу всех участников указывать), метод для вывода информации о 
     * членах команды прошедших дистанцию, метод вывода информации обо всех членах команды.
     */
    private String nameTeam = "unknown";
    Animal[] zoo = {new Cat("Murzik"), new Hen("Izzy"), new Hippo("Hippopo")};
    public Animal[] teamAnimal = new Animal[4];
    Random random = new Random();
    // Формируем команду
    public Team(String nameTeam) {
        this.nameTeam = nameTeam;
        for(int i = 0; i < 4; i++){
            int ran = random.nextInt(3);
            teamAnimal[i] = zoo[ran];
        }
    }
    // Вывод информации о членах команды
    public void informationAboutTheTeam() {
        System.out.println("Team: " + nameTeam);
        for(Animal a : teamAnimal) {
            System.out.println(a);
            System.out.println("Run limit: " + a.run_limit);
            if (a instanceof Swimable)
                System.out.println("Swim limit: " + ((Swimable) a).getSwimLimit());
            if (a instanceof Jumpable)
                System.out.println("Jump limit: " + ((Jumpable) a).getJumpLimit());
        }
        System.out.println();
    }
    // Вывод информации кто прошел дистанцию
    public void passedTheDistance(){
        System.out.println(nameTeam + "\n");
        for (Animal a : teamAnimal){
            if(a.passing){
                System.out.println(a + " successfully passed the distance.\n");
            } else {
                System.out.println(a + " did not pass the distance.\n");
            }
        }
        System.out.println();
    }
}