package P05Lists;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> finalList = new ArrayList<>();

        int minSize = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < minSize; i++) {
            finalList.add(firstList.get(i));
            finalList.add(secondList.get(i));
        }

        if (firstList.size() > secondList.size()) {
            finalList.addAll(firstList.subList(minSize, firstList.size()));
        } else {
            finalList.addAll(secondList.subList(minSize, secondList.size()));
        }
        for (int num : finalList) {
            System.out.print(num + " ");
        }


//        if (firstList.size() >= secondList.size()) {
//            for (int i = 0; i < firstList.size(); i++) {
//
//                if (i >= secondList.size()) {
//                    finalList.add(firstList.get(i));
//                    continue;
//                }
//                finalList.add(firstList.get(i));
//                finalList.add(secondList.get(i));
//
//            }
//        } else {
//            for (int i = 0; i < secondList.size(); i++) {
//
//                if (i >= firstList.size()) {
//                    finalList.add(secondList.get(i));
//                    continue;
//                }
//                finalList.add(firstList.get(i));
//                finalList.add(secondList.get(i));
//
//            }
//        }
//        for (int num : finalList) {
//            System.out.print(num + " ");
//        }
    }
}
