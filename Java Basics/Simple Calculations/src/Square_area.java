import java.util.Scanner;

/**
 * Created by Cammi on 07/07/2017.
 */
public class Square_area {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = Integer.parseInt(console.nextLine());

        int square_area = a*a;
        System.out.println("Square area = " +square_area);
    }

}
