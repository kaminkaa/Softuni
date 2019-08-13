package app.factories;

import app.entities.Organism;

public final class OrganismFactory {
    private OrganismFactory() {}

    public static Organism createOrganism(String organismName) {
        return new Organism(organismName);
    }
}
