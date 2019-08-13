import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        Map<String,String> contestPasswords = new LinkedHashMap<>();
        while (!"end of contests".equals(line)){
            String[] tokens = line.split(":");
            contestPasswords.put(tokens[0],tokens[1]);
            line = reader.readLine();
        }

        line = reader.readLine();
        Map<String,Map<String,Integer>> userData = new LinkedHashMap<>();
        while (!"end of submissions".equals(line)){
            String[] tokens = line.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (contestIsValid(contest,password,contestPasswords)){
                if (!userData.containsKey(username)){
                    userData.put(username,new LinkedHashMap<>());
                }

                if (!userData.get(username).containsKey(contest)){
                    userData.get(username).put(contest,points);
                } else {
                    if (points > userData.get(username).get(contest)){
                        userData.get(username).put(contest,points);
                    }
                }
            }

            line = reader.readLine();
        }

        printBestStudent(userData);
        StringBuilder sb = new StringBuilder();
        sb.append("Ranking: \n");

        Comparator<Map.Entry<String,Map<String,Integer>>> compareByName
                = Comparator.comparing(kvp -> kvp.getKey());

        Comparator<Map.Entry<String,Integer>> compareContestsByPoints
                = Comparator.comparing(kvp -> kvp.getValue(), Comparator.reverseOrder());

        userData.entrySet().stream()
                .sorted(compareByName)
                .forEach(kvp -> {
                    sb.append(kvp.getKey()).append("\n");
                    kvp.getValue().entrySet().stream()
                            .sorted(compareContestsByPoints)
                            .forEach(cp -> sb.append("#  ").append(cp.getKey()).append(" -> ").append(cp.getValue()).append("\n"));
                });

        System.out.println(sb.toString());
    }

    private static boolean contestIsValid(String contest, String pass, Map<String,String> contests){
        if (!contests.containsKey(contest)){
            return false;
        } else if (!pass.equals(contests.get(contest))){
            return false;
        }

        return true;
    }

    private static void printBestStudent(Map<String,Map<String,Integer>> userData){
        String bestStudentName = "";
        int bestStudentPoints = 0;

        for (Map.Entry<String, Map<String, Integer>> user : userData.entrySet()) {
            int totalPoints = 0;
            for (Map.Entry<String,Integer> contests : user.getValue().entrySet()) {
                totalPoints += contests.getValue();
            }

            if (totalPoints > bestStudentPoints){
                bestStudentName = user.getKey();
                bestStudentPoints = totalPoints;
            }
        }

        System.out.println("Best candidate is " + bestStudentName + " with total " + bestStudentPoints + " points.");
    }
}
