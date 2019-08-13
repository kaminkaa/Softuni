import java.util.Scanner;

/**
 * Created by Cammi on 21/07/2017.
 */
public class SquareofStars {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        for (int i=0; i<n; i++){
            System.out.println(repeatStr("* ",n));
        }
    }

    public  static String repeatStr (String str, int count){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<count; i++){
            sb.append(str);
        }
        return sb.toString();
    }
}
