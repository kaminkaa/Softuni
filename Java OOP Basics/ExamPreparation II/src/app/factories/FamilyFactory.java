package app.factories;

import app.entities.families.Family;

public class FamilyFactory {
    private FamilyFactory() {}

    public static Family createFamily(String id) {
        return new Family(id);
    }
}
