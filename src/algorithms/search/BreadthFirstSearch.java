package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    Collection<AState> que;
    Set<AState> visited = new HashSet<>();
    Map<AState, AState> predecessors = new HashMap<>();
    int nodesVisit = 0;

    public BreadthFirstSearch() {
        super();
        name = "BFS";
        this.que = new LinkedHashSet<>();
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return nodesVisit;
    }

    @Override
    public Solution solve(ISearchable s) {
        if (s == null)
            return null;

        // Clear data in case this instance solves more than one ISearchable object
        que.clear();
        visited.clear();
        predecessors.clear();
        nodesVisit = 0;

        AState goal = s.getGoalState();
        AState current = s.getStartState();
        if (current.equals(goal))
            return new Solution(buildSolutionPath(current));

        que.add(current);
        visited.add(current);

        while (!que.isEmpty()) {
            nodesVisit++;
            current = getFirstInQue();
            ArrayList<AState> successors = s.getAllSuccessors(current);
            for (AState successor : successors) {
                if (!visited.contains(successor)) {
                    predecessors.put(successor, current);
                    if (successor.equals(goal)) {
                        return new Solution(buildSolutionPath(successor));
                    }
                    que.add(successor);
                    visited.add(successor);
                }
            }
        }
        return new Solution(null);
    }

    @Override
    public AState search(ISearchable search) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }


    private AState getFirstInQue() {
        AState first = que.iterator().next();
        que.remove(first);
        return first;
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
