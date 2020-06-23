package lotto;

import lotto.domain.*;
import lotto.utils.LottoShuffle;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_GAME_PRICE;

public class LottoController {

    private Money money;
    private List<Lotto> lottos;

    public LottoController(Money money) {

        lottos = new ArrayList<Lotto>();
        this.money = money;
    }

    public void createLotto() {

        for (int i = 0; i < money.getBuyCount(); i++) {
            List<LottoNumber> lottoNumbers = LottoShuffle.makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            Output.printBuyLottoNumber(lotto);
            lottos.add(lotto);
        }

    }


    public WinningLottoResult matchLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        WinningLottoResult lottoResult = new WinningLottoResult();
        for (Lotto lotto : lottos) {
            Match contain = lotto.isContain(bonusNumber);
            int count = lotto.matchCount(winningLotto);
            lottoResult.match(count, contain);
        }
        return lottoResult;
    }

}
