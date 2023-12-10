package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @DisplayName("입력값을 쉼표 기준으로 정확히 분리되는지 확인")
    @Test
    void validateParseWinnginNumbers() {
        String input = "1,2,3";
        List<Integer> expectedResult = List.of(1, 2, 3);
        assertThat(Parser.parseWinnginNumbers(input)).isEqualTo(expectedResult);
    }

    @DisplayName("금액을 천 단위로 포맷팅 확인")
    @Test
    void formatMoneyCurrency() {
        BigDecimal amount = new BigDecimal("2000000000");
        String formattedAmount = Parser.formatMoneyCurrency(amount);
        assertEquals("2,000,000,000", formattedAmount);
    }

    @DisplayName("수익률 계산 후 소수점 첫째 자리 표현 확인")
    @Test
    void formatProfitCurrency() {
        BigDecimal amount = new BigDecimal("1234.567");
        String formattedAmount = Parser.formatProfitCurrency(amount);
        assertEquals("1,234.6", formattedAmount);
    }
}
