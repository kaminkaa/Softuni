import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        Pattern genomePattern = Pattern.compile("([!@#$\\?a-z]+)(=[\\d]+)(--[\\d]+)(<<[a-z]+)");

        Map<String,Integer> organismsGenomes = new LinkedHashMap<>();

        while (!"Stop!".equals(line)){
            Matcher matcher = genomePattern.matcher(line);
            if(matcher.find()){
                if (lengthMatches(matcher.group(1),matcher.group(2))){
                    int genomes = Integer.parseInt(matcher.group(3).substring(2));
                    String organism = matcher.group(4).substring(2);

                    if (organismsGenomes.containsKey(organism)){
                        organismsGenomes.put(organism,organismsGenomes.get(organism)+genomes);
                    } else {
                        organismsGenomes.put(organism,genomes);
                    }
                }
            }
            line = reader.readLine();
        }

        Comparator<Map.Entry<String,Integer>> compareByGenomes = Comparator.comparing(kvp -> kvp.getValue(),Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();

        organismsGenomes.entrySet().stream()
                .sorted(compareByGenomes)
                .forEach(kvp -> sb.append(kvp.getKey()).append(" has genome size of ").append(kvp.getValue()).append("\n"));

        System.out.println(sb.toString());
    }

    private static boolean lengthMatches(String nameGroup, String lengthGroup) {
        int  lettersCount = 0;
        for (int i = 0; i < nameGroup.length(); i++) {
             if(nameGroup.charAt(i) != '!' && nameGroup.charAt(i) != '@' && nameGroup.charAt(i) != '#' && nameGroup.charAt(i) != '$' && nameGroup.charAt(i) != '?') {
                 lettersCount++;
             }
        }
        int length = Integer.parseInt(lengthGroup.substring(1));

        return lettersCount == length;
    }
}
