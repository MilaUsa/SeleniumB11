package TESTNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
    @DataProvider(name="FullNameTest")
    public Object[][] getData(){
        return new Object[][]{
                {"mila","Miller","mila Miller"},
                {"eric","eric2","eric eric2"},
                {"mila3","Miller3","mila3 Miller3"},
                {"mila4","Miller4","mila4 Miller4"},
                {"mila5","Miller5","mila5 Miller5"},
                {"mila6","Miller6","mila6 Miller6"},
        };
    }
    @Test(dataProvider = "FullNameTest",dataProviderClass = DataForNames.class)
    public void test1(String userName,String lastName,String expectedFullName){
        String username=userName;
        String lastname=lastName;
        String fullname=username+" "+lastname;
        Assert.assertEquals(fullname,expectedFullName);
    }
//    @Test()
//    public void test2(){
//        String username="eric";
//        String lastName="eric2";
//        String fullname=username+""+lastName;
//        Assert.assertEquals(fullname,"eric eric2");
//    }
//    @Test
//    public void test3(){
//        String username="mila3";
//        String lastName="Miller3";
//        String fullname=username+""+lastName;
//        Assert.assertEquals(fullname,"Mila3 Miller3");
//    }
//    @Test
//    public void test4(){
//        String username="mila4";
//        String lastName="Miller4";
//        String fullname=username+""+lastName;
//        Assert.assertEquals(fullname,"Mila4 Miller4");
//    }
//    @Test
//    public void test5(){
//        String username="mila5";
//        String lastName="Miller5";
//        String fullname=username+""+lastName;
//        Assert.assertEquals(fullname,"Mila5 Miller5");
//    }
//    @Test
//    public void test6(){
//        String username="mila6";
//        String lastName="Miller6";
//        String fullname=username+""+lastName;
//        Assert.assertEquals(fullname,"Mila6 Miller6");
//    }
//    @Test
//    public void test7(){
//        String username="mila7";
//        String lastName="Miller7";
//        String fullname=username+""+lastName;
//        Assert.assertEquals(fullname,"Mila7 Miller7");
//    }
}
