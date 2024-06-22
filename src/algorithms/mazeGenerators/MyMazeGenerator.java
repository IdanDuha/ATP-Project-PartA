package algorithms.mazeGenerators;

import java.util.Random;
import java.util.Stack;

public class MyMazeGenerator extends AMazeGenerator {
    private static final int WALL = 1;
    private static final int EMPTY = 0;
    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private boolean[][] visited;

    @Override
    public Maze generate(int row, int col) {
        try {
            if (row < 2 || col < 2) {
                throw new IllegalArgumentException("Maze must have rows or columns larger that 1");
            }
            // creating the start and goal point in the maze and making sure they are on the edges:
            Position startPoint = setPointonEdge(row, col);
            Position goalPoint;

            do {
                goalPoint = setPointonEdge(row, col);
            } while (startPoint.equals(goalPoint));
            // creating the maze:
            Maze maze = new Maze(row, col, startPoint, goalPoint);
            initializeMaze(maze); // Initializing the maze with only walls

            generateMazeWithDFS(maze, startPoint); // generating a maze using DFS algorithm

            return maze;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private void initializeMaze(Maze maze) {
        int rows = maze.getRow();
        int columns = maze.getCol();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maze.setPoint(i, j, WALL);
            }
        }
    }

    private void generateMazeWithDFS(Maze maze, Position startPoint) {
        visited = new boolean[maze.getRow()][maze.getCol()];
        Stack<Position> stack = new Stack<>();
        stack.push(startPoint);
        visited[startPoint.getRowIndex()][startPoint.getColIndex()] = true;

        while (!stack.isEmpty()) {
            Position current = stack.pop();
            Position neighbor = get_Random_Adjacent_Neighbor(current, maze);

            if (neighbor != null) {
                stack.push(current);
                remove_Wall_Between_Cells(current, neighbor, maze);
                visited[neighbor.getRowIndex()][neighbor.getColIndex()] = true;
                stack.push(neighbor);
            }
        }
    }

    private void remove_Wall_Between_Cells(Position current, Position neighbor, Maze maze) {
        maze.setPoint(current.getRowIndex(), current.getColIndex(), EMPTY);
        maze.setPoint(neighbor.getRowIndex(), neighbor.getColIndex(), EMPTY);
        int row = current.getRowIndex() + (neighbor.getRowIndex() - current.getRowIndex()) / 2;
        int col = current.getColIndex() + (neighbor.getColIndex() - current.getColIndex()) / 2;
        maze.setPoint(row, col, EMPTY);
    }

    private Position get_Random_Adjacent_Neighbor(Position current, Maze maze) {
        Random rand = new Random();
        int startDirection = rand.nextInt(4);

        for (int i = 0; i < 4; i++) {
            int directionIndex = (startDirection + i) % 4;
            int newRow = current.getRowIndex() + DIRECTIONS[directionIndex][0] * 2;
            int newCol = current.getColIndex() + DIRECTIONS[directionIndex][1] * 2;

            if (maze.isValidCell(newRow, newCol) && !visited[newRow][newCol]) {
                return new Position(newRow, newCol);
            }
        }
        return null;
    }
}