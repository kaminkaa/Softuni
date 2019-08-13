package app.entities.families;

import app.entities.colonists.Colonist;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private String id;
    private List<Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new ArrayList<>();
    }

    public void addColonist(Colonist colonist) {
        this.colonists.add(colonist);
    }

    public void removeColonist(Colonist colonist) {
        this.colonists.remove(colonist);
    }

    public Colonist getColonistById(String colonistId) {
        for (Colonist colonist : this.colonists) {
            if (colonist.getId().equals(colonistId)) {
                return colonist;
            }
        }

        return null;
    }

    public String getId() {
        return this.id;
    }

    public List<Colonist> getColonists() {
        return this.colonists;
    }

    public int familySize() {
        return this.colonists.size();
    }
}
