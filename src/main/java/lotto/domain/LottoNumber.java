package lotto.domain;


import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    private int number;

    public LottoNumber(String numberString) {
        this(Integer.parseInt(numberString));
    }

    public LottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("LOTTO번호가 범위를 초과합니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return (number - lottoNumber.getNumber());
    }

    @Override
    public boolean equals(Object inputLottoNumber) {
        LottoNumber lottoNumber = (LottoNumber) inputLottoNumber;
        return lottoNumber.number == this.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
