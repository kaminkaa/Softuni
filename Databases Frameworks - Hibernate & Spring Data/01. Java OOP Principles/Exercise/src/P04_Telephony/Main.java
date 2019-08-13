package P04_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] phoneNumbers = reader.readLine().split(" ");
        String[] sites = reader.readLine().split(" ");

        Smartphone smartphone = new Smartphone();

        for (String phoneNumber : phoneNumbers) {
            System.out.println(smartphone.call(phoneNumber));
        }

        for (String site : sites) {
            System.out.println(smartphone.browse(site));
        }
    }
}
