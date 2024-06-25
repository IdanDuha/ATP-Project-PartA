package algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected int nodeEvaluationCount;
    protected String name;

    protected ASearchingAlgorithm() {
        this.nodeEvaluationCount = 0;
    }

    public int getNodeEvaluationCount() {
        return nodeEvaluationCount;
    }

    @Override
    public Solution solve(ISearchable searchable) {
        if (searchable == null) {
            return null;
        }

        AState startNode = searchable.getStartState();
        AState goalNode = searchable.getGoalState();
        Stack<AState> solutionNodes = new Stack<>();
        this.nodeEvaluationCount = 0;

        if (startNode.equals(goalNode)) {
            solutionNodes.add(goalNode);
            this.nodeEvaluationCount = 1;
            return new Solution(solutionNodes);
        }

        //     executeSearch(startNode, goalNode);

        AState currentNode = goalNode;
        while (currentNode != null) {
            solutionNodes.add(0, currentNode);
            currentNode = currentNode.getCameFrom();
        }

        return new Solution(solutionNodes);
    }

    // protected abstract void executeSearch(AState startNode, AState goalNode);
}