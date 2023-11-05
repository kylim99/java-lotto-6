package lotto.controller;

import static lotto.util.validator.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.model.WinnerLotto;
import lotto.util.converter.NumericConverter;
import lotto.util.converter.NumericListConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {


    private final NumericListConverter numericListConverter = new NumericListConverter();
    private final NumericConverter numericConverter = new NumericConverter();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int amount = getAmount();
        Lottos lottos = new Lottos(buyLotto(amount));
        WinnerLotto winnerLotto = new WinnerLotto(getWinnerLotto(), getBonusNumber());
        Result result = new Result(lottos.calculateResult(winnerLotto));
        outputView.printResult(result);
        outputView.printProfitRate(result.calculateProfitRate(amount));
    }

    private int getBonusNumber() {
        String input = inputView.readBonusNumber();
        return numericConverter.convert(input);
    }

    private Lotto getWinnerLotto() {
        String input = inputView.readWinnerLottoNumbers();
        return new Lotto(numericListConverter.convert(input));
    }

    private int getAmount() {
        String input = inputView.readAmount();
        int amount = numericConverter.convert(input) / LOTTO_PRICE;
        outputView.printAmount(amount);
        return amount;
    }

    private List<Lotto> buyLotto(int count) {
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_LENGTH)))
                .collect(Collectors.toList());
        outputView.printLottoInformation(lottos);
        return lottos;
    }


}
