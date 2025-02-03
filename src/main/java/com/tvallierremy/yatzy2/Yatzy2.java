package com.tvallierremy.yatzy2;

import com.tvallierremy.yatzy2.scoring.ScoringSystem;

import java.util.List;

public record Yatzy2(ScoringSystem scoringSystem) implements YatzyCalculator {
    @Override
    public int score(List<Integer> dices, String category) {
        return scoringSystem.evaluate(category, dices);
    }
}
