package app.entities.colonists.engineers;

public class HardwareEngineer extends Engineer {
    private int additionalAgeBonus;

    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
        this.additionalAgeBonus = 0;
    }

    private void setAdditionalAgeBonus() {
        this.additionalAgeBonus = super.getAge() <= 18 ? 2 : 0;
    }

    private int getAdditionalAgeBonus() {
        return this.additionalAgeBonus;
    }

    @Override
    public int getPotential() {
        this.setAdditionalAgeBonus();
        return super.getTalent() + super.getClassBonus() + super.getAgeBonus() + this.getAdditionalAgeBonus();
    }
}
