import java.util.Scanner;

/**
 * Created by Cammi on 11/07/2017.
 */
public class ConcatenateData {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String firstName = console.nextLine();
        String lastName = console.nextLine();
        int age = Integer.parseInt(console.nextLine());
        String town = console.nextLine();

        System.out.println("You are "+firstName+" "+lastName+", a "+age+"-years old person from "+town+".");
    }
}
