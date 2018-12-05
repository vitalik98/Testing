import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void isTriangleCorrectConditionsReturnTrue(){
        Assert.assertTrue(Triangle.isTriangle(3,4,5));
    }
    @Test
    public void isTriangleInvalidConditionsReturnFalse(){
        Assert.assertFalse(Triangle.isTriangle(10,2,3));
    }
    @Test
    public void isTriangleSumOfTwoSidesEqualsThirdReturnTrue(){
        Assert.assertTrue(Triangle.isTriangle(3,3,4));
    }
    @Test
    public void isTriangleThreeEqualSidesReturnTrue(){
        Assert.assertTrue(Triangle.isTriangle(5,5,5));
    }
    @Test
    public void isTriangleFirstEqualsZeroReturnFalse() {
        Assert.assertFalse(Triangle.isTriangle(0, 1, 2));
    }
    @Test
    public void isTriangleSecondEqualsZeroReturnFalse(){
        Assert.assertFalse(Triangle.isTriangle(1,0,2));
    }
    @Test
    public void isTriangleThirdEqualsZeroReturnFalse(){
        Assert.assertFalse(Triangle.isTriangle(1,2,0));
    }
    @Test
    public void isTriangleFirstIsNegativeReturnFalse(){
        Assert.assertFalse(Triangle.isTriangle(-1,2,3));
    }
    @Test
    public void isTriangleSecondIsNegativeReturnFalse(){
        Assert.assertFalse(Triangle.isTriangle(1,-2,3));
    }
    @Test
    public void isTriangleThirdIsNegativeReturnFalse(){
        Assert.assertFalse(Triangle.isTriangle(1,2,-3));
    }
}
