import java.util.ArrayList;
import java.util.List;

public class AddCollection implements Addable {
    private List<String> collection;

    public AddCollection() {
        this.collection = new ArrayList<>();
    }

    @Override
    public List<String> getCollection() {
        return this.collection;
    }

    @Override
    public int add(String item) {
        this.collection.add(item);
        return this.collection.indexOf(item);
    }
}
