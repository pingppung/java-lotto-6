package lotto.domain;

import java.util.List;

public class LottoFactory {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoFactory(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    private Lotto createLotto() {
        List<Integer> numbers = lottoNumberGenerator.generate();
        return new Lotto(numbers);
    }

}
