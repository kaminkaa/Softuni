import java.util.Scanner;

/**
 * Created by Cammi on 21/07/2017.
 */
public class SquareFrame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        System.out.printf("+ ");
        for(int i=0; i<n-2; i++){
            System.out.printf("- ");
        }
        System.out.println("+");

        for(int i=0; i<n-2; i++){
            System.out.printf("| ");
            for (int j=0; j<n-2; j++){
                System.out.printf("- ");
            }
            System.out.println("|");
        }

        System.out.printf("+ ");
        for(int i=0; i<n-2; i++){
            System.out.printf("- ");
        }
        System.out.println("+");
    }
}
