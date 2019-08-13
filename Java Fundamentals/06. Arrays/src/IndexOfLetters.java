import java.util.Scanner;

public class IndexOfLetters {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
        'q','r','s','t','u','v','w','x','y','z'};

        for (int i=0; i<input.length(); i++){
            for (int j=0; j<26; j++){
                if (input.charAt(i) == alphabet[j]){
                    System.out.println(input.charAt(i) + " -> " + j);
                }
            }
        }
    }
}
