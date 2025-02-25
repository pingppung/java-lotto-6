package lotto.enums;

public enum LottoPrize {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int matchCount;
    private final boolean bonus;
    private final int prizeAmount;

    LottoPrize(int matchCount, int prizeAmount, boolean bonus) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.bonus = bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoPrize calculate(int matchCount, boolean bonus) {
        if (SECOND.isMatchCountEqual(matchCount) && bonus) {
            return SECOND;
        }
        for (LottoPrize rank : values()) {
            if (rank.isMatchCountEqual(matchCount) && rank != SECOND) {
                return rank;
            }
        }
        return null;
    }

    private boolean isMatchCountEqual(int matchCount) {
        return this.matchCount == matchCount;
    }
}
