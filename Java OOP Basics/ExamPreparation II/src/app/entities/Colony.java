package app.entities;

import app.entities.colonists.Colonist;
import app.entities.families.Family;
import app.factories.FamilyFactory;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String,Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new LinkedHashMap<>();
    }

    public String addColonist(Colonist colonist) {
        if (!this.families.containsKey(colonist.getFamilyId())) {
            if (this.maxFamilyCount == this.families.size()) {
                return "colony is full";
            }
            this.families.put(colonist.getFamilyId(), FamilyFactory.createFamily(colonist.getFamilyId()));
        }

        Family family = this.families.get(colonist.getFamilyId());

        if (family.familySize() == this.maxFamilyCapacity){
            return "family is full";
        }

        family.addColonist(colonist);
        return "";
    }

	public void removeColonist(String familyId, String colonistId) {
        Family family = this.families.get(familyId);
        family.removeColonist(family.getColonistById(colonistId));

        if (family.familySize() == 0) {
            this.removeFamily(familyId);
        }
    }

    public void removeFamily(String id) {
        this.families.remove(id);
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        return this.families.get(familyId).getColonists();
    }

    public void grow(int years) {
        for (Map.Entry<String, Family> family : this.families.entrySet()) {
            for (Colonist colonist : family.getValue().getColonists()) {
                colonist.grow(years);
            }
        }
    }

	public int getPotential() {
        int potential = 0;

        for (Map.Entry<String, Family> family : this.families.entrySet()) {
            for (Colonist colonist : family.getValue().getColonists()) {
                potential += colonist.getPotential();
            }
        }

        return potential;
    }

	public String getCapacity() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("families: %d/%d", this.families.size(), this.maxFamilyCount)).append(System.lineSeparator());

        Comparator<Map.Entry<String, Family>> compareByFamilyId = Comparator.comparing(kvp -> kvp.getValue().getId());

        this.families.entrySet().stream().sorted(compareByFamilyId).forEach(kvp -> {
            sb.append(String.format("-%s: %d/%d", kvp.getKey(), kvp.getValue().familySize(), this.maxFamilyCapacity))
                    .append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
