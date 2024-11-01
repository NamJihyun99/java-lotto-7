package lotto.domain;

import java.math.BigInteger;

import static lotto.exception.ExceptionCode.MONEY_TOO_SMALL;
import static lotto.exception.ExceptionCode.REMAINDER_EXISTED;

public class Money {

    private final BigInteger value;
    public static final BigInteger LOTTO_PRICE = new BigInteger("1000");

    public Money(BigInteger value) {
        validate(value);
        this.value = value;
    }

    private void validate(BigInteger value) {
        if (value.compareTo(LOTTO_PRICE) < 0) {
            throw new IllegalArgumentException(MONEY_TOO_SMALL.message());
        }

        if (!value.remainder(LOTTO_PRICE).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException(REMAINDER_EXISTED.message());
        }
    }
}
