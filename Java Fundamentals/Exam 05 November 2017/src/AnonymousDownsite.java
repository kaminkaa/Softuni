import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AnonymousDownsite {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        BigDecimal securityKey = new BigDecimal(reader.readLine());
        String[] input;

        List<String> affectedWebsites = new ArrayList<>();

        String siteName;

        BigDecimal siteloss;
        BigDecimal totalSiteLoss = new BigDecimal("0.0");

        for (int i = 0; i < n; i++) {
            input = reader.readLine().split("\\s+");
            siteName = input[0];
            long siteVisits = Long.parseLong(input[1]);
            BigDecimal siteCommercialPricePerVisit = new BigDecimal(input[2]);

            affectedWebsites.add(siteName);
            if (siteVisits != 0) {
                siteloss = BigDecimal.valueOf(siteVisits).multiply(siteCommercialPricePerVisit);
                totalSiteLoss = totalSiteLoss.add(siteloss);
            }
        }

        BigDecimal securityToken = securityKey.pow(n);

        for (String affectedWebsite : affectedWebsites) {
            System.out.println(affectedWebsite);
        }

        System.out.printf("Total Loss: %.20f\n", totalSiteLoss);
        System.out.printf("Security Token: %.0f", securityToken);
    }
}
