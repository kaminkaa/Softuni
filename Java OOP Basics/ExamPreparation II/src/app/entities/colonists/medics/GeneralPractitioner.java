package app.entities.colonists.medics;

public class GeneralPractitioner extends Medic {
    private int ageBonus;
    private int signBonus;

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
        this.ageBonus = 0;
        this.setSignBonus();
    }

    private int getAgeBonus() {
        return this.ageBonus;
    }

    private void setAgeBonus() {
        this.ageBonus = super.getAge() > 15 ? 1 : 0;
    }

    private int getSignBonus() {
        return this.signBonus;
    }

    private void setSignBonus() {
        if ("caring".equals(super.getSign())) {
            this.signBonus = 1;
        } else if ("careless".equals(super.getSign())) {
            this.signBonus = -2;
        } else {
            this.signBonus = 0;
        }
    }

    @Override
    public int getPotential() {
        this.setAgeBonus();
        return super.getTalent() + super.getBonus() + this.getAgeBonus() + this.getSignBonus();
    }
}
