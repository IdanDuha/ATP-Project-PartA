package algorithms.search;

import java.io.Serializable;

public abstract class AState {
    private int cost;
    private AState lastmove;
    private boolean isVisited;

    public AState(int cost, AState parent) {
        this.cost = cost;
        lastmove = parent;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void setLastMove(AState lastmove) {
        this.lastmove = lastmove;
    }

    public AState getLastMove() {
        return lastmove;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    private int countVisited = 0;

    public int getCountVisited() {
        return countVisited;
    }

    public void setCountVisited(int countVisited) {
        this.countVisited = countVisited;
    }


    public abstract String toString();
}