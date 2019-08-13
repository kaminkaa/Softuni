import java.util.Scanner;

/**
 * Created by Cammi on 24/09/2017.
 */
public class GameOfNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        int m = Integer.parseInt(console.nextLine());
        int magicalnumber = Integer.parseInt(console.nextLine());

        int sum = 0;
        int count = 0;
        int nmagic = 0;
        int mmagic = 0;

        for (int i=n; i<=m; i++){
            if (sum==magicalnumber){
                break;
            }

            for (int j=n; j<=m; j++){
                sum = i + j;
                count++;
                if (sum==magicalnumber){
                    nmagic = j;
                    mmagic = i;
                    break;
                }
            }
        }

        if (sum==magicalnumber){
            System.out.printf("Number found! %d + %d = %d", nmagic,mmagic,magicalnumber);
        } else {
            System.out.printf("%d combinations - neither equals %d", count, magicalnumber);
        }
    }
}
