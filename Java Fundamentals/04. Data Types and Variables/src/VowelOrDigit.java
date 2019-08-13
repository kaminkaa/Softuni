import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class VowelOrDigit {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        char ch = console.next().charAt(0);

        if (Character.isDigit(ch)){
            System.out.printf("digit");
        } else if (ch=='a' || ch=='e' || ch=='o' || ch=='i' || ch=='u'){
            System.out.printf("vowel");
        } else {
            System.out.printf("other");
        }
    }
}
