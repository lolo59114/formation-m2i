package exercice5bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FrameTest {
    private Frame frame;
    private Roll roll;

    @BeforeEach
    public void setup() {
        roll = Mockito.mock(Roll.class);
    }

    @Test
    public void TestFrameRoll_SimpleFrame_FirstRoll_6_CheckScore_Is_6 () {
        frame = new Frame(roll, false);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(6);
        int expectedScore = 6;
        frame.makeRoll(roll);
        Assertions.assertEquals(expectedScore, frame.getScore());
    }

    @Test
    public void TestFrameRoll_SimpleFrame_SecondRoll_3_CheckScore_9 () {
        int expectedScore = 9;
        frame = new Frame(roll, false);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(6);
        frame.makeRoll(roll);
        Mockito.when(roll.randomPin(4)).thenReturn(3);
        frame.makeRoll(roll);
        Assertions.assertEquals(expectedScore, frame.getScore());
    }

    @Test
    public void TestFrameRoll_SimpleFrame_SecondRoll_FirstRollStrike_ReturnFalse() {
        frame = new Frame(roll, false);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(10);
        Assertions.assertFalse(frame.makeRoll(roll));
    }

    @Test
    public void TestFrameRoll_SimpleFrame_MoreRolls_ReturnFalse() {
        frame = new Frame(roll, false);
        Mockito.when(roll.randomPin(frame.MAX_PINS - frame.getScore())).thenReturn(1);
        boolean result = true;
        for(int i = 0; i<4; i++) {
            result = frame.makeRoll(roll);
        }
        Assertions.assertFalse(result);
    }

    @Test
    public void TestFrameRoll_LastFrame_SecondRoll_FirstRollStrike_ReturnTrue() {
        frame = new Frame(roll, true);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(10);
        Assertions.assertTrue(frame.makeRoll(roll));
    }

    @Test
    public void TestFrameRoll_LastFrame_SecondRoll_FirstRollStrike_CheckScore() {
        int expectedScore = 13;
        frame = new Frame(roll, true);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(10).thenReturn(3);
        frame.makeRoll(roll);
        frame.makeRoll(roll);
        Assertions.assertEquals(expectedScore, frame.getScore());
    }

    @Test
    public void TestFrameRoll_LastFrame_ThirdRoll_FirstRollStrike_ReturnTrue() {
        frame = new Frame(roll, true);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(10).thenReturn(2);
        frame.makeRoll(roll);
        Assertions.assertTrue(frame.makeRoll(roll));
    }

    @Test
    public void TestFrameRoll_LastFrame_ThirdRoll_FirstRollStrick_CheckScore() {
        int expectedScore = 15;
        frame = new Frame(roll, true);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(10).thenReturn(2);
        Mockito.when(roll.randomPin(8)).thenReturn(3);
        frame.makeRoll(roll);
        frame.makeRoll(roll);
        frame.makeRoll(roll);
        Assertions.assertEquals(expectedScore, frame.getScore());
    }

    @Test
    public void TestFrameRoll_LastFrame_ThirdRoll_Spare_ReturnTrue() {
        frame = new Frame(roll, true);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(2);
        Mockito.when(roll.randomPin(8)).thenReturn(8);
        frame.makeRoll(roll);
        Assertions.assertTrue(frame.makeRoll(roll));
    }

    @Test
    public void TestFrameRoll_LastFrame_ThirdRoll_Spare_CheckScore() {
        int expectedScore = 15;
        frame = new Frame(roll, true);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(5);
        Mockito.when(roll.randomPin(5)).thenReturn(5);
        frame.makeRoll(roll);
        frame.makeRoll(roll);
        frame.makeRoll(roll);
        Assertions.assertEquals(expectedScore, frame.getScore());
    }

    @Test
    public void TestFrameRoll_LastFrame_FourthRoll_ReturnFalse() {
        frame = new Frame(roll, true);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(5);
        Mockito.when(roll.randomPin(5)).thenReturn(5);
        frame.makeRoll(roll);
        frame.makeRoll(roll);
        Assertions.assertFalse(frame.makeRoll(roll));
    }

    @Test
    public void TestFrameRoll_LastFrame_ThirdRoll_NotSpare_ReturnFalse() {
        frame = new Frame(roll, true);
        Mockito.when(roll.randomPin(frame.MAX_PINS)).thenReturn(2);
        Mockito.when(roll.randomPin(8)).thenReturn(7);
        frame.makeRoll(roll);
        Assertions.assertFalse(frame.makeRoll(roll));
    }
}
