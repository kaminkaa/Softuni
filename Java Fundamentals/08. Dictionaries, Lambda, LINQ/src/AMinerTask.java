import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        String resource = console.nextLine();

        while (!resource.equals("stop")){
            int quantity = Integer.parseInt(console.nextLine());

            if (resources.containsKey(resource)){
                resources.replace(resource,resources.get(resource)+quantity);
            } else {
                resources.put(resource,quantity);
            }
            resource = console.nextLine();
        }

        for (Map.Entry<String,Integer> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
