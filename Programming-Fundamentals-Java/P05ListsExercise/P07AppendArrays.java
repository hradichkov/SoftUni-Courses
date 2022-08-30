package P05ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listSeparatedByPipe = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(listSeparatedByPipe);

        System.out.println(listSeparatedByPipe.toString().replaceAll("[\\[\\],]", "")
                .replaceAll("\\s+", " ")
                .trim());
    }
}
