package algorithms.search;

public abstract class AState {
    private String state;
    private double cost;
    private AState cameFrom;
    public boolean isVisited;
    private int distance;

    public AState(double cost, String preState) {
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCameFrom(AState cameFrom) {
        this.cameFrom = cameFrom;
    }

    public void setIsVisited() {
        this.isVisited = true;
    }

    ;

    public int getDistance() {
        return this.distance;
    }

    public AState getCameFrom() {
        return this.cameFrom;
    }

    public boolean isVisited() {
        return this.isVisited;
    }

    //    public abstract void updateVisited();
    public void setDistance(int distance) {
        this.distance = distance;
    }

    ;


}