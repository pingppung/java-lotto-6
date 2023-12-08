package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountCalculatorTest {

    @DisplayName("구매할_수_있는_로또_개수_계산")
    @Test
    void calculateLottoCount() {
        int testMoney = 100000;
        LottoCountCalculator lottoCountCalculator = new LottoCountCalculator(testMoney);
        int calculateCount = lottoCountCalculator.calculateLottoCount();
        assertThat(testMoney / 1000).isEqualTo(calculateCount);
    }
}
