package algorithms.search;

public interface ISearchingAlgorithm {
    Solution solve(ISearchable domain);

    // returns the number of the nodes that visited in the path
    int getNumberOfNodesEvaluated();

    String getName();
}