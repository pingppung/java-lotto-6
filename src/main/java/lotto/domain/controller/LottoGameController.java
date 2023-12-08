package lotto.domain.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int purchaseAmount = getLottoPurchaseAmount();

        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount);
        int purchaseCount = lottoPurchase.calculateLottoCount();

        WinningLotto winningLotto = getWinningLotto();
    }

    private int getLottoPurchaseAmount() {
        return inputView.getPurchaseAmount();
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumber = generateWinningNumber();
        int bonusNumber = inputView.getBonusNumber();
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private Lotto generateWinningNumber() {
        List<Integer> numbers = inputView.getWinningNumber();
        return new Lotto(numbers);
    }
}
