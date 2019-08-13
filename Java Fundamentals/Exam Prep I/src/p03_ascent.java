import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, String> foundPatterns = new LinkedHashMap<String, String>();
        String inputLine = "";
        Pattern cypherPattern = Pattern.compile("(\\,|\\_)([a-zA-Z]+)(\\d)");

        String line = reader.readLine();

        while (!"Ascend".equalsIgnoreCase(line)){

            for (Map.Entry<String, String> stringStringEntry : foundPatterns.entrySet()) {
                line = line.replaceAll(stringStringEntry.getKey(), stringStringEntry.getValue());
            }

            Matcher matcher = cypherPattern.matcher(line);

            while (matcher.find()){
             String decodedLine = decode(matcher.group(1),
                     matcher.group(2), Integer.parseInt(matcher.group(3)));

             line = line.replaceAll(matcher.group(0), decodedLine);
             foundPatterns.put(matcher.group(0), decodedLine);
            }

            System.out.println(line);
            line = reader.readLine();
        }
    }

    private static String decode(String sign, String encodedString, int digit) {
        String decodedString = "";

        for (int i = 0; i < encodedString.length(); i++) {
            char resultChar = '\0';

            if(sign.equalsIgnoreCase(",")){
                resultChar = (char)(encodedString.charAt(i) + (char)digit);
            }else{
                resultChar = (char) (encodedString.charAt(i) - (char)digit);
            }

            decodedString = decodedString + resultChar;
        }

        return decodedString;
    }
}