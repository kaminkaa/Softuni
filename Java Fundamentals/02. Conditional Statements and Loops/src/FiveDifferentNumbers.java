import java.util.Scanner;

/**
 * Created by Cammi on 24/09/2017.
 */
public class FiveDifferentNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = Integer.parseInt(console.nextLine());
        int b = Integer.parseInt(console.nextLine());

        int n1 = a + 1;
        int n2 = a + 2;
        int n3 = a + 3;
        int n4 = a + 4;
        int n5 = a + 5;

        boolean condition = false;

        if(a<=n1 && n1<n2 && n2<n3 && n3<n4 && n4<n5 && n5<=b){
            condition = true;
        }

        if(condition == false){
            System.out.printf("No");
        } else {

        }

    }
}
