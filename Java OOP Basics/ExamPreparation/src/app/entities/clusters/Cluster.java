package app.entities.clusters;

import app.entities.cells.Cell;

import java.util.LinkedList;
import java.util.List;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Cell[][] cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }

    public String getId() {
        return id;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean addCell(Cell cell) {
        if (cell.getPositionRow() > this.getRows()-1 || cell.getPositionCol() > this.getCols()-1) {
            return false;
        }
        this.cells[cell.getPositionRow()][cell.getPositionCol()] = cell;
        return true;
    }

    public int getCellsCount() {
        int count = 0;

        for (Cell[] cells : this.cells) {
            for (Cell cell : cells) {
                if (cell != null) {
                    count++;
                }
            }
        }

        return count;
    }
    
    public void activate() {
        List<Cell> cellList = new LinkedList<>();

        for (Cell[] cells : cells) {
            for (Cell cell : cells) {
                if (cell != null) {
                    cellList.add(cell);
                }
            }
        }

        while (cellList.size() > 0) {
            if (cellList.size() == 1) {
                break;
            }

            Cell startCell = cellList.get(0);
            cellList.remove(0);

            Cell secondCell = cellList.get(0);
            cellList.remove(0);

            Cell winner = this.fight(startCell, secondCell);
            cellList.add(0, winner);
        }

        this.cells = new Cell[rows][cols];
        for (Cell cell : cellList) {
            this.cells[cell.getPositionRow()][cell.getPositionCol()] = cell;
        }
    }

    public Cell fight(Cell startCell, Cell cell) {
        String cellType = startCell.getClass().getSimpleName();

        switch (cellType) {
            case "RedBloodCell":
            case "WhiteBloodCell":
                startCell.setHealth(startCell.getHealth() + cell.getHealth());
                startCell.setPositionRow(cell.getPositionRow());
                startCell.setPositionCol(cell.getPositionCol());
                return startCell;
            default:
                //fight
                while (true) {
                    cell.setHealth(cell.getHealth() - startCell.getEnergy());

                    if (cell.getHealth() <= 0) {
                        startCell.setPositionRow(cell.getPositionRow());
                        startCell.setPositionCol(cell.getPositionCol());
                        return startCell;
                    } else {
                        startCell.setHealth(startCell.getHealth() - cell.getEnergy());
                        if (startCell.getHealth() <= 0) {
                            cell.setPositionRow(cell.getPositionRow());
                            cell.setPositionCol(cell.getPositionCol());
                            return cell;
                        }
                    }
                }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n----Cluster %s", this.getId()));
        if (this.getCellsCount() > 0) {
            for (int row = 0; row < this.cells.length; row++) {
                for (int col = 0; col < this.cells[row].length; col++) {
                    if (this.cells[row][col] != null) {
                        sb.append(this.cells[row][col].toString());
                    }
                }
            }
        }
        return sb.toString();
    }
}
