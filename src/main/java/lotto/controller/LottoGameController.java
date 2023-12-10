package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import lotto.constants.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.services.LottoWinningChecker;
import lotto.services.LottoPurchaseService;
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

        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(purchaseAmount);
        List<Lotto> purchasedLottos = lottoPurchaseService.purchaseLottos();

        WinningLotto winningLotto = getWinningLotto();

    }

    private int getLottoPurchaseAmount() {
        return inputView.getPurchaseAmount();
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumber = InputHandler.retryInputOnInvalid(this::getWinningNumber);
        return InputHandler.retryInputOnInvalid(() -> {
            int bonusNumber = InputHandler.retryInputOnInvalid(this::getBonusNumber);
            return new WinningLotto(winningNumber, bonusNumber);
        });
    }

    private Lotto getWinningNumber() {
        List<Integer> numbers = inputView.getWinningNumber();
        return new Lotto(numbers);
    }

    private int getBonusNumber() {
        return inputView.getBonusNumber();
    }

    private EnumMap<LottoRank, Integer> calculateWinningRanks(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(purchasedLottos, winningLotto);
        lottoWinningChecker.updateRankCount();
        return lottoWinningChecker.getRankCount();
    }
}
