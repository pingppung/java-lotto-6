package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @DisplayName("입력값을_쉼표_기준으로_정확히_분리되는지_확인")
    @Test
    void validateParseWinnginNumbers() {
        String input = "1,2,3";
        List<Integer> expectedResult = List.of(1, 2, 3);
        assertThat(Parser.parseWinnginNumbers(input)).isEqualTo(expectedResult);
    }
}
