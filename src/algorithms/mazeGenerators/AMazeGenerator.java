package algorithms.mazeGenerators;

import java.util.Random;

public abstract class AMazeGenerator implements IMazeGenerator {

    public long measureAlgorithmTimeMillis(int row, int col) {
        long startTime = System.currentTimeMillis();
        generate(row, col);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public Position setPointonEdge(int row, int col) {
        Random rand = new Random();
        int rowIndex = rand.nextInt(row);
        int colIndex;
        if (rowIndex == 0 || rowIndex == row - 1) {
            colIndex = rand.nextInt(col); // Include the last column
        } else {
            colIndex = rand.nextBoolean() ? 0 : col - 1; // Correct the column range
        }
        return new Position(rowIndex, colIndex);
    }
}