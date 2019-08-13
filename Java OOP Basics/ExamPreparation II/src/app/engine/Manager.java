package app.engine;

import app.entities.Colony;
import app.entities.colonists.Colonist;
import app.factories.ColonistFactory;
import app.factories.ColonyFactory;

import java.util.Collections;
import java.util.List;

public class Manager {
    private Colony colony;

    public Manager() {}

    public void createColony(int maxFamilyCount, int maxFamilyCapacity) {
        this.colony = ColonyFactory.createColony(maxFamilyCount, maxFamilyCapacity);
    }

    public String addColonist(String classs, String colonistId, String familyId, int talent, int age, String sign) {
        Colonist colonist = ColonistFactory.createColonist(classs, colonistId, familyId, talent, age, sign);

        return this.colony.addColonist(colonist);
    }

    public void removeFamily(String familyId) {
        this.colony.removeFamily(familyId);
    }

    public void removeColonist(String familyId, String colonistId) {
        this.colony.removeColonist(familyId, colonistId);
    }

    public void grow(int years) {
        this.colony.grow(years);
    }

    public String getPotential() {
        return "potential: " + this.colony.getPotential();
    }

    public String getCapacity() {
        return this.colony.getCapacity();
    }

    public String getFamilyInfo(String familyId) {
        List<Colonist> colonists = this.colony.getColonistsByFamilyId(familyId);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s:", familyId)).append(System.lineSeparator());

        Collections.sort(colonists, (c1, c2) -> c1.getId().compareTo(c2.getId()));

        for (Colonist colonist : colonists) {
            sb.append(String.format("-%s: %d", colonist.getId(), colonist.getPotential()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
