package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShuffle {

    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int NEED_LOTTO_COUNT = 6;

    private LottoShuffle() {
    }

    public static List makeLottoNumber() {
        List<Integer> lottoGameNumber = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoGameNumber);
        List<Integer> lottoNumbers = lottoGameNumber.stream().limit(NEED_LOTTO_COUNT).collect(Collectors.toList());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }


}
