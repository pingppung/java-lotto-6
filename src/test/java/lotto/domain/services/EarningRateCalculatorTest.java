package lotto.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import lotto.constants.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EarningRateCalculatorTest {
    @DisplayName("로또 구매 후 당첨 상금에 대한 수익률을 올바르게 계산")
    @Test
    public void calculateEarningRate() {

        int purchaseMoney = 8000;
        EnumMap<LottoRank, Integer> prizes = new EnumMap<>(LottoRank.class);
        prizes.put(LottoRank.SECOND, 0);
        prizes.put(LottoRank.THIRD, 0);
        prizes.put(LottoRank.FOURTH, 0);
        prizes.put(LottoRank.FIFTH, 1);

        BigDecimal result = EarningRateCalculator.calculate(prizes, purchaseMoney);
        BigDecimal expected = BigDecimal.valueOf(62.5).setScale(1, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }
}
