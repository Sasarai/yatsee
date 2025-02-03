package com.tvallierremy.yatzy1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Yatzy1Test {

    @Nested
    class ChanceScoreCalculator {
        @ParameterizedTest(name = "CHANCE - Expect score {1} for dice roll {0}")
        @MethodSource("chanceTestArguments")
        void givenDicesResult_whenEvaluateChanceScore_ShouldReturnExpectedScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.chance();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> chanceTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {1, 1, 3, 3, 6}, 14),
                Arguments.of(new int[] {4, 5, 5, 6, 1}, 21)
            );
        }
    }

    @Nested
    class Yatzy {
        @ParameterizedTest(name = "YATZY - Expect score 50 for dice roll {0}")
        @ValueSource(ints = {1, 2, 3, 4, 5, 6})
        void givenDicesWithSameValues_WhenEvaluateYatzyScore_ShouldReturn50points(int value) {
            Yatzy1 yatzy1 = Yatzy1.of(value, value, value, value, value);

            int actual = yatzy1.yatzy();

            assertThat(actual).isEqualTo(50);
        }

        @Test
        @DisplayName("YATZY - Expect score 0 if all values are not the same")
        void givenDicesWithSomeDifferentValues_WhenEvaluateYatzyScore_ShouldReturn0points() {
            Yatzy1 yatzy1 = Yatzy1.of(1, 2, 3, 4, 5);

            int actual = yatzy1.yatzy();

            assertThat(actual).isZero();
        }
    }

    @Nested
    class Ones {
        @ParameterizedTest(name = "ONES - Expect score {1} for dice roll {0}")
        @MethodSource("onesTestArguments")
        void givenDicesResult_whenEvaluateOnesScore_ShouldReturnAllOnesAddedAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.ones();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> onesTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {2, 5, 3, 3, 6}, 0),
                Arguments.of(new int[] {1, 5, 5, 6, 3}, 1),
                Arguments.of(new int[] {1, 1, 1, 1, 3}, 4),
                Arguments.of(new int[] {1, 1, 1, 1, 1}, 5)
            );
        }
    }

    @Nested
    class Twos {
        @ParameterizedTest(name = "TWOS - Expect score {1} for dice roll {0}")
        @MethodSource("twosTestArguments")
        void givenDicesResult_whenEvaluateTwosScore_ShouldReturnAllTwosAddedAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.twos();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> twosTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {1, 5, 3, 3, 6}, 0),
                Arguments.of(new int[] {2, 5, 5, 6, 3}, 2),
                Arguments.of(new int[] {2, 2, 2, 2, 3}, 8),
                Arguments.of(new int[] {2, 2, 2, 2, 2}, 10)
            );
        }
    }

    @Nested
    class Threes {
        @ParameterizedTest(name = "THREES - Expect score {1} for dice roll {0}")
        @MethodSource("threesTestArguments")
        void givenDicesResult_whenEvaluateThreesScore_ShouldReturnAllThreesAddedAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.threes();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> threesTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {1, 5, 4, 4, 6}, 0),
                Arguments.of(new int[] {2, 5, 5, 6, 3}, 3),
                Arguments.of(new int[] {2, 2, 3, 3, 3}, 9),
                Arguments.of(new int[] {3, 3, 3, 3, 3}, 15)
            );
        }
    }

    @Nested
    class Fours {
        @ParameterizedTest(name = "FOURS - Expect score {1} for dice roll {0}")
        @MethodSource("foursTestArguments")
        void givenDicesResult_whenEvaluateFoursScore_ShouldReturnAllFoursAddedAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.fours();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> foursTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {1, 5, 3, 3, 6}, 0),
                Arguments.of(new int[] {2, 5, 4, 6, 3}, 4),
                Arguments.of(new int[] {4, 4, 3, 3, 3}, 8),
                Arguments.of(new int[] {4, 4, 4, 4, 4}, 20)
            );
        }
    }

    @Nested
    class Fives {
        @ParameterizedTest(name = "FIVES - Expect score {1} for dice roll {0}")
        @MethodSource("fivesTestArguments")
        void givenDicesResult_whenEvaluateFivesScore_ShouldReturnAllFivesAddedAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.fives();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> fivesTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {1, 2, 4, 4, 6}, 0),
                Arguments.of(new int[] {2, 5, 5, 6, 3}, 10),
                Arguments.of(new int[] {2, 2, 5, 5, 5}, 15),
                Arguments.of(new int[] {5, 5, 5, 5, 5}, 25)
            );
        }
    }

    @Nested
    class Sixes {
        @ParameterizedTest(name = "SIXES - Expect score {1} for dice roll {0}")
        @MethodSource("sixesTestArguments")
        void givenDicesResult_whenEvaluateSixesScore_ShouldReturnAllSixesAddedAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.sixes();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> sixesTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {1, 5, 4, 4, 2}, 0),
                Arguments.of(new int[] {2, 5, 5, 6, 3}, 6),
                Arguments.of(new int[] {6, 6, 3, 3, 3}, 12),
                Arguments.of(new int[] {6, 6, 6, 6, 6}, 30)
            );
        }
    }

    @Nested
    class Pair {
        @ParameterizedTest(name = "PAIR - Expect score {1} for dice roll {0}")
        @MethodSource("pairTestArguments")
        void givenDicesResult_whenEvaluatePairScore_ShouldReturnSumOfHighestPairAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.pair();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> pairTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 5}, 0),
                Arguments.of(new int[] {3, 3, 3, 4, 4}, 8),
                Arguments.of(new int[] {1, 1, 6, 2, 6}, 12),
                Arguments.of(new int[] {3, 3, 3, 4, 1}, 6),
                Arguments.of(new int[] {3, 3, 3, 3, 1}, 6)
            );
        }
    }

    @Nested
    class TwoPairs {
        @ParameterizedTest(name = "TWO PAIR - Expect score {1} for dice roll {0}")
        @MethodSource("twoPairTestArguments")
        void givenDicesResult_whenEvaluatePairScore_ShouldReturnSumOfTwoPairAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.twoPairs();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> twoPairTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {1, 1, 2, 3, 3}, 8),
                Arguments.of(new int[] {1, 1, 2, 3, 4}, 0),
                Arguments.of(new int[] {1, 1, 2, 2, 2}, 6),
                Arguments.of(new int[] {3, 3, 3, 3, 1}, 0)
            );
        }
    }

    @Nested
    class ThreeOfKind {
        @ParameterizedTest(name = "THREE OF KIND - Expect score {1} for dice roll {0}")
        @MethodSource("threeOfKindTestArguments")
        void givenDicesResult_whenEvaluateThreeOfKindScore_ShouldReturnSumOfThreeOfKindAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.threeOfAKind();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> threeOfKindTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {3, 3, 3, 4, 5}, 9),
                Arguments.of(new int[] {3, 3, 4, 5, 6}, 0),
                Arguments.of(new int[] {3, 3, 3, 3, 1}, 9)
            );
        }
    }

    @Nested
    class FourOfKind {
        @ParameterizedTest(name = "FOUR OF KIND - Expect score {1} for dice roll {0}")
        @MethodSource("fourOfKindTestArguments")
        void givenDicesResult_whenEvaluateFourOfKindScore_ShouldReturnSumOfFourOfKindAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.fourOfAKind();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> fourOfKindTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {2, 2, 2, 2, 3}, 8),
                Arguments.of(new int[] {1, 1, 2, 3, 4}, 0),
                Arguments.of(new int[] {2, 2, 2, 2, 2}, 8)
            );
        }
    }

    @Nested
    class SmallStraight {
        @ParameterizedTest(name = "SMALL STRAIGHT - Expect score {1} for dice roll {0}")
        @MethodSource("smallStraightTestArguments")
        void givenDicesResult_whenEvaluateSmallStraightScore_ShouldReturn15AsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.smallStraight();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> smallStraightTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 5}, 15),
                Arguments.of(new int[] {1, 1, 2, 3, 4}, 0)
            );
        }
    }

    @Nested
    class LargeStraight {
        @ParameterizedTest(name = "LARGE STRAIGHT - Expect score {1} for dice roll {0}")
        @MethodSource("largeStraightTestArguments")
        void givenDicesResult_whenEvaluateLargeStraightScore_ShouldReturn20AsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.largeStraight();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> largeStraightTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {2, 3, 4, 5, 6}, 20),
                Arguments.of(new int[] {1, 1, 2, 3, 4}, 0)
            );
        }
    }

    @Nested
    class FullHouse {
        @ParameterizedTest(name = "FULL HOUSE - Expect score {1} for dice roll {0}")
        @MethodSource("fullHouseTestArguments")
        void givenDicesResult_whenEvaluateFullHouseScore_ShouldReturnSumOfFullHouseAsScore(int[] dices, int expectedScore) {
            Yatzy1 yatzy1 = Yatzy1.of(dices[0], dices[1], dices[2], dices[3], dices[4]);

            int actual = yatzy1.fullHouse();

            assertThat(actual).isEqualTo(expectedScore);
        }

        public static Stream<Arguments> fullHouseTestArguments() {
            return Stream.of(
                Arguments.of(new int[] {2, 2, 2, 3, 3}, 12),
                Arguments.of(new int[] {1, 1, 2, 2, 4}, 0),
                Arguments.of(new int[] {2, 2, 2, 2, 2}, 0)
            );
        }
    }
}
