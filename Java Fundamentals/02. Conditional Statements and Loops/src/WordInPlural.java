import java.util.Scanner;

/**
 * Created by Cammi on 23/09/2017.
 */
public class WordInPlural {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String word = console.nextLine();

        String wordinplural = "0";

        if (word.charAt(word.length() - 1) == 'y') {
            wordinplural = word.substring(0,word.length()-1) + "ies";
        } else if (word.charAt(word.length() - 1) == 'o' || word.endsWith("ch") || word.charAt(word.length() - 1) == 's' ||
                word.endsWith("sh") || word.charAt(word.length() - 1) == 'x' || word.charAt(word.length() - 1) == 'z'){
            wordinplural = word + "es";
        } else {
            wordinplural = word + "s";
        }

        System.out.println(wordinplural);

    }
}
