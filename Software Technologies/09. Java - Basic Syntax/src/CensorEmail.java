import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CensorEmail {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder email = new StringBuilder(reader.readLine());
        StringBuilder text = new StringBuilder(reader.readLine());

        String username = email.substring(0,email.indexOf("@"));
        String domain = email.substring(email.indexOf("@")+1);
        String regex = "\\b(?<username>[a-z.]+)@(?<domain>[a-z.]+)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.toString());

        while (matcher.find()) {
            if (matcher.group("username").equals(username) && matcher.group("domain").equals(domain)){
                text.replace(text.indexOf(matcher.group("username")),
                        text.indexOf(matcher.group("username")) + matcher.group("username").length(),
                        censor(matcher.group("username")));
            }
        }

        System.out.println(text.toString());
    }

    static String censor (String username){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < username.length(); i++) {
             sb.append('*');
        }
        return sb.toString();
    }
}


