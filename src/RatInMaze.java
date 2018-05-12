import java.util.Arrays;

public class RatInMaze {

    private final Integer[][] inputMaze;
    private Boolean[][] solution;

    public RatInMaze(Integer[][] inputMaze) {
        this.inputMaze = inputMaze;
        solution = new Boolean[inputMaze.length][inputMaze[0].length];
        for (Boolean[] row : solution) {
            Arrays.fill(row, false);
        }
    }

    public static void main(String[] args) {
        Integer[][] inputMaze = new Integer[][] {  {1, 0, 0, 0}, {1, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 1, 1}};

        RatInMaze ratInMaze = new RatInMaze(inputMaze);

        ratInMaze.findPath(0, 0);
    }

    private void findPath(int currentRow, int currentColumn) {
        if(currentRow >= inputMaze.length || currentColumn >= inputMaze[0].length || inputMaze[currentRow][currentColumn] != 1)
            return;
        if(currentRow == inputMaze.length -1 && currentColumn == inputMaze[0].length - 1) {
            printSolution();
            return;
        }
        solution[currentRow][currentColumn] = true;
        findPath(currentRow + 1, currentColumn);
        findPath(currentRow, currentColumn + 1);
    }

    private void printSolution() {
        for (int row = 0; row < solution.length; row++) {
            for (int column = 0; column < solution[0].length; column++) {
                if(solution[row][column])
                    System.out.println(row + "-" +column);
            }

        }
    }
}
