package lotto.services;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCountCalculator;
import lotto.domain.LottoFactory;

public class LottoPurchaseService {
    private final LottoFactory lottoFactory;
    private final LottoCountCalculator lottoCountCalculator;

    public LottoPurchaseService(int purchaseAmount) {
        this.lottoFactory = new LottoFactory();
        this.lottoCountCalculator = new LottoCountCalculator(purchaseAmount);
    }

    public List<Lotto> purchaseLottos() {
        int numberOfLottos = calculateLottoCount();
        return lottoFactory.generateLottos(numberOfLottos);
    }

    private int calculateLottoCount() {
        return lottoCountCalculator.calculateLottoCount();
    }
}
