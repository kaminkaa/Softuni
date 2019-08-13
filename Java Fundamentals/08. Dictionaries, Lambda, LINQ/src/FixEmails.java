import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();
        String name = console.nextLine();

        while (!name.equals("stop")) {
            String email = console.nextLine();
            String domain = email.substring(email.length()-2, email.length());

            if (!domain.equals("us") && !domain.equals("uk")){
                emails.put(name,email);
            }

            name = console.nextLine();
        }

        for (Map.Entry<String,String> entry : emails.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
