package algorithms.mazeGenerators;

public class Position {
    private int row;
    private int col;
    private boolean check;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRowIndex() {
        return row;
    }

    public int getColIndex() {
        return col;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position other = (Position) obj;

        return this.row == other.row && this.col == other.col;
    }


    @Override
    public String toString() {
        return "{" + row + "," + col + "}";
    }

    public void isChecked(boolean visited) {
        check = visited;
    }
}
