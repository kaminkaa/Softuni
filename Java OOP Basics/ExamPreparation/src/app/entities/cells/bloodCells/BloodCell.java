package app.entities.cells.bloodCells;

import app.entities.cells.Cell;

public abstract class BloodCell extends Cell {

    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }
}
