package lotto.domain.services;

import java.math.BigDecimal;
import java.util.EnumMap;
import lotto.constants.LottoRank;

public class EarningRateCalculator {
    private static BigDecimal calculateTotalPrizeAmount(EnumMap<LottoRank, Integer> ranks) {
        return ranks.entrySet().stream().filter(entry -> entry.getValue() > 0)
                .mapToDouble(entry -> entry.getKey().getPrizeAmount())
                .mapToObj(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
