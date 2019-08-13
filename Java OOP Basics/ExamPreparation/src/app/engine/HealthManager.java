package app.engine;

import app.entities.Organism;
import app.entities.clusters.Cluster;
import app.factories.CellFactory;
import app.factories.ClusterFactory;
import app.factories.OrganismFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    /* RETURNS detailed information about the condition of the organism with the given name */
    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).toString();
        }
        return "";
    }

    /* CREATES an organism with the given name
       RETURNS message "Created organism <name>"
       If an organism with the same name already exists, returns message "Organism <name> already exists" */
    public String createOrganism(String name) {
        if (this.organisms.containsKey(name)) {
            return "Organism " + name + " already exists";
        }

        this.organisms.put(name, OrganismFactory.createOrganism(name));
        return "Created organism " + name;
    }

    /* CREATES a cluster with the given id, rows and cols
       ADDS the cluster to the cluster collection of the organism with the given name
       If the organism already has a cluster with the same Id, nothing happens
       RETURNS message "Organism <organism name>: Created cluster <cluster id>"; */
    public String addCluster(String organismName, String id, int rows, int cols) {
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).addCluster(ClusterFactory.createCluster(id, rows, cols));
        }
        return "";
    }

    /* CREATES a cell of the given type with the given id, health, positionRow, positionCol, and the given additional property (size, velocity or virulense).
       FINDS the organism with given name, finds the cluster with given id in the cluster collection of that organism and ADDS the cell to the cells
       collection of that cluster.
       RETURNS message "Organism <organism name>: Created cell <cell id> in cluster <cluster id>" */
    public String addCell (String organismName, String clusterId, String cellTYpe, String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        if (this.organisms.containsKey(organismName)) {
            Cluster wantedCluster = this.organisms.get(organismName).getClusterById(clusterId);
            if (wantedCluster != null) {
                if (wantedCluster.addCell(CellFactory.createCell(cellTYpe, cellId, health, positionRow, positionCol, additionalProperty))) {
                    return String.format("Organism %s: Created cell %s in cluster %s",organismName, cellId, clusterId);
                }
            }
        }
        return "";
    }

    /* FINDS the organism with the given name
       ACTIVATES the next cluster in order
       RETURNS message "Organism <organism name>: Activated cluster <cluster id>. Cells left: <cells count>"*/
    public String activateCluster(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            if (this.organisms.get(organismName).getClusters().size() > 0) {

                Cluster cluster = this.organisms.get(organismName).getClusters().get(0);

                cluster.activate();

                this.organisms.get(organismName).moveClusterToTheEnd();

                return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName, cluster.getId(), cluster.getCellsCount());
            }
        }
        return "";
    }

}
