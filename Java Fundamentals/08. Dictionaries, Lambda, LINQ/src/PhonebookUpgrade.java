import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");

        TreeMap<String,String> phonebook = new TreeMap<>();

        while (!input[0].equals("END")){
            switch (input[0]) {
                case "A":
                    if (phonebook.containsKey(input[1])){
                        phonebook.replace(input[1], input[2]);
                    } else {
                        phonebook.put(input[1], input[2]);
                    }
                    break;

                case "S":
                    if (phonebook.containsKey(input[1])){
                        System.out.println(input[1] + " -> " + phonebook.get(input[1]));
                    } else {
                        System.out.println("Contact " + input[1] + " does not exist." );
                    }
                    break;

                case "ListAll":
                    for (Map.Entry<String ,String> entry : phonebook.entrySet()) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                    break;
            }
            input = console.nextLine().split("\\s+");
        }
    }
}
