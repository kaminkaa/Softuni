import java.util.Scanner;

/**
 * Created by Cammi on 21/09/2017.
 */
public class DebitCardNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n1 = Integer.parseInt(console.nextLine());
        int n2 = Integer.parseInt(console.nextLine());
        int n3 = Integer.parseInt(console.nextLine());
        int n4 = Integer.parseInt(console.nextLine());

        System.out.printf("%04d %04d %04d %04d", n1, n2, n3, n4);
    }
}
