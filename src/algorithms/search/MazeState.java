package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {
    private Position position;


    public MazeState(Position position, double cost, String state) {
        super(cost, state);
        this.position = position;
    }


    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass())
            return false;
        else {
            MazeState mzo = (MazeState) o;
            return position.equals(mzo.position);
        }
    }


    @Override
    public int hashCode() {
        return super.getState() != null ? super.getState().hashCode() : 0;
    }


    @Override
    public String toString() {
        return position.toString();
    }

    //getter method of the position.
    public Position getPosition() {
        return position;
    }

    //setter method of the position.
    public void setPosition(Position position) throws Exception {
        if (position.getRowIndex() < 0 || position.getColIndex() < 0) {
            throw new Exception("Invalid inputs: Position in Maze must have positives indexes/n");
        }
        this.position = position;
    }
}