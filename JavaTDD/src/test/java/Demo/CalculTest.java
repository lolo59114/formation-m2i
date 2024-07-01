package Demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculTest {
    private Calcul calcul;

    @Test
    public void TestCalculWhenAddition_1_2_ThenResult_3 () {
        //Arrange
        calcul = new Calcul();
        double x = 1;
        double y = 2;
        //Act
        double result = calcul.addition(x, y);
        //Assert
        Assertions.assertEquals(3, result);
    }

    @Test
    public void TestCalculWhenDivision_30_10_ThenResult_3 () {
        //Arrange
        calcul = new Calcul();
        double x = 30;
        double y = 10;
        //Act
        double result = calcul.division(x, y);
        //Assert
        Assertions.assertEquals(3, result);
    }
}
