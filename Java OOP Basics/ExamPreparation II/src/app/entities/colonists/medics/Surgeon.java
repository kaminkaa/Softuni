package app.entities.colonists.medics;

public class Surgeon extends Medic {
    private int ageBonus;
    private int signBonus;

    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
        this.ageBonus = 0;
        this.setSignBonus();
    }

    private int getAgeBonus() {
        return this.ageBonus;
    }

    private void setAgeBonus() {
        this.ageBonus = (super.getAge() > 25 && super.getAge() < 35 ) ? 2 : 0;
    }

    private int getSignBonus() {
        return this.signBonus;
    }

    private void setSignBonus() {
        if ("precise".equals(super.getSign())) {
            this.signBonus = 3;
        } else if ("butcher".equals(super.getSign())) {
            this.signBonus = -3;
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
