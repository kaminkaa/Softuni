package app.factories;

import app.entities.cells.Cell;
import app.entities.cells.bloodCells.RedBloodCell;
import app.entities.cells.bloodCells.WhiteBloodCell;
import app.entities.cells.microbes.Bacteria;
import app.entities.cells.microbes.Fungi;
import app.entities.cells.microbes.Virus;

public final class CellFactory {
    private CellFactory() {}

    public static Cell createCell(String cellTYpe, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        switch (cellTYpe) {
            case "WhiteBloodCell":
                return new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case "RedBloodCell":
                return new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case "Bacteria":
                return new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
            case "Virus":
                return new Virus(cellId, health, positionRow, positionCol, additionalProperty);
            case "Fungi":
                return new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
            default:
                return null;
        }
    }
}
