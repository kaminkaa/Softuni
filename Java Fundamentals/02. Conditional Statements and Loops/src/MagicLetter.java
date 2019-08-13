import java.util.Scanner;

/**
 * Created by Cammi on 24/09/2017.
 */
public class MagicLetter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        char c1 = console.next().charAt(0);
        char c2 = console.next().charAt(0);
        char c3 = console.next().charAt(0);

        for (char ch=c1; ch<=c2; ch++){
            for (char chh=c1; chh<=c2; chh++){
                for (char chhh=c1; chhh<=c2; chhh++){
                    if (chhh!=c3 && chh!=c3 && ch!=c3){
                        System.out.printf("%c%c%c ", ch, chh, chhh);
                    }
                }
            }
        }
    }
}
