package exercice3Dice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DiceScoreTest {
    DiceScore ds;
    private De de;

    @BeforeEach
    public void setup() {
        de = Mockito.mock(De.class);
        ds = new DiceScore(de);
    }

    @Test
    public void TestDiceScoreWhenGetScore_IfDeGetRollReturn10_ThenResult_30() {
        //Arrange
        int expected = 30;
        Mockito.when(de.getRoll()).thenReturn(10);

        //Act
        int result = ds.getScore();

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestDiceScoreWhenGetScore_IfDeGetRollReturn6_ThenResult_30() {
        //Arrange
        int expected = 30;
        Mockito.when(de.getRoll()).thenReturn(6);

        //Act
        int result = ds.getScore();

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestDiceScoreWhenGetScore_IfDeGetRollReturn10And15_ThenResult_15() {
        //Arrange
        int expected = 15;
        Mockito.when(de.getRoll()).thenReturn(10, 15);
        //Act
        int result = ds.getScore();

        //Assert
        Assertions.assertEquals(expected, result);
    }
}
