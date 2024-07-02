package algorithms.mazeGenerators;

import java.util.ArrayList;

public class Position {
    protected int row;
    protected int col;

    protected int[] position;

    protected boolean check;


    public Position(int row, int col) {
        this.row = row;
        this.col = col;
        this.position = new int[]{row, col};
    }

    public int getRowIndex() {
        return row;
    }

    public boolean compare(Position other) {
        return this.row == other.row && this.col == other.col;
    }

    public int getColIndex() {
        return col;
    }

    public Position(Position position) {
        this.row = position.getRowIndex();
        this.col = position.getColIndex();
    }

    @Override
    public String toString() {
        return "{" + row + "," + col + "}";
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
        this.position = new int[]{row, col};
    }

    public int[] getPosition() {
        return position;
    }

    public void isChecked(boolean visited) {
        check = visited;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }
}