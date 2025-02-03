package com.tvallierremy.yatzy2.utils;

import com.tvallierremy.yatzy2.DiceValue;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class DiceUtils {
    public static Map<DiceValue, Long> getDiceFrequencies(List<Integer> dices) {
        return dices.stream()
            .collect(groupingBy(
                DiceValue::getFromValue,
                Collectors.counting()
            ));
    }

    public static int diceRollSum(Map<DiceValue, Long> diceFrequencies) {
        return diceFrequencies.entrySet().stream()
            .reduce(0,
                (sum, entry) -> Math.toIntExact(sum + (entry.getValue() * entry.getKey().getValue())),
                Integer::sum
            );
    }

    private DiceUtils() {}
}
