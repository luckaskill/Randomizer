package com.http.las.random;

import java.util.*;

public class RandomMain {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hi:)\nYou may start to print your options");
        while (true) {
            OptionsContainer<String> container = new OptionsContainer<>(RandomMain::getOptionsFromConsole, true);
            RandomizeResult<String> randomize = Randomizer.randomize(container, RandomMain::getRepeatCountFromConsole);
            System.out.println(randomize);
            System.out.println("Now u can try again");
        }
    }

    private static List<String> getOptionsFromConsole() {
        String option;
        List<String> optionsList = new ArrayList<>();
        while (!((option = getOptionFromConsole()).equals("do"))) {
            if (!option.trim().isEmpty()) {
                optionsList.add(option);
            }
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
