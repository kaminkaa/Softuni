package app.entities.colonists.engineers;

public class SoftwareEngineer extends Engineer {
    private int flatBonus;

    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
        this.flatBonus = 2;
    }

    public int getFlatBonus() {
        return this.flatBonus;
    }

    @Override
    public int getPotential() {
        return super.getTalent() + super.getClassBonus() + super.getAgeBonus() + this.getFlatBonus();
    }
}
