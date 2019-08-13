import java.util.Scanner;

/**
 * Created by Cammi on 07/07/2017.
 */
public class Greeting {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();

        System.out.println("Hello, "+name+"!");
    }
}
