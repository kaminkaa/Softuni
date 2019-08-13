import java.util.Scanner;

/**
 * Created by Cammi on 02/10/2017.
 */
public class VariableInHexFormat {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String hex = console.nextLine().trim();

        System.out.println(Integer.decode(hex));
    }
}
