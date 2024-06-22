package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int row, int col) {


        try {
            if (row < 2 || col < 2) {
                throw new IllegalArgumentException("Maze must have rows or columns larger that 1");
            }
            Position StartPoint = setPointonEdge(row, col);
            Position GoalPoint;
            do {
                GoalPoint = setPointonEdge(row, col);

            } while (StartPoint.equals(GoalPoint));

            Maze maze = new Maze(row, col, StartPoint, GoalPoint);
            Random rand = new Random();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze.setPoint(i, j, rand.nextInt(2));
                }
            }
            Pathfinder(maze, StartPoint, GoalPoint);


            return maze;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private void Pathfinder(Maze maze, Position start, Position goal) {
        int[][] map = maze.getMaze();
        int row = maze.getRow();
        int col = maze.getCol();
        int currRow = start.getRowIndex();
        int currCol = start.getColIndex();

        Random rand = new Random();

        while (currRow != goal.getRowIndex() || currCol != goal.getColIndex()) { ///
            maze.setToZero(currRow, currCol); // Set the current cell to 2

            // Randomly choose the next move
            double moveTowardsGoal = rand.nextDouble(); // Probability to move towards goal,
            //beacuse using only random picks would create a massive path without 1's at all
            if (moveTowardsGoal < 0.8) { // 80% chance to move towards goal
                int rowDiff = goal.getRowIndex() - currRow;
                int colDiff = goal.getColIndex() - currCol;

                if (Math.abs(rowDiff) > Math.abs(colDiff)) {
                    if (rowDiff > 0 && currRow < row - 1) {
                        currRow++;
                    } else if (rowDiff < 0 && currRow > 0) {
                        currRow--;
                    }
                } else {
                    if (colDiff > 0 && currCol < col - 1) {
                        currCol++;
                    } else if (colDiff < 0 && currCol > 0) {
                        currCol--;
                    }
                }
            } else { // Random move
                int direction = rand.nextInt(4); // 0: up, 1: right, 2: down, 3: left

                // Update current position based on the chosen direction
                switch (direction) {
                    case 0: // up
                        if (currRow > 0) {
                            currRow--;
                        }
                        break;
                    case 1: // right
                        if (currCol < col - 1) {
                            currCol++;
                        }
                        break;
                    case 2: // down
                        if (currRow < row - 1) {
                            currRow++;
                        }
                        break;
                    case 3: // left
                        if (currCol > 0) {
                            currCol--;
                        }
                        break;
                }
            }
        }

        map[goal.getRowIndex()][goal.getColIndex()] = 0; // Set the goal cell to 0
    }
}