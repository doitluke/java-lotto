package lotto;

import lotto.domain.Lotto;
import lotto.utils.InputUtils;
import lotto.utils.LottoShuffle;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {
        Input input = new Input(new Scanner(System.in));
        Output output = new Output();

        input.moneyInput();
        int buyCount = InputUtils.parserMoney(input.getMoney());
        output.printLottoCount(buyCount);

        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < buyCount; i++) {
            List lottoNumbers = LottoShuffle.makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            output.printBuyLottoNumber(lotto);
            lottos.add(lotto);
        }

        input.inputLastWinningNumber();
        List lastWinningNumbers = InputUtils.stringToArray(input.getLastLottoNumber());
        Lotto winningLotto = new Lotto(lastWinningNumbers);

    }
}
