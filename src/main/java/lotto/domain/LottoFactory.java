package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private final LottoNumberGenerator lottoNumberGenerator;
    private static final int INITIAL_VALUE = 0;

    public LottoFactory(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    private Lotto createLotto() {
        List<Integer> numbers = lottoNumberGenerator.generate();
        return new Lotto(numbers);
    }

    public List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = INITIAL_VALUE; count < numberOfLottos; count++) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
        }
        return lottos;
    }
}
