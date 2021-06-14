package testngtests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class DoubleDivTest {

    private Calculator calculator;

    @BeforeClass(groups = {"arithmetictests"})
    public void createCalculator() {
        calculator = new Calculator();
    }

    @AfterClass(groups = {"arithmetictests"})
    public void deleteCalculator() {
        calculator = null;
    }

    @Test(dataProvider = "testParams", groups = {"arithmetictests"})
    public void doubleDivTest(double a, double b) {
        double expectedResult = a / b;
        Assert.assertEquals(calculator.div(a, b), expectedResult);
    }

    @Test(expectedExceptions = Exception.class, groups = {"arithmetictests"})
    public void divisionByZeroTest() {
        calculator.div(new Random().nextDouble(), 0);
    }

    @DataProvider(name = "testParams")
    public static Object[][] testData() {
        Object[][] testParams = new Object[3][2];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            testParams[i][0] = random.nextDouble();
            do {
                testParams[i][1] = random.nextDouble();
            } while (Double.compare(((double) testParams[i][1]), 0.0) == 0);
        }

        return testParams;
    }
}
