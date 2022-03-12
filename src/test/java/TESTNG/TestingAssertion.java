package TESTNG;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestingAssertion {

    public double multiple(double a, double b){
        return a*b;
    }
    @Test
    public void validation(){
        double actualResult=multiple(5,6);
        double exxpectResult=30;
        //if(actualResult==exxpectResult){
        //System.out.println("passed");
        //}
        Assert.assertEquals(actualResult,exxpectResult,"My numbers are 5 and 6");
    }
  public double getDivision(double num1,double num2){
        if(num1>num2){
            return num1/num2;
        }
        return num2/num1;
  }
  public int substraction(int num1, int num2){
      if(num1>=num2){
          return num1-num2;
      }
      return num2-num1;

  }
  @Test
    public void validateDivision(){
        double actualResult=getDivision(8,2);
        double expectedResult=4;
        Assert.assertEquals(actualResult,expectedResult);

  }
  @Test
    public void validateSubstraction(){
        int actualResult=substraction(65,43);
        int expectResult=22;
        Assert.assertEquals(actualResult,expectResult);
  }
}
