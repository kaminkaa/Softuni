import java.util.Scanner;

/**
 * Created by Cammi on 23/07/2017.
 */
public class GroupName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String s1 = console.nextLine().toUpperCase();
        String s2 = console.nextLine().toLowerCase();
        String s3 = console.nextLine().toLowerCase();
        String s4 = console.nextLine().toLowerCase();
        int s5 = Integer.parseInt(console.nextLine());

        int count = 0;

        for (char c = 'A'; c<=s1.charAt(0); c++) {
            for (char m = 'a'; m<=s2.charAt(0); m++) {
                for (char n = 'a'; n<=s3.charAt(0); n++) {
                    for (char l = 'a'; l<=s4.charAt(0); l++) {
                        for (int i = 0; i<= s5; i++) {
                            count ++;
                        }
                    }
                }
            }
        }

        count--;
        System.out.println(count);

    }
}


