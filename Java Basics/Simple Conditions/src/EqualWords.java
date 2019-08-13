import java.util.Scanner;

/**
 * Created by Cammi on 19/07/2017.
 */
public class EqualWords {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String word1 = console.nextLine();
        String word2 = console.nextLine();

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        if(word1.equals(word2)){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
