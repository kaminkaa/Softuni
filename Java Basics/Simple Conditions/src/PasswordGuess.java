import java.util.Scanner;

public class PasswordGuess {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String inputPassword = console.nextLine();
        String secretPassword = "s3cr3t!P@ssw0rd";

        if(secretPassword.equals(inputPassword)){
            System.out.println("Welcome");
        } else {
            System.out.println("Wrong password!");
        }
    }
}
