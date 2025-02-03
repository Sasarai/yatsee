package com.tvallierremy.yatzy3.scorer;

import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

public abstract class StraightScorer extends CategoryScorer {
    public static StraightScorer createStraightScorer(Strategy strategy) {
        return switch (strategy) {
            case SMALL -> new SmallStraightScorer();
            case LARGE -> new LargeStraightScorer();
        };
    }

    public enum Strategy {
        SMALL, LARGE
    }

    public static class SmallStraightScorer extends StraightScorer {
        private static final List<Integer> STRAIGHT_CONTENT = asList(1, 2, 3, 4, 5);

        @Override
        public int calculateScore(List<Integer> dice) {
            return new HashSet<>(dice).containsAll(STRAIGHT_CONTENT) ? 15 : 0;
        }
    }

    public static class LargeStraightScorer extends StraightScorer {
        private static final List<Integer> STRAIGHT_CONTENT = asList(2, 3, 4, 5, 6);

        @Override
        public int calculateScore(List<Integer> dice) {
            return new HashSet<>(dice).containsAll(STRAIGHT_CONTENT) ? 20 : 0;
        }
    }
}
