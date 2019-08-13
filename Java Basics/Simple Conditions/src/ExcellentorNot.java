import java.util.Scanner;

/**
 * Created by Cammi on 18/07/2017.
 */
public class ExcellentorNot {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double grade = Double.parseDouble(console.nextLine());

        if(grade>=5.50){
            System.out.println("Excellent!");
        } else {
            System.out.println("Not excellent.");
        }
    }
}
