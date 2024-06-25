package algorithms.search;

public interface ISearchingAlgorithm {
    public Solution solve(ISearchable solve);

    public AState search(ISearchable search);

    public String getName();

    public int getNumberOfNodesEvaluated();
}