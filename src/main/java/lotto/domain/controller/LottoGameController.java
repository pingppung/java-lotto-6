package lotto.domain.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCountCalculator;
import lotto.domain.WinningLotto;
import lotto.utils.InputHandler;
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
        int purchaseAmount = InputHandler.retryInputOnInvalid(this::getLottoPurchaseAmount);

        LottoCountCalculator lottoCountCalculator = new LottoCountCalculator(purchaseAmount);
        int purchaseCount = lottoCountCalculator.calculateLottoCount();

        WinningLotto winningLotto = getWinningLotto();
    }

    private int getLottoPurchaseAmount() {
        return inputView.getPurchaseAmount();
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumber = InputHandler.retryInputOnInvalid(this::getWinningNumber);
        int bonusNumber = InputHandler.retryInputOnInvalid(this::getBonusNumber);
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private Lotto getWinningNumber() {
        List<Integer> numbers = inputView.getWinningNumber();
        return new Lotto(numbers);
    }

    private int getBonusNumber() {
        return inputView.getBonusNumber();
    }
}
