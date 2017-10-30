import animals.*;
import obstances.*;
/**
 * Java. Level 2. Lesson 1. My homework.
 *
 * @author Sergey Irupin
 * @modified Ilshat Nurgalimov
 * @version 25.10.2017
 */
public class Main {

    public static void main(String[] args) {
        Team team1 = new Team("Shariki");
        team1.printInformationAboutTheTeam();
        Team team2 = new Team("Loshariki");
        team2.printInformationAboutTheTeam();
        Course course = new Course();
        course.printInformationAboutTheObstacle();
        course.passObstacles(team1);
        course.passObstacles(team2);
        team1.passedTheDistance();
        team2.passedTheDistance();
    }
}