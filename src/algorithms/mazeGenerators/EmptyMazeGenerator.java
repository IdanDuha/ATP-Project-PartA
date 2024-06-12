package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int row, int col) {
        try {
            if (row < 2 || col < 2) {
                throw new IllegalArgumentException("Maze must have rows or columns larger that 1");
            }
            Position StartPoint = new Position(0, 0);
            Position GoalPoint = new Position(row - 1, col - 1);
            Maze maze = new Maze(row, col, StartPoint, GoalPoint);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze.setToZero(i, j);
                }
            }
            return maze;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}