import java.util.Scanner;

/**
 * Created by Cammi on 21/07/2017.
 */
public class TriangleofDollars {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        for (int row=1; row<=n; row++){
            for(int col=1; col<=row; col++){
                System.out.printf("$ ");
            }
            System.out.println();
        }
    }
}
