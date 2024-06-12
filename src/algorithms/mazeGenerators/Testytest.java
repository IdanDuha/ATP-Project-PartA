package algorithms.mazeGenerators;

public class Testytest {
    public static void main(String[] args) {
        SimpleMazeGenerator generator = new SimpleMazeGenerator();
        Maze maze = generator.generate(1, 10); // Generates a 10x10 maze

        if (maze == null) {
            System.out.println("niguhhaaaaaaaa");
        } else {
            // Display the generated maze
            for (int i = 0; i < maze.getRow(); i++) {
                for (int j = 0; j < maze.getCol(); j++) {
                    if (i == maze.GetStartingPoint().getRowIndex() && j == maze.GetStartingPoint().getColIndex()) {
                        System.out.print("S "); // Print start point as 'S'
                    } else if (i == maze.getGoalPosition().getColIndex() && j == maze.getGoalPosition().getColIndex()) {
                        System.out.print("G "); // Print goal point as 'G'
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