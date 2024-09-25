import org.example.DiceScore;
import org.example.Ide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DiceScoreTest {
    private DiceScore diceScore;
    private Ide de;

    @BeforeEach
    public void setup (){
        de = Mockito.mock(Ide.class);
        diceScore = new DiceScore(de);
    }

    @Test
    public void TestDiceScoreWhen2DiceAreEquals_DeValues5_ThenScore_20(){
        //Arrange
        int expected = 20;
        Mockito.when(de.getRoll()).thenReturn(5);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void TestDiceScoreWhen2DiceAreEquals_DeValues6_ThenScore_30(){
        //Arrange
        int expected = 30;
        Mockito.when(de.getRoll()).thenReturn(6);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void TestDiceScoreWhen2DiceAreDifferent_DeValue6_DeValue4_ThenScore_6(){
        //Arrange
        int expected = 6;
        Mockito.when(de.getRoll()).thenReturn(6).thenReturn(4);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assertions.assertEquals(expected,result);
    }
}
