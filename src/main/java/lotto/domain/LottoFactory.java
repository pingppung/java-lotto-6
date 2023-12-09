package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.services.LottoNumberGenerator;

public class LottoFactory {
    private final LottoNumberGenerator lottoNumberGenerator;
    private static final int INITIAL_VALUE = 0;

    public LottoFactory() {
        this.lottoNumberGenerator = new LottoNumberGenerator();
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
