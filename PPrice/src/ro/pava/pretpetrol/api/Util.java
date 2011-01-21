package ro.pava.pretpetrol.api;

import java.math.BigDecimal;

public final class Util {

    public static final BigDecimal recomputeAvg(BigDecimal oldAvg, int oldCount, BigDecimal newValue) {
        if (oldAvg == null) {
            return newValue;
        }
        return oldAvg.multiply(BigDecimal.valueOf(oldCount)).add(newValue).divide(BigDecimal.valueOf(oldCount + 1));
    }

    private Util() {
    }
}
