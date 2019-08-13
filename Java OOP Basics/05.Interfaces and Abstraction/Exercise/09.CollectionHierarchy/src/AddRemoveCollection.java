import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollection implements Removable {
    private List<String> collection;

    public AddRemoveCollection() {
        this.collection = new ArrayList<>();
    }

    @Override
    public List<String> getCollection() {
        return this.collection;
    }

    @Override
    public int add(String item) {
        this.collection.add(0,item);
        return this.collection.indexOf(item);
    }

    @Override
    public String remove() {
        String removedItem = this.collection.get(this.collection.size()-1);
        this.collection.remove(this.collection.size()-1);
        return removedItem;
    }
}
