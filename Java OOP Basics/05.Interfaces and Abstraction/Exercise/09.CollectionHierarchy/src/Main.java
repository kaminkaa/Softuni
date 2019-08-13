import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");

        List<Integer> indexesAddCollection = new ArrayList<>();
        List<Integer> indexesAddRemoveCollection = new ArrayList<>();
        List<Integer> indexesMyList = new ArrayList<>();

        for (String s : line) {
            indexesAddCollection.add(addCollection.add(s));
            indexesAddRemoveCollection.add(addRemoveCollection.add(s));
            indexesMyList.add(myList.add(s));
        }

        StringBuilder sb = new StringBuilder();
        indexesAddCollection.forEach(i -> sb.append(i).append(" "));
        sb.append("\n");
        indexesAddRemoveCollection.forEach(i -> sb.append(i).append(" "));
        sb.append("\n");
        indexesMyList.forEach(i -> sb.append(i).append(" "));
        sb.append("\n");

        List<String> result1 = new ArrayList<>();
        List<String> result2 = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            result1.add(addRemoveCollection.remove());
            result2.add(myList.remove());
        }

        result1.forEach(i -> sb.append(i).append(" "));
        sb.append("\n");
        result2.forEach(i -> sb.append(i).append(" "));

        System.out.println(sb);
    }
}
