package lotto.constants;

public enum LottoRank {
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prizeAmount;
    private final boolean bonus;

    LottoRank(int matchCount, int prizeAmount, boolean bonus) {
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
}
