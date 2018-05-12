import java.util.Arrays;

public class StringPermutations {
    private final String input;
    private Boolean[] isVisited;

    public StringPermutations(String input) {
        this.input = input;
        isVisited = new Boolean[input.length()];
        Arrays.fill(isVisited, false);
    }

    public static void main(String[] args) {
        StringPermutations stringPermutations = new StringPermutations("abc");
        stringPermutations.printPermutationsRecursively("");
    }

    private void printPermutationsRecursively(String currentString) {
        if(currentString.length() == input.length())
            System.out.println(currentString);

        for (int i = 0; i < input.length(); i++) {
            if(!isVisited[i]) {
               isVisited[i] = true;
               printPermutationsRecursively(currentString.concat(String.valueOf(input.charAt(i))));
               isVisited[i] = false;
            }
        }
    }
}
