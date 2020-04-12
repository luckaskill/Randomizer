package com.http.las.random;

import java.util.*;

public class RandomMain {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OptionsContainer<String> container = new OptionsContainer<>(RandomMain::getOptionsFromConsole, true);
        RandomizeResult<String> randomize = Randomizer.randomize(container, RandomMain::getRepeatCountFromConsole);
        randomize.sortByValues();
        System.out.println(randomize);
    }

    private static List<String> getOptionsFromConsole() {
        String option;
        List<String> optionsList = new ArrayList<>();
        while (!((option = getOptionFromConsole()).equals("do"))) {
            optionsList.add(option);
        }
        System.out.println(optionsList);
        return optionsList;
    }

    private static String getOptionFromConsole() {
        return scanner.nextLine();
    }

    private static int getRepeatCountFromConsole() {
        System.out.println("Print repeat count: ");
        return scanner.nextInt();
    }
}
