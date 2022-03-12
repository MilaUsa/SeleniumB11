package TESTNG;

import org.testng.annotations.DataProvider;

public class DataForNames {
    @DataProvider(name = "FullNameTest")
    public Object[][] getData() {
        return new Object[][]{
                {"mila", "Miller", "mila Miller"},
                {"eric", "eric2", "eric eric2"},
                {"mila3", "Miller3", "mila3 Miller3"},
                {"mila4", "Miller4", "mila4 Miller4"},
                {"mila5", "Miller5", "mila5 Miller5"},
                {"mila6", "Miller6", "mila6 Miller6"},
        };
    }
}