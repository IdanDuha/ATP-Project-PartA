package algorithms.mazeGenerators;

public class Testytest {
    public static void main(String[] args) {
        MyMazeGenerator generator = new MyMazeGenerator();
        Maze maze = generator.generate(10, 10); // Generates a 10x10 maze
        System.out.println(String.format("Maze generation time(ms): %s", generator.measureAlgorithmTimeMillis(1000, 1000)));

        if (maze == null) {
            System.out.println("niguhhaaaaaaaa");
        } else {
            // Display the generated maze
            for (int i = 0; i < maze.getRow(); i++) {
                for (int j = 0; j < maze.getCol(); j++) {
                    if (i == maze.getStartPosition().getRowIndex() && j == maze.getStartPosition().getColIndex()) {
                        System.out.print("S "); // Print start point as 'S'
                    } else if (i == maze.getGoalPosition().getRowIndex() && j == maze.getGoalPosition().getColIndex()) {
                        System.out.print("E "); // Print goal point as 'G'
                    } else if (maze.getMaze()[i][j] == 1) {
                        System.out.print("1 "); // Print walls as '#'
                    } else {
                        System.out.print("0 "); // Print paths as '.'
                    }
                }
                System.out.println();
            }
        }
    }
}