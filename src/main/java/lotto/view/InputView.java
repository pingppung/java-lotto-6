package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.validator.LottoNumberValidator;
import lotto.domain.validator.PurchaseAmountValidator;
import lotto.utils.InputValidator;
import lotto.utils.Parser;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public int getPurchaseAmount() {
        String input = inputWithPrompt(PURCHASE_AMOUNT_PROMPT);
        int amount = InputValidator.validateNonNumeric(input);
        PurchaseAmountValidator.validatePositiveNumber(amount);
        PurchaseAmountValidator.validateNotDivisibleByThousand(amount);
        return amount;
    }

    public List<Integer> getWinningNumber() {
        String input = inputWithPrompt(WINNING_NUMBER_PROMPT);
        List<Integer> numbers = Parser.parseWinnginNumbers(input);
        LottoNumberValidator.validateNumbersInRange(numbers);
        return numbers;
    }

    public int getBonusNumber() {
        String input = inputWithPrompt(BONUS_NUMBER_PROMPT);
        int bonusNumber = InputValidator.validateNonNumeric(input);
        LottoNumberValidator.validateNumberInRange(bonusNumber);
        return bonusNumber;
    }

    private String inputWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine().trim();
    }
}
