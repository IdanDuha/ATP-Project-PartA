package algorithms.mazeGenerators;

public class Maze {
    private int row;
    private int col;
    private Position StartPosition; //added Position class
    private Position GoalPosition;
    private int[][] map;  //changed "maze" to map due to same name in tests for creating a maze "Maze maze"
    public Maze(int rows, int colm, Position start, Position end){
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

    public void SetStartingPoint(Position start){
        StartPosition=start;
    }
    public void SetGoalPoint (Position goal){
        GoalPosition=goal;
    }
    public Position GetStartingPoint(){
        return StartPosition;
    }
    public Position getGoalPosition(){
        return GoalPosition;
    }

    public void setToZero(int row,int col){
        map[row][col] = 0;
    }

    protected void SetPoint(int rowIndex, int colIndex, int number){
        this.map[rowIndex][colIndex] = number;
    }
}