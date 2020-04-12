package com.http.las.random;

import java.util.*;

public class RandomizeResult<T> {
    public static final String SPLIT = " - ";
    private Map<T, Long> result;

    public RandomizeResult(Map<T, Long> result) {
        this.result = result;
    }

    public void sortByValues() {
        List<Map.Entry<T, Long>> entries = new ArrayList<>(result.entrySet());
        Comparator<Map.Entry<T, Long>> comparator = Map.Entry.comparingByValue();
        Comparator<Map.Entry<T, Long>> reversed = comparator.reversed();
        entries.sort(reversed);
        Map<T, Long> sortedResult = new LinkedHashMap<>(entries.size());
        for (Map.Entry<T, Long> entry : entries) {
            sortedResult.put(entry.getKey(), entry.getValue());
        }
        this.result = sortedResult;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        result.forEach((key, value) -> stringBuilder.append(key).append(SPLIT).append(value).append("\n"));
        return stringBuilder.toString();
    }

}
