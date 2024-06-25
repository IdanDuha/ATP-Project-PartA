package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Solution implements Serializable {

    private ArrayList<AState> states;

    public Solution(Stack<AState> path) {
        this.states = new ArrayList<>();
        this.setStates(path);
    }

    public void setStates(Stack<AState> arrayList) {
        while (!arrayList.isEmpty())
            this.states.add(arrayList.pop());
    }

    public ArrayList<AState> getSolutionPath() {
        return states;
    }
}
