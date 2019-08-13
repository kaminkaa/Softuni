package app.entities.colonists.engineers;

import app.entities.colonists.Colonist;

public abstract class Engineer extends Colonist {
    private int classBonus;
    private int ageBonus;

    protected Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
        this.classBonus = 3;
        this.setAgeBonus();
    }

    private void setAgeBonus() {
        this.ageBonus = super.getAge() > 30 ? 2 : 0;
    }

    protected int getClassBonus() {
        return this.classBonus;
    }

    protected int getAgeBonus() {
        return this.ageBonus;
    }
}
