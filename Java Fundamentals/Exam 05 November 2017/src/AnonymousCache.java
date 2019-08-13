import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnonymousCache {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Map<String,Long>> datasets = new LinkedHashMap<>();
        Map<String,Map<String,Long>> cache = new LinkedHashMap<>();

        String[] input = reader.readLine().split(" -> | \\| ");

        while (true) {
            if (input[0].equals("thetinggoesskrra")) { break; }

            if (input.length == 1) {
                String dataSetName = input[0];
                if (cache.containsKey(dataSetName)) {
                    datasets.put(dataSetName,cache.get(dataSetName));
                } else {
                    datasets.put(dataSetName,new LinkedHashMap<>());
                }
            } else {
                String dataKey = input[0];
                long dataSize = Long.parseLong(input[1]);
                String dataSetName = input[2];

                if (datasets.containsKey(dataSetName)) {
                    if (datasets.get(dataSetName).containsKey(dataKey)) {
                        datasets.get(dataSetName).put(dataKey, datasets.get(dataSetName).get(dataKey) + dataSize);
                    } else {
                        datasets.get(dataSetName).put(dataKey,dataSize);
                    }
                } else {
                    if (cache.containsKey(dataSetName)) {
                        if (cache.get(dataSetName).containsKey(dataKey)) {
                            cache.get(dataSetName).put(dataKey, cache.get(dataSetName).get(dataKey) + dataSize);
                        } else {
                            cache.get(dataSetName).put(dataKey, dataSize);
                        }
                    } else {
                        cache.put(dataSetName,new LinkedHashMap<>());
                        cache.get(dataSetName).put(dataKey,dataSize);
                    }
                }
            }

            input = reader.readLine().split(" -> | \\| ");
        }

        BigInteger totalSize = new BigInteger("0");
        BigInteger maxTotalSize = new BigInteger("0");
        String datasetHighestDatasize = "";

        for (Map.Entry<String, Map<String, Long>> entry : datasets.entrySet()) {
            totalSize = BigInteger.valueOf(0);
            for (Long size : entry.getValue().values()) {
                totalSize = totalSize.add(BigInteger.valueOf(size));
            }
            int compare = totalSize.compareTo(maxTotalSize);
            if (compare > 0) {
                maxTotalSize = totalSize;
                datasetHighestDatasize = entry.getKey();
            }
        }

        if (datasets.size() != 0) {
            System.out.printf("Data Set: %s, Total Size: %d\n", datasetHighestDatasize, maxTotalSize);
            for (Map.Entry<String,Long> keyValue : datasets.get(datasetHighestDatasize).entrySet()) {
                System.out.printf("$.%s\n", keyValue.getKey());
            }
        }
    }
}
