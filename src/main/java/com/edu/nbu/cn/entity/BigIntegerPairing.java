package com.edu.nbu.cn.entity;

import java.math.BigInteger;
import java.util.function.Function;

public class BigIntegerPairing {
    private static final BigInteger HALF = BigInteger.ONE.shiftLeft(64); // 2^64
    private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);

    private static Function<BigInteger, BigInteger> toUnsigned = value
            -> value.signum() < 0 ? value.add(HALF) : value;
    private static Function<BigInteger, BigInteger> toSigned =
            value -> MAX_LONG.compareTo(value) < 0 ? value.subtract(HALF) : value;

    public static BigInteger pair(BigInteger hi, BigInteger lo) {
        BigInteger unsignedLo = toUnsigned.apply(lo);
        BigInteger unsignedHi = toUnsigned.apply(hi);
        return unsignedLo.add(unsignedHi.multiply(HALF));
    }

    public static BigInteger[] unpair(BigInteger value) {
        BigInteger[] parts = value.divideAndRemainder(HALF);
        BigInteger signedHi = toSigned.apply(parts[0]);
        BigInteger signedLo = toSigned.apply(parts[1]);
        return new BigInteger[]{signedHi, signedLo};
    }
}
