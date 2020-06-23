package lotto;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {

        Money money = Input.inputMoney();

        int selectCount = Input.inputSelectLottoCount();
        money.resetBuyCount(selectCount);

        List<Lotto> selectLottos = Input.inputSelectLottonumber(selectCount);
        Output.printAutoCountSelectCount(money);

        LottoController lottoController = new LottoController(money, selectLottos);
        lottoController.createLotto();

        Lotto winningLotto = new Lotto(Input.inputLastWinningNumber());

        LottoNumber bonusNumber = Input.inputLastBonusNumber();
        winningLotto.duplicateBonusNumber(bonusNumber);

        WinningLottoResult lottoResult = lottoController.matchLotto(winningLotto, bonusNumber);

        Output.printResultStatic(lottoResult, money.getAutoGameCount());


    }
}
