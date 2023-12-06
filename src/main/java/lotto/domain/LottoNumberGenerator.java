package lotto.domain;

import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.MIN_NUMBER;
import static lotto.constants.LottoConstants.NUMBERS_PER_GAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(),
                NUMBERS_PER_GAME.getValue());
        Collections.sort(numbers);
        return numbers;
    }
}
