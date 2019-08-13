package app.entities.colonists;

public class Soldier  extends Colonist {
    private int classBonus;
    private int ageBonus;

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
        this.classBonus = 3;
        this.ageBonus = 3;
    }

    private int getClassBonus() {
        return this.classBonus;
    }

    private int getAgeBonus() {
        return this.ageBonus;
    }

    @Override
    public int getPotential() {
        return super.getTalent() + this.getClassBonus() + this.getAgeBonus();
    }
}
