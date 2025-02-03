package com.tvallierremy.yatzy3.scorer;

import com.tvallierremy.yatzy3.utils.DiceRollUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TwoPairsScorer extends CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = DiceRollUtil.frequencies(dice);
        int score = NO_POINT;
        if (DiceRollUtil.frequencies(dice).values().stream().filter(f -> f >= 2).toList().size() == 2) {
            score = Stream.of(6, 5, 4, 3, 2, 1)
                .mapToInt(i -> i)
                .filter(i -> frequencies.get(i) >= 2)
                .map(i -> i * 2)
                .sum();
        }
        return score;
    }
}
