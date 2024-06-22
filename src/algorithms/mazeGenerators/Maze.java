package algorithms.mazeGenerators;
import java.util.Random;
public class Maze {
    private int row;
    private int col;
    private Position StartPosition; //added Position class
    private Position GoalPosition;
    private int[][] map;  //changed "maze" to map due to same name in tests for creating a maze "Maze maze"

    public Maze(int rows, int colm, Position start, Position end) {
        row = rows;
        col = colm;
        StartPosition = start;
        GoalPosition = end;
        map = new int[rows][colm];

    }

    public int getValue(int row, int col) {
        return map[row][col];
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

    public boolean isValidCell(int row, int col) {
        if (row >= 0 && row < map.length && col >= 0 && col < map[0].length)
            return true;
        return false;
    }

    public Position getStartingPoint() {
        return StartPosition;
    }

    public Position getGoalPosition() {
        return GoalPosition;
    }

    public void setToZero(int row, int col) {
        map[row][col] = 0;
    }

    public void setToTwo(int row, int col) {
        map[row][col] = 2;
    }

    protected void setPoint(int rowIndex, int colIndex, int number) {
        this.map[rowIndex][colIndex] = number;
    }
}