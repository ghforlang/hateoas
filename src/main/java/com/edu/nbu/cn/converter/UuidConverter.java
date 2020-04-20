package com.edu.nbu.cn.converter;

import com.edu.nbu.cn.entity.BigIntegerPairing;

import java.math.BigInteger;
import java.util.UUID;

public class UuidConverter {

    public static BigInteger toBigInteger(UUID uuid) {
        return BigIntegerPairing.pair(
                BigInteger.valueOf(uuid.getMostSignificantBits()),
                BigInteger.valueOf(uuid.getLeastSignificantBits())
        );
    }

    public static UUID toUuid(BigInteger value) {
        BigInteger[] unpaired = BigIntegerPairing.unpair(value);
        return new UUID(unpaired[0].longValueExact(), unpaired[1].longValueExact());
    }
}
