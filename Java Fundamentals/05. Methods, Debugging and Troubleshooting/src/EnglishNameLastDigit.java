import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class EnglishNameLastDigit {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String num = console.nextLine();
        System.out.println(EnglishNameOfLastDigit(num));
    }

    public static String EnglishNameOfLastDigit (String number){
        char lastDigit = number.charAt(number.length()-1);
        String digitName;

        switch (lastDigit){
            case '1' : digitName = "one";
            break;
            case '2' : digitName = "two";
            break;
            case '3' : digitName = "three";
            break;
            case '4' : digitName = "four";
            break;
            case '5' : digitName = "five";
            break;
            case '6' : digitName = "six";
            break;
            case '7' : digitName = "seven";
            break;
            case '8' : digitName = "eight";
            break;
            case '9' : digitName = "nine";
            break;
            default: digitName = "zero";
            break;
        }
        return digitName;
    }
}
