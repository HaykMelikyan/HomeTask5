package junittests;

import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

public class SqrtTest {

    private static Calculator calculator;
    private static final Random random = new Random();

    @BeforeClass
    public static void createCalculator() {
        calculator = new Calculator();
    }

    @AfterClass
    public static void deleteCalculator() {
        calculator = null;
    }

    @Test
    public void sqrtTest() {
        double a = Math.abs(random.nextDouble());
        double expectedResult = Math.sqrt(a);
        Assert.assertEquals(expectedResult, calculator.sqrt(a), 0.00001);
    }

    @Test
    public void lessThenZeroSqrtTest() {
        double a = random.nextDouble();
        if (a > 0) {
            a = -a;
        }
        Assert.assertTrue("sqrt of negative value is not NaN.", Double.isNaN(calculator.sqrt(a)));
    }
}
