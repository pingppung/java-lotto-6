package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constants.PromptConstants;
import lotto.domain.validator.LottoNumberValidator;
import lotto.domain.validator.PurchaseAmountValidator;
import lotto.utils.InputValidator;
import lotto.utils.Parser;

public class InputView {

    public int getPurchaseAmount() {
        String input = inputWithPrompt(PromptConstants.INPUT_PURCHASE_AMOUNT);
        int amount = InputValidator.validateNonNumeric(input);
        PurchaseAmountValidator.validatePositiveNumber(amount);
        PurchaseAmountValidator.validateNotDivisibleByThousand(amount);
        return amount;
    }

    public List<Integer> getWinningNumber() {
        String input = inputWithPrompt(PromptConstants.INPUT_WINNING_NUMBERS);
        List<Integer> numbers = Parser.parseWinnginNumbers(input);
        LottoNumberValidator.validateNumbersInRange(numbers);
        return numbers;
    }

    public int getBonusNumber() {
        String input = inputWithPrompt(PromptConstants.INPUT_BONUS_NUMBER);
        int bonusNumber = InputValidator.validateNonNumeric(input);
        LottoNumberValidator.validateNumberInRange(bonusNumber);
        return bonusNumber;
    }

    private String inputWithPrompt(PromptConstants prompt) {
        System.out.println(prompt.message);
        return Console.readLine().trim();
    }
}
