import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input;
        LinkedHashMap<String,Integer> keymaterials = new LinkedHashMap<>();
        keymaterials.put("fragments",0);
        keymaterials.put("motes",0);
        keymaterials.put("shards",0);
        LinkedHashMap<String,Integer> junkitems = new LinkedHashMap<>();

        String material;
        int quantity;
        String legendItem = "";
        boolean isLegendItemFound = false;

        while (true){
            if (isLegendItemFound){
                break;
            }

            input = console.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < input.length - 1; i+=2) {
                quantity = Integer.parseInt(input[i]);
                material = input[i+1];

                if (material.equals("motes") || material.equals("shards") || material.equals("fragments")) {
                        keymaterials.replace(material,keymaterials.get(material) + quantity);
                } else {
                    if (junkitems.containsKey(material)){
                        junkitems.put(material,junkitems.get(material) + quantity);
                    } else {
                        junkitems.put(material,quantity);
                    }
                }

                if (keymaterials.get(material)!= null && keymaterials.get(material) >= 250){
                    keymaterials.replace(material,keymaterials.get(material) - 250);

                    switch (material){
                        case "shards": legendItem = "Shadowmourne";
                            break;
                        case "motes": legendItem = "Dragonwrath";
                            break;
                        case "fragments": legendItem = "Valanyr";
                            break;
                    }
                    isLegendItemFound = true;
                    break;
                }
            }
        }

        System.out.printf("%s obtained!\n", legendItem);

        keymaterials.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .forEach(a -> System.out.printf("%s: %d\n", a.getKey(), a.getValue()));

        junkitems.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(a -> System.out.printf("%s: %d\n", a.getKey(), a.getValue()));
    }
}
