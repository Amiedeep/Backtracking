import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

public class TugOfWar {


    private final int[] input;
    private final int inputSum;
    private int[] solution;
    private int solutionDifference = Integer.MAX_VALUE;

    public TugOfWar(int[] input) {
        this.input = input;
        this.inputSum= IntStream.of(input).sum();
//        solution = new int[input.length/2 + input.length%2];
//        Arrays.fill(solution, 0);
    }

    public static void main(String[] args) {
        int input[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};

        TugOfWar tugOfWar = new TugOfWar(input);

        tugOfWar.findSolution();
        tugOfWar.printSolution();
    }

    private void printSolution() {
        Arrays.stream(solution).forEach(System.out::println);
    }

    private void findSolution() {
        int subsetSize = input.length/2 + input.length%2;
        int[] currentSolution = new int[subsetSize];
        findSolutionRecursively(currentSolution, 0, 0);
    }

    private void findSolutionRecursively(int[] currentSolution, int solutionIndex, int inputIndex) {
        if(inputIndex >= input.length)
            return;
        int currentSum = Arrays.stream(currentSolution).sum();
        if(solutionIndex == currentSolution.length) {
            int currentSolutionDifference = abs(currentSum - (inputSum/2));
            if(currentSolutionDifference < solutionDifference) {
                solutionDifference = currentSolutionDifference;
                solution = Arrays.copyOf(currentSolution, currentSolution.length);
            }
            return;
        }

        currentSolution[solutionIndex] = input[inputIndex];
        findSolutionRecursively(currentSolution, solutionIndex + 1, inputIndex + 1);

        currentSolution[solutionIndex] = 0;
        findSolutionRecursively(currentSolution, solutionIndex, inputIndex + 1);
    }
}
