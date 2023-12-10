package lotto.domain.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountCalculatorTest {

    @DisplayName("구매할 수 있는 로또 개수 계산")
    @Test
    void calculateLottoCount() {
        int testMoney = 100000;
        LottoCountCalculator lottoCountCalculator = new LottoCountCalculator(testMoney);
        int calculateCount = lottoCountCalculator.calculateLottoCount();
        assertThat(testMoney / 1000).isEqualTo(calculateCount);
    }
}
