package rates.api.operation;


import java.math.BigDecimal;


public class RatePrecisionChecker {

    private static int calculatePrecision(BigDecimal rate) {
        return rate.precision();
    }

    private static boolean isValueGreaterThanZero(BigDecimal rate){
        if(rate.compareTo(BigDecimal.ZERO) > 0){
            return true;
        }
        return false;
    }

    public static boolean isCorrectPrecision(BigDecimal rate) {
        if (rate != null && isValueGreaterThanZero(rate)) {
            if (calculatePrecision(rate) <= 6) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
