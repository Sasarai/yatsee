package com.tvallierremy.yatzy3.scorer;

import com.tvallierremy.yatzy3.*;

import java.util.List;

public abstract class CategoryScorer {
    protected static final Integer NO_POINT = 0;

    public static CategoryScorer createInstance(String categoryName) {
        YatzyCategory category = YatzyCategory.valueOf(categoryName);
        return switch (category) {
            case CHANCE -> new ChanceScorer();
            case YATZY -> new YatzyPointsScorer();
            case ONES -> new NumberScorer(1);
            case TWOS -> new NumberScorer(2);
            case THREES -> new NumberScorer(3);
            case FOURS -> new NumberScorer(4);
            case FIVES -> new NumberScorer(5);
            case SIXES -> new NumberScorer(6);
            case PAIR -> new RepeatedCountScorer(2);
            case THREE_OF_A_KIND -> new RepeatedCountScorer(3);
            case FOUR_OF_A_KIND -> new RepeatedCountScorer(4);
            case SMALL_STRAIGHT -> StraightScorer.createStraightScorer(StraightScorer.Strategy.SMALL);
            case LARGE_STRAIGHT -> StraightScorer.createStraightScorer(StraightScorer.Strategy.LARGE);
            case TWO_PAIRS -> new TwoPairsScorer();
            case FULL_HOUSE -> new FullHouseScorer();
        };
    }

    public abstract int calculateScore(List<Integer> dice);

}
