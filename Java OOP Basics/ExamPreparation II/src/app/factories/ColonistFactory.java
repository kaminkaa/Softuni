package app.factories;

import app.entities.colonists.Colonist;
import app.entities.colonists.Soldier;
import app.entities.colonists.engineers.HardwareEngineer;
import app.entities.colonists.engineers.SoftwareEngineer;
import app.entities.colonists.medics.GeneralPractitioner;
import app.entities.colonists.medics.Surgeon;

public class ColonistFactory {
    private ColonistFactory() {}

    public static Colonist createColonist(String classs, String colonistId, String familyId, int talent, int age, String sign) {
        switch (classs) {
            case "Soldier":
                return new Soldier(colonistId, familyId, talent, age);
            case "SoftwareEngineer":
                return new SoftwareEngineer(colonistId, familyId, talent, age);
            case "HardwareEngineer":
                return new HardwareEngineer(colonistId, familyId, talent, age);
            case "GeneralPractitioner":
                return new GeneralPractitioner(colonistId, familyId, talent, age, sign);
            case "Surgeon":
                return new Surgeon(colonistId, familyId, talent, age, sign);
                default:
                    return null;
        }
    }
}
