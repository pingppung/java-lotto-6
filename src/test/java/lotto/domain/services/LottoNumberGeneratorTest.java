package lotto.domain.services;

import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    private List<Integer> generatedNumbers;

    @BeforeEach
    void setUp() {
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
        generatedNumbers = numberGenerator.generate();
    }

    @DisplayName("생성된_로또_번호_개수_확인")
    @Test
    void generateLottoNumbersCount() {
        assertThat(generatedNumbers).hasSize(6);
    }

    @DisplayName("생성된_로또_번호_범위_확인")
    @Test
    void generateLottoNumbersRange() {
        assertThat(generatedNumbers).allMatch(
                number -> number >= MIN_NUMBER.getValue() && number <= MAX_NUMBER.getValue());
    }
}
