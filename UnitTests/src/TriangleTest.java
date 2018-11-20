import org.junit.Test;

import org.junit.Assert;

public class TriangleTest {
    //1
    @Test
    public void getTriangleCorrectConditionsReturnTrue(){
        Assert.assertTrue(Triangle.getTriangle(3,4,5));
    }
    //2
    @Test
    public void getTriangleInvalidConditionsReturnFalse(){
        Assert.assertFalse(Triangle.getTriangle(10,2,3));
    }
    //3
    @Test
    public void GetTriangleSumOfTwoSidesEqualsThirdReturnTrue(){
        Assert.assertTrue(Triangle.getTriangle(3,3,4));
    }
    //4
    @Test
    public void getTriangleThreeEqualSidesReturnTrue(){
        Assert.assertTrue(Triangle.getTriangle(5,5,5));
    }
    //5
    @Test
    public void getTriangleFirstEqualsZeroReturnFalse(){
        Assert.assertFalse(Triangle.getTriangle(0,1,2));
    }
    //6
    @Test
    public void getTriangleSecondEqualsZeroReturnFalse(){
        Assert.assertFalse(Triangle.getTriangle(1,0,2));
    }
    //7
    @Test
    public void getTriangleThirdEqualsZeroReturnFalse(){
        Assert.assertFalse(Triangle.getTriangle(1,2,0));
    }
    //8
    @Test
    public void getTriangleFirstIsNegativeReturnFalse(){
        Assert.assertFalse(Triangle.getTriangle(-1,2,3));
    }
    //9
    @Test
    public void getTriangleSecondIsNegativeReturnFalse(){
        Assert.assertFalse(Triangle.getTriangle(1,-2,3));
    }
    //10
    @Test
    public void getTriangleThirdIsNegativeReturnFalse(){
        Assert.assertFalse(Triangle.getTriangle(1,2,-3));
    }
}