package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.io.Serializable;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable, Serializable {
    Maze maze;

    public SearchableMaze(Maze maze) {
        try {
            if (maze == null) {
                throw new IllegalArgumentException("Invalid Maze");
            }
            this.maze = maze;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<AState> getAllPossibleStates(AState a)     //returns all the states that are reachable
    {
        ArrayList<AState> statelist = new ArrayList<AState>();
        MazeState m = (MazeState) a;
        Position pos = m.getPosition();
        int x = pos.getRowIndex();
        int y = pos.getColIndex();
        int cols = maze.getCol();
        int rows = maze.getRow();
        if (x > 0 && maze.getValue(x - 1, y) != 1) {
            Position newPos = new Position(x - 1, y);
            MazeState M = new MazeState(newPos, m, 10);
            statelist.add(M);
        }


        if (x < rows - 1 && maze.getValue(x + 1, y) != 1) {
            Position newPos = new Position(x + 1, y);
            MazeState mState = new MazeState(newPos, m, 10);
            statelist.add(mState);
        }

        if (y > 0 && maze.getValue(x, y - 1) != 1) {
            Position newPos = new Position(x, y - 1);
            MazeState mState = new MazeState(newPos, m, 10);
            statelist.add(mState);
        }

        if (y < cols - 1 && maze.getValue(x, y + 1) != 1) {
            Position newPos = new Position(x, y + 1);
            MazeState mState = new MazeState(newPos, m, 10);
            statelist.add(mState);
        }

        if (x > 0 && y > 0 && maze.getValue(x - 1, y - 1) != 1 && (maze.getValue(x, y - 1) != 1 || maze.getValue(x - 1, y) != 1)) {
            Position newPos = new Position(x - 1, y - 1);
            MazeState mState = new MazeState(newPos, m, 15);
            statelist.add(mState);
        }

        if (x < rows - 1 && y < cols - 1 && maze.getValue(x + 1, y + 1) != 1 && (maze.getValue(x, y + 1) != 1 || maze.getValue(x + 1, y) != 1)) {
            Position newPos = new Position(x + 1, y + 1);
            MazeState mState = new MazeState(newPos, m, 15);
            statelist.add(mState);
        }

        if (x < rows - 1 && y > 0 && maze.getValue(x + 1, y - 1) != 1 && (maze.getValue(x + 1, y) != 1 || maze.getValue(x, y - 1) != 1)) {
            Position newPos = new Position(x + 1, y - 1);
            MazeState mState = new MazeState(newPos, m, 15);
            statelist.add(mState);
        }

        if (x > 0 && y < cols - 1 && maze.getValue(x - 1, y + 1) != 1 && (maze.getValue(x, y + 1) != 1 || maze.getValue(x - 1, y) != 1)) {
            Position newPos = new Position(x - 1, y + 1);
            MazeState mState = new MazeState(newPos, m, 15);
            statelist.add(mState);
        }


        return statelist;

    }

    @Override
    public MazeState getStartState() {
        return new MazeState(maze.getStartPosition(), null, 0);
    }

    @Override
    public MazeState getGoalState() {
        return new MazeState(maze.getGoalPosition(), null, 0);
    }

    public Maze returnMaze() {
        return maze;
    }
}