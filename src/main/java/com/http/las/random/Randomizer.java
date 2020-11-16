package com.http.las.random;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Randomizer {
    private static Random random = new Random(System.currentTimeMillis());

    public static <T> RandomizeResult<T> randomize(HasOptions<T> options, int repeatCount) {
        List<? extends T> optionsList = options.getOptions();
        List<T> randomResultList = getRandomResult(repeatCount, optionsList);
        Map<T, Long> result = randomResultList.stream()
                .collect(Collectors.groupingBy((n) -> n, Collectors.counting()));
        putNonSelectedData(optionsList, result);
        return new RandomizeResult<>(result);
    }

    private static <T> void putNonSelectedData(List<? extends T> optionsList, Map<T, Long> result) {
        optionsList.forEach((o -> {
            if (!result.containsKey(o)) {
                result.put(o, 0L);
            }
        }));
    }

    private static <T> List<T> getRandomResult(int repeatCount, List<? extends T> optionsList) {
        List<T> randomResultList = new ArrayList<>();
        for (int i = 0; i < repeatCount; i++) {
            T t = chooseOne(optionsList);
            randomResultList.add(t);
        }
        return randomResultList;
    }

    public static <T> RandomizeResult<T> randomize(HasOptions<T> options, Supplier<Integer> repeatCountSupplier) {
        Integer repeatCount = repeatCountSupplier.get();
        return randomize(options, repeatCount);
    }

    private static <T> T chooseOne(List<? extends T> list) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
