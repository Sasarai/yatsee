package com.tvallierremy.yatzy3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.tvallierremy.yatzy2.YatzyCategory.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class Yatzy3Test {
    private final Yatzy3 yatzy = new Yatzy3();

    @Nested
    class Chance {
        @ParameterizedTest
        @MethodSource("chanceTestArguments")
        void givenDicesResult_whenEvaluateChanceScore_ShouldReturnExpectedScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, CHANCE.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> chanceTestArguments() {
            return Stream.of(
                Arguments.of(asList(1, 1, 3, 3, 6), 14),
                Arguments.of(asList(4, 5, 5, 6, 1), 21)
            );
        }
    }

    @Nested
    class Yatzy {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 6})
        void givenDicesWithSameValues_WhenEvaluateYatzyScore_ShouldReturn50points(int value) {
            int actual = yatzy.score(asList(value, value, value, value, value), YATZY.name());

            assertThat(actual).isEqualTo(50);
        }

        @Test
        void givenDicesWithSomeDifferentValues_WhenEvaluateYatzyScore_ShouldReturn0points() {
            int actual = yatzy.score(asList(1, 2, 3, 4, 5, 6), YATZY.name());

            assertThat(actual).isZero();
        }
    }

    @Nested
    class Ones {
        @ParameterizedTest
        @MethodSource("onesTestArguments")
        void givenDicesResult_whenEvaluateOnesScore_ShouldReturnAllOnesAddedAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, ONES.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> onesTestArguments() {
            return Stream.of(
                Arguments.of(asList(2, 5, 3, 3, 6), 0),
                Arguments.of(asList(1, 5, 5, 6, 3), 1),
                Arguments.of(asList(1, 1, 1, 1, 3), 4),
                Arguments.of(asList(1, 1, 1, 1, 1), 5)
            );
        }
    }

    @Nested
    class Twos {
        @ParameterizedTest
        @MethodSource("twosTestArguments")
        void givenDicesResult_whenEvaluateTwosScore_ShouldReturnAllTwosAddedAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, TWOS.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> twosTestArguments() {
            return Stream.of(
                Arguments.of(asList(1, 5, 3, 3, 6), 0),
                Arguments.of(asList(2, 5, 5, 6, 3), 2),
                Arguments.of(asList(2, 2, 2, 2, 3), 8),
                Arguments.of(asList(2, 2, 2, 2, 2), 10)
            );
        }
    }

    @Nested
    class Threes {
        @ParameterizedTest
        @MethodSource("threesTestArguments")
        void givenDicesResult_whenEvaluateThreesScore_ShouldReturnAllThreesAddedAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, THREES.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> threesTestArguments() {
            return Stream.of(
                Arguments.of(asList(1, 5, 4, 4, 6), 0),
                Arguments.of(asList(2, 5, 5, 6, 3), 3),
                Arguments.of(asList(2, 2, 3, 3, 3), 9),
                Arguments.of(asList(3, 3, 3, 3, 3), 15)
            );
        }
    }

    @Nested
    class Fours {
        @ParameterizedTest
        @MethodSource("foursTestArguments")
        void givenDicesResult_whenEvaluateFoursScore_ShouldReturnAllFoursAddedAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, FOURS.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> foursTestArguments() {
            return Stream.of(
                Arguments.of(asList(1, 5, 3, 3, 6), 0),
                Arguments.of(asList(2, 5, 4, 6, 3), 4),
                Arguments.of(asList(4, 4, 3, 3, 3), 8),
                Arguments.of(asList(4, 4, 4, 4, 4), 20)
            );
        }
    }

    @Nested
    class Fives {
        @ParameterizedTest
        @MethodSource("fivesTestArguments")
        void givenDicesResult_whenEvaluateFivesScore_ShouldReturnAllFivesAddedAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, FIVES.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> fivesTestArguments() {
            return Stream.of(
                Arguments.of(asList(1, 2, 4, 4, 6), 0),
                Arguments.of(asList(2, 5, 5, 6, 3), 10),
                Arguments.of(asList(2, 2, 5, 5, 5), 15),
                Arguments.of(asList(5, 5, 5, 5, 5), 25)
            );
        }
    }

    @Nested
    class Sixes {
        @ParameterizedTest
        @MethodSource("sixesTestArguments")
        void givenDicesResult_whenEvaluateSixesScore_ShouldReturnAllSixesAddedAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, SIXES.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> sixesTestArguments() {
            return Stream.of(
                Arguments.of(asList(1, 5, 4, 4, 2), 0),
                Arguments.of(asList(2, 5, 5, 6, 3), 6),
                Arguments.of(asList(6, 6, 3, 3, 3), 12),
                Arguments.of(asList(6, 6, 6, 6, 6), 30)
            );
        }
    }

    @Nested
    class Pair {
        @ParameterizedTest
        @MethodSource("pairTestArguments")
        void givenDicesResult_whenEvaluatePairScore_ShouldReturnSumOfHighestPairAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, PAIR.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> pairTestArguments() {
            return Stream.of(
                Arguments.of(asList(1, 2, 3, 4, 5), 0),
                Arguments.of(asList(3, 3, 3, 4, 4), 8),
                Arguments.of(asList(1, 1, 6, 2, 6), 12),
                Arguments.of(asList(3, 3, 3, 4, 1), 6),
                Arguments.of(asList(3, 3, 3, 3, 1), 6)
            );
        }
    }

    @Nested
    class TwoPairs {
        @ParameterizedTest
        @MethodSource("twoPairTestArguments")
        void givenDicesResult_whenEvaluatePairScore_ShouldReturnSumOfTwoPairAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, TWO_PAIRS.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> twoPairTestArguments() {
            return Stream.of(
                Arguments.of(asList(1, 1, 2, 3, 3), 8),
                Arguments.of(asList(1, 1, 2, 3, 4), 0),
                Arguments.of(asList(1, 1, 2, 2, 2), 6),
                Arguments.of(asList(3, 3, 3, 3, 1), 0)
            );
        }
    }

    @Nested
    class ThreeOfKind {
        @ParameterizedTest
        @MethodSource("threeOfKindTestArguments")
        void givenDicesResult_whenEvaluateThreeOfKindScore_ShouldReturnSumOfThreeOfKindAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, THREE_OF_A_KIND.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> threeOfKindTestArguments() {
            return Stream.of(
                Arguments.of(asList(3, 3, 3, 4, 5), 9),
                Arguments.of(asList(3, 3, 4, 5, 6), 0),
                Arguments.of(asList(3, 3, 3, 3, 1), 9)
            );
        }
    }

    @Nested
    class FourOfKind {
        @ParameterizedTest
        @MethodSource("fourOfKindTestArguments")
        void givenDicesResult_whenEvaluateFourOfKindScore_ShouldReturnSumOfFourOfKindAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, FOUR_OF_A_KIND.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> fourOfKindTestArguments() {
            return Stream.of(
                Arguments.of(asList(2, 2, 2, 2, 3), 8),
                Arguments.of(asList(1, 1, 2, 3, 4), 0),
                Arguments.of(asList(2, 2, 2, 2, 2), 8)
            );
        }
    }

    @Nested
    class SmallStraight {
        @ParameterizedTest
        @MethodSource("smallStraightTestArguments")
        void givenDicesResult_whenEvaluateSmallStraightScore_ShouldReturn15AsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, SMALL_STRAIGHT.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> smallStraightTestArguments() {
            return Stream.of(
                Arguments.of(asList(1, 2, 3, 4, 5), 15),
                Arguments.of(asList(1, 1, 2, 3, 4), 0)
            );
        }
    }

    @Nested
    class LargeStraight {
        @ParameterizedTest
        @MethodSource("largeStraightTestArguments")
        void givenDicesResult_whenEvaluateLargeStraightScore_ShouldReturn20AsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, LARGE_STRAIGHT.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> largeStraightTestArguments() {
            return Stream.of(
                Arguments.of(asList(2, 3, 4, 5, 6), 20),
                Arguments.of(asList(1, 1, 2, 3, 4), 0)
            );
        }
    }

    @Nested
    class FullHouse {
        @ParameterizedTest
        @MethodSource("fullHouseTestArguments")
        void givenDicesResult_whenEvaluateFullHouseScore_ShouldReturnSumOfFullHouseAsScore(List<Integer> dices, int expectedScore) {
            int actual = yatzy.score(dices, FULL_HOUSE.name());

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> fullHouseTestArguments() {
            return Stream.of(
                Arguments.of(asList(2, 2, 2, 3, 3), 12),
                Arguments.of(asList(1, 1, 2, 2, 4), 0),
                Arguments.of(asList(2, 2, 2, 2, 2), 0)
            );
        }
    }
}
