package testngtests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class DoubleMultTest {

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
    public void doubleMultTest(double a, double b) {
        double expectedResult = a * b;
        Assert.assertEquals(calculator.mult(a, b), expectedResult);
    }

    @DataProvider(name = "testParams")
    public static Object[][] testData() {
        Object[][] testParams = new Object[3][2];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            testParams[i][0] = random.nextDouble();
            testParams[i][1] = random.nextDouble();
        }

        return testParams;
    }
}
