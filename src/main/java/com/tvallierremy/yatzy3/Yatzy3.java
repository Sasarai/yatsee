package com.tvallierremy.yatzy3;

import com.tvallierremy.yatzy3.scorer.CategoryScorer;

import java.util.Arrays;
import java.util.List;

public class Yatzy3 implements YatzyCalculator {
    @Override
    public int score(List<Integer> dice, String category) {
        return CategoryScorer.createInstance(category).calculateScore(dice);
    }
}
