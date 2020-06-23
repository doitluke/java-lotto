package lotto;

import lotto.domain.*;
import lotto.utils.LottoShuffle;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private Money money;
    private List<Lotto> lottos;

    public LottoController(Money money, List<Lotto> selectLottos) {

        lottos = new ArrayList<Lotto>();
        lottos.addAll(selectLottos);
        this.money = money;
    }

    public void createLotto() {

        for (int i = 0; i < money.getAutoGameCount(); i++) {
            List<LottoNumber> lottoNumbers = LottoShuffle.makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        Output.printBuyLottoNumber(lottos);

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
