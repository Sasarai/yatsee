package com.tvallierremy.yatzy1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public record Yatzy1(List<Integer> dices) {

    public static final int NO_POINT = 0;
    public static final int YATZY_VALUE = 50;
    public static final int SMALL_STRAIGHT_VALUE = 15;
    public static final int LARGE_STRAIGHT_VALUE = 20;

    public static final List<Integer> SMALL_STRAIGHT_CONTENT = Arrays.asList(1, 2, 3, 4, 5);
    public static final List<Integer> LARGE_STRAIGHT_CONTENT = Arrays.asList(2, 3, 4, 5, 6);

    public static Yatzy1 of(int dice1, int dice2, int dice3, int dice4, int dice5) {
        return new Yatzy1(List.of(dice1, dice2, dice3, dice4, dice5));
    }

    public int chance() {
        return sumAllDices();
    }

    public int yatzy() {
        return dices.stream().allMatch(dices.getFirst()::equals) ? YATZY_VALUE : NO_POINT;
    }

    public int ones() {
        return searchDicesWithValue(1)
            .sum();
    }

    public int twos() {
        return searchDicesWithValue(2)
            .sum();
    }

    public int threes() {
        return searchDicesWithValue(3)
            .sum();
    }

    public int fours() {
        return searchDicesWithValue(4)
            .sum();
    }

    public int fives() {
        return searchDicesWithValue(5)
            .sum();
    }

    public int sixes() {
        return searchDicesWithValue(6)
            .sum();
    }

    public int pair() {
        return getHighestGroupValue(2)
            .map(it -> it * 2)
            .orElse(NO_POINT);
    }

    public int threeOfAKind() {
        return getHighestGroupValue(3)
            .map(it -> it * 3)
            .orElse(NO_POINT);
    }

    public int fourOfAKind() {
        return getHighestGroupValue(4)
            .map(it -> it * 4)
            .orElse(NO_POINT);
    }

    public int twoPairs() {
        List<Integer> pairs = getGroupValue(2)
            .toList();
        return pairs.size() == 2 ? pairs.stream().mapToInt(it -> it * 2).sum() : NO_POINT;
    }

    public int smallStraight() {
        return new HashSet<>(dices).containsAll(SMALL_STRAIGHT_CONTENT) ? SMALL_STRAIGHT_VALUE : NO_POINT;
    }

    public int largeStraight() {
        return new HashSet<>(dices).containsAll(LARGE_STRAIGHT_CONTENT) ? LARGE_STRAIGHT_VALUE : NO_POINT;
    }

    public int fullHouse() {
        Set<Integer> distinctValues = new HashSet<>(dices);
        return distinctValues.size() == 2 ? sumAllDices() : NO_POINT;
    }

    private int sumAllDices() {
        return dices.stream().mapToInt(i -> i).sum();
    }

    private IntStream searchDicesWithValue(int value) {
        return dices.stream()
            .filter(dice -> dice == value)
            .mapToInt(i -> i);
    }

    private Map<Integer, Long> getDicesByValue() {
        return dices
            .stream()
            .collect(groupingBy(dice -> dice, Collectors.counting()));
    }

    private Stream<Integer> getGroupValue(int groupSizeNeeded) {
        Map<Integer, Long> dicesByValue = getDicesByValue();
        return dicesByValue
            .entrySet()
            .stream()
            .filter(it -> it.getValue() >= groupSizeNeeded)
            .map(Map.Entry::getKey);
    }

    private Optional<Integer> getHighestGroupValue(int groupSizeNeeded) {
        return getGroupValue(groupSizeNeeded)
            .max(Integer::compareTo);
    }
}
