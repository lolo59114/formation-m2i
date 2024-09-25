package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FrameTest {

    private Frame frame;
    private IGenerateur generateur;

    @Test
    public void Roll_SimpleFrame_FirstRoll_CheckScore(){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,false);
        int max = 10;
        int score = 4;
        Mockito.when(generateur.randomPin(max)).thenReturn(score);

        //Act
        frame.makeRoll();

        //Assert
        Assertions.assertEquals(score,frame.getScore());
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_CheckScore (){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,false);
        int max = 10;
        int scoreFirstTurn = 4;
        int scoreSecondTurn = 3;
        int score = scoreFirstTurn + scoreSecondTurn;
        Mockito.when(generateur.randomPin(max)).thenReturn(scoreFirstTurn);
        Mockito.when(generateur.randomPin(max-scoreFirstTurn)).thenReturn(scoreSecondTurn);

        //Act
        frame.makeRoll();
        frame.makeRoll();

        //Assert
        Assertions.assertEquals(score,frame.getScore());
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_FirstRollStrick_ReturnFalse (){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,false);
        int max = 10;
        int score = 10;
        Mockito.when(generateur.randomPin(max)).thenReturn(score);

        //Act
        frame.makeRoll();
        boolean result = frame.makeRoll();

        //Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void Roll_SimpleFrame_MoreRolls_ReturnFalse (){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,false);
        int max = 10;
        int scoreFirstTurn = 4;
        int scoreSecondTurn = 3;
        Mockito.when(generateur.randomPin(max)).thenReturn(scoreFirstTurn);
        Mockito.when(generateur.randomPin(max-scoreFirstTurn)).thenReturn(scoreSecondTurn);

        //Act
        frame.makeRoll();
        frame.makeRoll();
        boolean result = frame.makeRoll();

        //Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void Roll_LastFrame_SecondRoll_FirstRollStrick_ReturnTrue (){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,true);
        int max = 10;
        int score = 10;
        Mockito.when(generateur.randomPin(max)).thenReturn(score);

        //Act
        frame.makeRoll();
        boolean result = frame.makeRoll();

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void Roll_LastFrame_SecondRoll_FirstRollStrick_CheckScore (){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,true);
        int max = 10;
        int scorefirstTurn = 10;
        int scoreSecondTurn =4;
        int score = scoreSecondTurn + scorefirstTurn;
        Mockito.when(generateur.randomPin(max)).thenReturn(scorefirstTurn).thenReturn(scoreSecondTurn);

        //Act
        frame.makeRoll();
        frame.makeRoll();

        //Assert
        Assertions.assertEquals(score,frame.getScore());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_FirstRollStrick_ReturnTrue (){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,true);
        int max = 10;
        int scorefirstTurn = 10;
        int scoreSecondTurn =4;
        int scoreThirdTurn = 3;
        Mockito.when(generateur.randomPin(max)).thenReturn(scorefirstTurn).thenReturn(scoreSecondTurn);
        Mockito.when(generateur.randomPin(max-scoreSecondTurn)).thenReturn(scoreThirdTurn);
        //Act
        frame.makeRoll();
        frame.makeRoll();
        boolean result = frame.makeRoll();

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_FirstRollStrick_CheckScore (){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,true);
        int max = 10;
        int scorefirstTurn = 10;
        int scoreSecondTurn =4;
        int scoreThirdTurn = 3;
        int score = scoreSecondTurn + scorefirstTurn+ scoreThirdTurn;
        Mockito.when(generateur.randomPin(max)).thenReturn(scorefirstTurn).thenReturn(scoreSecondTurn);
        Mockito.when(generateur.randomPin(max-scoreSecondTurn)).thenReturn(scoreThirdTurn);
        //Act
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();

        //Assert
        Assertions.assertEquals(score,frame.getScore());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_Spare_ReturnTrue (){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,true);
        int max = 10;
        int scoreFirstTurn = 4;
        int scoreSecondTurn = 6;
        Mockito.when(generateur.randomPin(max)).thenReturn(scoreFirstTurn);
        Mockito.when(generateur.randomPin(max-scoreFirstTurn)).thenReturn(scoreSecondTurn);
        //Act
        frame.makeRoll();
        frame.makeRoll();
        boolean result = frame.makeRoll();

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_Spare_CheckScore (){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,true);
        int max = 10;
        int scoreFirstTurn = 4;
        int scoreSecondTurn = 6;
        int scoreThirdTurn = 3;
        int score = scoreFirstTurn + scoreSecondTurn + scoreThirdTurn;
        Mockito.when(generateur.randomPin(max)).thenReturn(scoreFirstTurn).thenReturn(3);
        Mockito.when(generateur.randomPin(max-scoreFirstTurn)).thenReturn(scoreSecondTurn);
        //Act
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();

        //Assert
        Assertions.assertEquals(score, frame.getScore());
    }

    @Test
    public void Roll_LastFrame_FourthRoll_ReturnFalse (){
        //Arange
        generateur = Mockito.mock(IGenerateur.class);
        frame = new Frame(generateur,true);
        int max = 10;
        int score= 0;
        Mockito.when(generateur.randomPin(max)).thenReturn(max).thenReturn(score);
        //Act
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();
        boolean result = frame.makeRoll();

        //Assert
        Assertions.assertFalse(result);
    }


}
