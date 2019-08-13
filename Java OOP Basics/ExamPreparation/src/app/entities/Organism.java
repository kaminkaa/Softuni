package app.entities;

import app.entities.cells.Cell;
import app.entities.clusters.Cluster;
import app.factories.ClusterFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Organism {
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    public String addCluster(Cluster cluster) {
        if (!this.clusterExists(cluster.getId())) {
            this.clusters.add(cluster);
            return String.format("Organism %s: Created cluster %s", this.getName(), cluster.getId());
        }
        return "";
    }

    public void moveClusterToTheEnd() {
        Cluster cluster = this.clusters.get(0);
        this.clusters.remove(0);
        this.clusters.add(cluster);
    }

    public boolean clusterExists(String id) {
        for (Cluster cluster : this.clusters) {
            if (cluster.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    public Cluster getClusterById(String clusterId) {
        for (Cluster cluster : this.clusters) {
            if (cluster.getId().equals(clusterId)) {
                return cluster;
            }
        }
        return null;
    }

    private int getCellsCount() {
        int count = 0;

        for (Cluster cluster : this.clusters) {
            for (Cell[] cells : cluster.getCells()) {
                for (Cell cell : cells) {
                    if (cell != null) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Organism - %s\n--Clusters: %d\n--Cells: %s", this.name, this.clusters.size(), this.getCellsCount()));
        if (this.clusters.size() > 0) {
            for (Cluster cluster : this.clusters) {
                sb.append(cluster.toString());
            }
        }
        return sb.toString();
    }
}
