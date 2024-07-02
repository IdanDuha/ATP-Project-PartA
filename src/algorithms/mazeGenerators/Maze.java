package algorithms.mazeGenerators;

public class Maze {
    private int row;
    private int col;
    private Position StartPosition; //added Position class
    private Position GoalPosition;
    protected int[][] map;  //changed "maze" to map due to same name in tests for creating a maze "Maze maze"

    public Maze(int rows, int colm, Position start, Position end) {
        row = rows;
        col = colm;
        StartPosition = start;
        GoalPosition = end;
        map = new int[rows][colm];

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int[][] getMaze() {
        return map;
    }

    public void setStartingPoint(Position start) {
        StartPosition = start;
    }

    public void setGoalPoint(Position goal) {
        GoalPosition = goal;
    }

    public Position getStartPosition() {
        return StartPosition;
    }

    public Position getGoalPosition() {
        return GoalPosition;
    }

    public void setToZero(int row, int col) {
        map[row][col] = 0;
    }

    public void setPoint(int rowIndex, int colIndex, int number) {
        this.map[rowIndex][colIndex] = number;
    }

    public int getValue(int row, int col) {
        return map[row][col];
    }

    public int getPosValue(Position pos) {
        return map[pos.getRowIndex()][pos.getColIndex()];
    }

    public boolean isValidMaze(Maze maze) {
        return row >= 2 && col >= 2;
    }

    public int isValidPosition(Position pos) {
        if (pos.getRowIndex() >= 0 && pos.getRowIndex() < row && pos.getColIndex() >= 0 && pos.getColIndex() < col)
            return 1;
        return -1;
    }

    public boolean isValidCell(int rowIndex, int colIndex) {
        if (rowIndex >= 0 && rowIndex < row && colIndex >= 0 && colIndex < col)
            return true;
        return false;
    }

    public boolean isValidMove(int rowIndex, int colIndex) {
        if (rowIndex >= 0 && rowIndex < row && colIndex >= 0 && colIndex < col) {
            if (map[rowIndex][colIndex] == 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void print() {
        if (this == null) {
            System.out.println("niguhhaaaaaaaa");
        } else {
            // Display the generated maze
            for (int i = 0; i < this.getRow(); i++) {
                for (int j = 0; j < this.getCol(); j++) {
                    if (i == this.getStartPosition().getRowIndex() && j == this.getStartPosition().getColIndex()) {
                        System.out.print("S "); // Print start point as 'S'
                    } else if (i == this.getGoalPosition().getRowIndex() && j == this.getGoalPosition().getColIndex()) {
                        System.out.print("E "); // Print goal point as 'G'
                    } else if (this.getMaze()[i][j] == 1) {
                        System.out.print("1 "); // Print walls as '#'
                    } else {
                        System.out.print("0 "); // Print paths as '.'
                    }
                }
                System.out.println();
            }
        }
    }
}