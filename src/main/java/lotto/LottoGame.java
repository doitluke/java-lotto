package lotto;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {
        
        Money money = Input.inputMoney();

        int selectCount = Input.inputSelectLottoCount();
        money.resetBuyCount(selectCount);

        List<Lotto> selectLottos = Input.inputSelectLottonumber(selectCount);
        Output.printAutoCountSelectCount(money);

        LottoController lottoController = new LottoController(money, selectLottos);
        lottoController.createLotto();

        WinningLotto winningLotto = Input.inputLastWinningNumber();
        WinningLottoResult lottoResult = lottoController.matchLotto(winningLotto);

        Output.printResultStatic(lottoResult, money.getAutoGameCount());

    }
}
