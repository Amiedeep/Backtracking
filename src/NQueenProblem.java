import java.util.Arrays;

public class NQueenProblem {
    private final int boardSize;
    private Integer[][] sol;

    public NQueenProblem(int boardSize) {
        this.boardSize = boardSize;
        sol = new Integer[boardSize][boardSize];
        for (Integer[] row : sol) {
            Arrays.fill(row, 0);
        }
    }

    public static void main(String[] args) {
        NQueenProblem nQueenProblem = new NQueenProblem(8);

        if(nQueenProblem.findSolution(0)) {
            nQueenProblem.printSolution();
        }
    }

    private boolean findSolution(int column) {
        if(column == boardSize)
            return true;
        for (int row = 0; row < boardSize; row++) {
            if(isSafe(row, column)) {
                sol[row][column] = 1;
                if(findSolution(column + 1)) {
                    return true;
                }
                sol[row][column] = 0;
            }
        }
        return false;
    }

    private void printSolution() {
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                System.out.print(sol[row][column] + " ");
            }
            System.out.println();
        }
    }

    private boolean isSafe(int row, int column) {
        for (int i = 0; i < boardSize; i++)
            if(sol[row][i] == 1)
                return false;
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--)
            if (sol[i][j] == 1)
                return false;
        for (int i = row, j = column; i < boardSize && j >= 0; i++, j--)
            if (sol[i][j] == 1)
                return false;

        return true;
    }
}
