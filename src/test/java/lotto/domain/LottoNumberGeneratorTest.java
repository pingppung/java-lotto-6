package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    private LottoNumberGenerator numberGenerator;
    private List<Integer> generatedNumbers;

    @BeforeEach
    void setUp() {
        numberGenerator = new LottoNumberGenerator();
        generatedNumbers = numberGenerator.generate();
    }

    @DisplayName("생성된_로또_번호_개수_확인")
    @Test
    void generateLottoNumbersCount() {

        assertThat(generatedNumbers).hasSize(6);
    }


}
