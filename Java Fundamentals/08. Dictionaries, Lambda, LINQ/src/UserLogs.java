import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();
        String[] input = console.nextLine().split("\\s+");

        String user, ip;

        while (!input[0].equals("end")){
            ip = input[0].substring(3,input[0].length());
            user = input[2].substring(5,input[2].length());

            logs.putIfAbsent(user,new LinkedHashMap<>());
            if (!logs.get(user).containsKey(ip)){
                logs.get(user).put(ip,1);
            } else {
                int oldCount = logs.get(user).get(ip);
                logs.get(user).put(ip,oldCount + 1);
            }

            input = console.nextLine().split("\\s+");
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : logs.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            boolean isFirst = true;
            for (Map.Entry<String,Integer> ipEntry : entry.getValue().entrySet()) {
                if (!isFirst){
                    System.out.print(", ");
                }
                System.out.printf("%s => %d", ipEntry.getKey(), ipEntry.getValue());
                isFirst = false;
            }
            System.out.println(".");
        }
    }
}
