package lotto.domain.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import lotto.constants.LottoRank;

public class EarningRateCalculator {
    private static final int MIN_WINNING_COUNT = 0;
    private static final int ROUNDING_PRECISION_ROUND = 1;
    private static final int ROUNDING_PRECISION_TRUNCATE = 3;

    public static BigDecimal calculate(EnumMap<LottoRank, Integer> prizes, int purchaseMoney) {
        BigDecimal totalWinnings = calculateTotalRankAmount(prizes);
        BigDecimal earningRate = calculateEarningRateInPercentage(totalWinnings, purchaseMoney);
        return earningRate.setScale(ROUNDING_PRECISION_ROUND, RoundingMode.HALF_UP);
    }

    private static BigDecimal calculateTotalRankAmount(EnumMap<LottoRank, Integer> ranks) {
        return ranks.entrySet().stream().filter(entry -> entry.getValue() > MIN_WINNING_COUNT)
                .mapToDouble(entry -> entry.getKey().getPrizeAmount())
                .mapToObj(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal calculateEarningRate(BigDecimal totalRankAmount, int purchaseAmount) {
        return totalRankAmount.divide(BigDecimal.valueOf(purchaseAmount), ROUNDING_PRECISION_TRUNCATE,
                RoundingMode.DOWN);
    }

    private static BigDecimal calculateEarningRateInPercentage(BigDecimal totalRankAmount, int purchaseAmount) {
        BigDecimal earningRate = calculateEarningRate(totalRankAmount, purchaseAmount);
        return earningRate.multiply(BigDecimal.valueOf(100));
    }

}
