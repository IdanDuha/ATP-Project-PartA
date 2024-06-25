package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm {

    Stack<AState> stack;
    Set<AState> visited;
    Map<AState, AState> predecessors;
    int nodesVisit;

    public DepthFirstSearch() {
        this.name = "DepthFirstSearch";
        this.stack = new Stack<>();
        this.visited = new HashSet<>();
        this.predecessors = new HashMap<>();
        this.nodesVisit = 0;
    }

    @Override
    public Solution solve(ISearchable iSearchable) {
        if (iSearchable == null)
            return null;

        stack.clear();
        visited.clear();
        predecessors.clear();
        nodesVisit = 0;

        AState start = iSearchable.getStartState();
        AState goal = iSearchable.getGoalState();
        if (start.equals(goal))
            return new Solution(buildSolutionPath(start));

        executeSearch(iSearchable, start, goal);

        return new Solution(null);
    }

    @Override
    public AState search(ISearchable iSearchable) {
        if (iSearchable == null)
            return null;

        stack.clear();
        visited.clear();
        predecessors.clear();
        nodesVisit = 0;

        AState start = iSearchable.getStartState();
        AState goal = iSearchable.getGoalState();
        if (start.equals(goal))
            return goal;

        executeSearch(iSearchable, start, goal);

        return goal;
    }

    protected void executeSearch(ISearchable iSearchable, AState startNode, AState goalNode) {
        stack.push(startNode);
        visited.add(startNode);

        while (!stack.isEmpty()) {
            nodesVisit++;
            AState current = stack.pop();
            if (current.equals(goalNode)) {
                return;
            }
            ArrayList<AState> successors;
            try {
                successors = iSearchable.getAllSuccessors(current);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            for (AState successor : successors) {
                if (!visited.contains(successor)) {
                    predecessors.put(successor, current);
                    stack.push(successor);
                    visited.add(successor);
                }
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return nodesVisit;
    }

    private Stack<AState> buildSolutionPath(AState goal) {
        Stack<AState> path = new Stack<>();
        AState current = goal;
        while (current != null) {
            path.push(current);
            current = predecessors.get(current);
        }
        return path;
    }
}
