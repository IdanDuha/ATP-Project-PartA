package algorithms.search;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected Solution solution;
    protected HashMap<String, AState> states;
    protected AbstractQueue<AState> visited;

    abstract public Solution solve(ISearchable origin);

    @Override
    public String getName() {
        return getClass().getName();
    }

    @Override
    public int getNumberOfNodesEvaluated() {   //returns the number of cells we passed
        if (solution == null) {
            return 0;
        }
        return solution.getSolutionPath().size();
    }

    public Solution backTrackingToStartState(AState goalState) {    //back track the solution path from the last Astate

        ArrayList<AState> solutionPath = new ArrayList<>();
        solutionPath.add(goalState);
        AState current = goalState;
        while (current.getLastMove() != null) {
            solutionPath.add(current.getLastMove());
            current = current.getLastMove();
        }
        ArrayList<AState> finalsolutionPath = new ArrayList<>();

        int i;
        for (i = solutionPath.size() - 1; i >= 0; i--) {
            finalsolutionPath.add(solutionPath.get(i));
        }
        return new Solution(finalsolutionPath);
    }

    public long measureAlgorithmTimeMillisSearch(ISearchable is) {
        long start = System.currentTimeMillis();
        try {
            this.solve(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }


}