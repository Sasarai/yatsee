package com.tvallierremy.yatzy3.scorer;

import com.tvallierremy.yatzy3.utils.DiceRollUtil;

import java.util.List;
import java.util.Map;

public class RepeatedCountScorer extends CategoryScorer {
    private final int count;

    public RepeatedCountScorer(int count) {
        this.count = count;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = DiceRollUtil.frequencies(dice);

        return frequencies.entrySet().stream()
            .filter(it -> it.getValue() >= count)
            .max(Map.Entry.comparingByKey())
            .map(it -> it.getKey() * count)
            .orElse(NO_POINT);
    }
}
