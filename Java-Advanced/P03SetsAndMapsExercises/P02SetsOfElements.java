package P03SetsAndMapsExercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lengths = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int nLength = lengths[0];
        LinkedHashSet<String> nSet = new LinkedHashSet<>();

        for (int i = 0; i < nLength; i++) {
            nSet.add(scanner.nextLine());
        }

        int mLength = lengths[1];
        LinkedHashSet<String> mSet = new LinkedHashSet<>();

        for (int i = 0; i < mLength; i++) {
            mSet.add(scanner.nextLine());
        }

//        for (String element : nSet) {
//            if (mSet.contains(element)) {
//                System.out.print(element + " ");
//            }
//        }
        nSet.retainAll(mSet);
        nSet.forEach(e -> System.out.print(e + " "));
        //System.out.println(String.join(" ",nSet));
    }
}
