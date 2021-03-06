package rates.api.test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import rates.api.operation.RatePrecisionChecker;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class RatePrecisionCheckerTest {

    @Parameters({
            "0.000000000248808",
            "0.00000248808",
            "0.000248808",
            "0.00248808",
            "0.0248808",
            "0.248808",
            "2.48808",
            "24.8808",
            "248.808",
            "2488.08",
            "24880.8"
    })
    @Test
    public void shouldCheckPrecisionOfTheRates(BigDecimal rate){
        assertTrue(RatePrecisionChecker.isCorrectPrecision(rate));
    }

    @Parameters({
            "0.0000000002488088",
            "0.02488088",
            "2.488088",
            "24.88088",
            "248.8088",
            "2488.088",
            "24880.88",
            "248808.8",
            "1234567.0"
    })
    @Test
    public void shouldCheckPrecisionForIncorrectRates(BigDecimal rate){
        assertFalse(RatePrecisionChecker.isCorrectPrecision(rate));
    }

}
