import java.util.Scanner;

/**
 * Created by Cammi on 24/09/2017.
 */
public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        int i,j;

        for (i=1; i<=n; i++){
            for (j=1; j<=i; j++){
                System.out.printf("%d ",i);
            }
            System.out.println();
        }
    }
}
