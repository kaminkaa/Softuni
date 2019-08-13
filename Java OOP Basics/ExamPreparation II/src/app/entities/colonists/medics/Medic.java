package app.entities.colonists.medics;

import app.entities.colonists.Colonist;

public abstract class Medic extends Colonist {
    private String sign;
    private int bonus;

    protected Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
        this.bonus = 2;
    }

    protected String getSign() {
        return this.sign;
    }

    protected int getBonus() {
        return this.bonus;
    }
}
