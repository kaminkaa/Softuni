import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        TreeMap<String, TreeMap<String, Integer>> logs = new TreeMap<>();

        String ip, name;
        int duration;

        for (int i = 0; i < n; i++) {
            String[] input = console.nextLine().split("\\s+");
            ip = input[0];
            name = input[1];
            duration = Integer.parseInt(input[2]);

            logs.putIfAbsent(name, new TreeMap<>());
            if (!logs.get(name).containsKey(ip)) {
                logs.get(name).put(ip, duration);
            } else {
                int oldDuration = logs.get(name).get(ip);
                logs.get(name).put(ip,oldDuration + duration);
            }
        }

        int totalDuration;

        for (Map.Entry<String, TreeMap<String, Integer>> entry : logs.entrySet()){
            System.out.printf("%s:",entry.getKey());
            totalDuration = 0;

            for (Map.Entry<String, Integer> subentry : entry.getValue().entrySet()){
                totalDuration += subentry.getValue();
            }
            System.out.printf(" %d ", totalDuration);

            System.out.printf("[");

            boolean isMoreThanOne = false;
            for (Map.Entry<String, Integer> subentry : entry.getValue().entrySet()){
                if (!isMoreThanOne){
                    System.out.printf("%s", subentry.getKey());
                    isMoreThanOne = true;
                } else {
                    System.out.printf(", %s", subentry.getKey());
                }
            }

            System.out.printf("]\n");
        }
    }
}
