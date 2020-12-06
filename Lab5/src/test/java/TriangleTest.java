import exception.TriangleException;
import model.TriangleType;
import model.TriangleValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleTest {

    @DataProvider
    public static Object[][] positiveCase() {
        return new Object[][]{
                {5.5, 3.2, 2.7},
                {8, 4, 6},
                {12, 13, 5}
        };
    }

    @DataProvider
    public static Object[][] negativeCase() {
        return new Object[][]{
                {1, 2, 3},
                {6, 6, 12},
                {1, 12, 14}
        };
    }

    @DataProvider
    public static Object[][] negativeSide() {
        return new Object[][]{
                {-5, 3, 2.7},
                {6, -4, 6},
                {-10, -8, 5}
        };
    }

    @DataProvider
    public static Object[][] zeroSide() {
        return new Object[][]{
                {0, 3, 3},
                {13, 0, 12},
                {0, 0, 0}
        };
    }

    @DataProvider
    public static Object[][] rightTriangle() {
        return new Object[][]{
                {3, 4, 5},
                {12, 13, 5},
                {1.5, 2, 2.5}
        };
    }

    @DataProvider
    public static Object[][] isoscelesTriangle() {
        return new Object[][]{
                {6, 6, 10},
                {4.4, 4.4, 7},
                {2, 2, 3.5}
        };
    }

    @DataProvider
    public static Object[][] equilateralTriangle() {
        return new Object[][]{
                {10, 10, 10},
                {5.5, 5.5, 5.5},
                {3, 3, 3}
        };
    }

    @DataProvider
    public static Object[][] versatileTriangle() {
        return new Object[][]{
                {7, 8, 9},
                {6.14, 7.5, 6.25},
                {15, 14, 12}
        };
    }

    @DataProvider
    public static Object[][] bigSides() {
        return new Object[][]{
                {111111111111d, 111111111111d, 111111111111d},
                {Double.MAX_VALUE - 3, Double.MAX_VALUE - 4, Double.MAX_VALUE - 5},
        };
    }

    @DataProvider
    public static Object[][] smallSides() {
        return new Object[][]{
                {0.00000003d, 0.00000003d, 0.00000003d},
                {Double.MIN_VALUE * 4, Double.MIN_VALUE * 4, Double.MIN_VALUE * 5},
        };
    }

    @Test(dataProvider = "positiveCase")
    public void testIsValidTrianglePositive(double a, double b, double c) throws Exception {
        Assert.assertTrue(TriangleValidator.isTriangle(a, b, c));
    }

    @Test(dataProvider = "negativeCase",
            expectedExceptions = TriangleException.class,
            expectedExceptionsMessageRegExp = "Not a triangle.")
    public void testIsValidTriangleNegative(double a, double b, double c) throws Exception {
        TriangleValidator.getType(a, b, c);
    }

    @Test(dataProvider = "negativeSide",
            expectedExceptions = TriangleException.class,
            expectedExceptionsMessageRegExp = "Sides can't be negative.")
    public void testIsValidTriangleNegativeSide(double a, double b, double c) throws Exception {
        TriangleValidator.isTriangle(a, b, c);
    }

    @Test(dataProvider = "zeroSide",
            expectedExceptions = TriangleException.class,
            expectedExceptionsMessageRegExp = "Sides can't be zero.")
    public void testIsValidTriangleZeroSide(double a, double b, double c) throws Exception {
        TriangleValidator.isTriangle(a, b, c);
    }

    @Test(dataProvider = "rightTriangle")
    public void testIdRightTriangle(double a, double b, double c) throws Exception {
        Assert.assertEquals(TriangleValidator.getType(a, b, c), TriangleType.RIGHT);
    }

    @Test(dataProvider = "isoscelesTriangle")
    public void testIdIsoscelesTriangle(double a, double b, double c) throws Exception {
        Assert.assertEquals(TriangleValidator.getType(a, b, c), TriangleType.ISOSCELES);
    }

    @Test(dataProvider = "equilateralTriangle")
    public void testIdEquilateralTriangle(double a, double b, double c) throws Exception {
        Assert.assertEquals(TriangleValidator.getType(a, b, c), TriangleType.EQUILATERAL);
    }

    @Test(dataProvider = "versatileTriangle")
    public void testIdVersatileTriangle(double a, double b, double c) throws Exception {
        Assert.assertEquals(TriangleValidator.getType(a, b, c), TriangleType.VERSATILE);
    }

    @Test(dataProvider = "bigSides")
    public void testIsValidTriangleBigSides(double a, double b, double c) throws Exception {
        Assert.assertTrue(TriangleValidator.isTriangle(a, b, c));
    }

    @Test(dataProvider = "smallSides")
    public void testIsValidTriangleSmallSides(double a, double b, double c) throws Exception {
        Assert.assertTrue(TriangleValidator.isTriangle(a, b, c));
    }
}
