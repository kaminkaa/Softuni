import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Files {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, File>> files = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> rootsAndExtensions = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        String regex = "(?<root>.+?)\\\\(.+?\\\\)+(?<fileName>.+\\.(?<extension>.+));(?<size>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String extension = matcher.group("extension");
                String root = matcher.group("root");
                Long fileSize = Long.parseLong(matcher.group("size"));
                String fileName = matcher.group("fileName");

                File file = new File(fileName, extension, fileSize);
                files.putIfAbsent(root, new LinkedHashMap<>());
                if (files.get(root).containsKey(fileName)) {
                    files.get(root).get(fileName).setSize(fileSize);
                } else {
                    files.get(root).put(fileName, file);
                }
                rootsAndExtensions.putIfAbsent(root, new ArrayList<>());
                rootsAndExtensions.get(root).add(extension);
            }
        }
        String[] commands = reader.readLine().split(" ");
        String extension = commands[0];
        String root = commands[2];

        if (!rootsAndExtensions.containsKey(root) || !rootsAndExtensions.get(root).contains(extension)) {
            System.out.println("No");
        }
        files.entrySet().stream()
                .filter(kvp -> kvp.getKey().equals(root))
                .forEach(kvp -> {
                    files.get(kvp.getKey()).values().stream()
                            .filter(file -> file.getExtension().equals(extension))
                            .sorted(Comparator.comparing(File::getSize, Comparator.reverseOrder())
                                    .thenComparing(File::getName))
                            .forEach(file -> {
                                System.out.printf("%s - %s KB%n", file.getName(), file.getSize());
                            });

                });

    }
}

class File {
    private String fullName;
    private String extension;
    private long size;

    File(String name, String extension, long size) {
        this.fullName = name;
        this.extension = extension;
        this.size = size;
    }

    public String getName() {
        return fullName;
    }

    public String getExtension() {
        return extension;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}