package SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertIntro {
    public int getsum(int num1, int num2){
        return num1+num2;
    }
    @Test
    public void test(){
        Assert.assertEquals(getsum(2,6),8);
        System.out.println("test1");
        Assert.assertEquals(getsum(0,0),0);
        System.out.println("test2");
        Assert.assertEquals(getsum(-6,-7),-13);
        System.out.println("test3");
    }
    @Test
    public void test2(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(getsum(2,6),8);
        System.out.println("test1");

        softAssert.assertEquals(getsum(0,0),0);
        System.out.println("test2");
        softAssert.assertEquals(getsum(-6,-7),-13);
        System.out.println("test3");
        //this is for this scene
        softAssert.assertAll();
    }

}
