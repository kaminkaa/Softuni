package app.factories;

import app.entities.Colony;

public class ColonyFactory {
    private ColonyFactory() {}

    public static Colony createColony(int maxFamilyCount, int maxFamilyCapacity) {
        return new Colony(maxFamilyCount, maxFamilyCapacity);
    }
}
