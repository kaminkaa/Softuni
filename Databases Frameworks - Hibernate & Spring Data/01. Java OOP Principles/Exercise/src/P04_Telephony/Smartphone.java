package P04_Telephony;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    public Smartphone() {

    }

    @Override
    public String browse(String site) {
        Pattern p = Pattern.compile( "[\\d]" );
        Matcher m = p.matcher(site);

        if (m.find()) {
            return "Invalid URL!";
        }

        return "Browsing: " + site + "!";
    }

    @Override
    public String call(String number) {
        Pattern p = Pattern.compile( "[\\D]" );
        Matcher m = p.matcher(number);

        if (m.find()) {
            return "Invalid number!";
        }

        return "Calling... " + number;
    }
}
