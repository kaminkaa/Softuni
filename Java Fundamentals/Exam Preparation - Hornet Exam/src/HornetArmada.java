import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HornetArmada {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<String,Legion> legions = new LinkedHashMap<>();

        int lastActivty;
        long soldierCount;
        String legionName, soldierType;

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split(" = | -> |:");
            lastActivty = Integer.parseInt(info[0]);
            legionName = info[1];
            soldierType = info[2];
            soldierCount = Long.parseLong(info[3]);

            if (legions.containsKey(legionName)) {
                legions.get(legionName).AddSoldierType(soldierType,soldierCount);
                if (lastActivty > legions.get(legionName).getLastActivity()) {
                    legions.get(legionName).setLastActivity(lastActivty);
                }
            } else {
                Legion legion = new Legion(legionName,lastActivty);
                legion.soldiers.put(soldierType,soldierCount);

                legions.put(legionName,legion);
            }
        }

        String[] task = reader.readLine().split("[\\\\]");
        if (task.length == 2) {
            PrintActivitySoldierType(legions,Integer.parseInt(task[0]),task[1]);
        } else if (task.length == 1) {
            PrintSoldierType(legions,task[0]);
        }

    }

    static void PrintActivitySoldierType (Map<String,Legion> legions, int activity, String soldierType) {
        StringBuilder sb = new StringBuilder();

        Comparator<Map.Entry<String,Legion>> compareBySoldierCount
                = Comparator.comparing(e -> e.getValue().GetSoldierCountPerType(soldierType), Comparator.reverseOrder());

        legions.entrySet().stream()
                .filter(e -> e.getValue().getLastActivity() < activity
                            && e.getValue().CheckForSoldierType(soldierType))
                .sorted(compareBySoldierCount)
                .forEach(e -> {
                    sb.append(String.format("%s -> %d",e.getKey(),e.getValue().GetSoldierCountPerType(soldierType))).append(System.lineSeparator());
                });

        System.out.println(sb.toString());
    }

    static void PrintSoldierType (Map<String,Legion> legions, String soldierType) {
        StringBuilder sb = new StringBuilder();

        Comparator<Map.Entry<String,Legion>> compareByLastActivity
                = Comparator.comparing(e -> e.getValue().getLastActivity(), Comparator.reverseOrder());

        legions.entrySet().stream()
                .filter( e -> e.getValue().CheckForSoldierType(soldierType))
                .sorted(compareByLastActivity)
                .forEach(e -> {
                    sb.append(String.format("%d : %s",e.getValue().getLastActivity(), e.getKey())).append(System.lineSeparator());
                });

        System.out.println(sb.toString());
    }

    static class Legion {
        public String legionName;
        public int lastActivity;
        public Map<String,Long> soldiers;

        public Legion (String legionName, int lastActivity) {
            this.legionName = legionName;
            this.lastActivity = lastActivity;
            soldiers = new HashMap<>();
        }

        public void AddSoldierType (String soldierType, long soldierCount) {
            if (soldiers.containsKey(soldierType)) {
                long oldCount = soldiers.get(soldierType);
                soldiers.replace(soldierType, oldCount + soldierCount);
            } else {
                soldiers.put(soldierType, soldierCount);
            }
        }

        public boolean CheckForSoldierType (String soldierType) {
            if (soldiers.containsKey(soldierType)) {
                return true;
            } else {
                return false;
            }
        }

        public long GetSoldierCountPerType (String soldierType) {
            return soldiers.get(soldierType);
        }

        public void setLastActivity(int lastActivity) {
            this.lastActivity = lastActivity;
        }

        public int getLastActivity() {
            return lastActivity;
        }
    }
}
