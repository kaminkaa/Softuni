import java.util.ArrayList;
import java.util.List;

public class MyList implements Personalisable {
    private List<String> collection;
    private int used;

    public MyList() {
        this.collection = new ArrayList<>();
        this.used = 0;
    }

    @Override
    public int getUsed() {
        return this.used;
    }

    @Override
    public String remove() {
        String removedItem = this.collection.get(0);
        this.collection.remove(0);
        this.used--;
        return removedItem;
    }

    @Override
    public List<String> getCollection() {
        return this.collection;
    }

    @Override
    public int add(String item) {
        this.collection.add(0,item);
        this.used++;
        return this.collection.indexOf(item);
    }
}
