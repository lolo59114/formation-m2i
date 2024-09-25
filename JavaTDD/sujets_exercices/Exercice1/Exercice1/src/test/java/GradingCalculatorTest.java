import org.example.GradingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GradingCalculatorTest {

    private GradingCalculator gradingCalculator;

//    @Test
//    public void WhenGrade_95_AndPressence_90_ThenResult_A(){
//        //Arrange
//        int grade = 95;
//        int pressence = 90;
//        char resultAwait = 'A';
//        gradingCalculator = new GradingCalculator(grade,pressence);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assertions.assertEquals(resultAwait,gradGet);
//    }
//
//    @Test
//    public void WhenGrade_85_AndPressence_90_ThenResult_B(){
//        //Arrange
//        int grade = 85;
//        int pressence = 90;
//        char resultAwait = 'B';
//        gradingCalculator = new GradingCalculator(grade,pressence);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assertions.assertEquals(resultAwait,gradGet);
//    }
//
//    @Test
//    public void WhenGrade_65_AndPressence_90_ThenResult_C(){
//        //Arrange
//        int grade = 65;
//        int pressence = 90;
//        char resultAwait = 'C';
//        gradingCalculator = new GradingCalculator(grade,pressence);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assertions.assertEquals(resultAwait,gradGet);
//    }
//
//    @Test
//    public void WhenGrade_95_AndPressence_65_ThenResult_B(){
//        //Arrange
//        int grade = 95;
//        int pressence = 65;
//        char resultAwait = 'B';
//        gradingCalculator = new GradingCalculator(grade,pressence);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assertions.assertEquals(resultAwait,gradGet);
//    }
//
//    @Test
//    public void WhenGrade_95_AndPressence_55_ThenResult_F(){
//        //Arrange
//        int grade = 95;
//        int pressence = 55;
//        char resultAwait = 'F';
//        gradingCalculator = new GradingCalculator(grade,pressence);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assertions.assertEquals(resultAwait,gradGet);
//    }
//
//    @Test
//    public void WhenGrade_65_AndPressence_55_ThenResult_F(){
//        //Arrange
//        int grade = 65;
//        int pressence = 55;
//        char resultAwait = 'F';
//        gradingCalculator = new GradingCalculator(grade,pressence);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assertions.assertEquals(resultAwait,gradGet);
//    }
//
//    @Test
//    public void WhenGrade_50_AndPressence_90_ThenResult_F(){
//        //Arrange
//        int grade = 50;
//        int pressence = 90;
//        char resultAwait = 'F';
//        gradingCalculator = new GradingCalculator(grade,pressence);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assertions.assertEquals(resultAwait,gradGet);
//    }

    @ParameterizedTest
//    @CsvSource({
//            "95,90,A",
//            "85,90,B",
//            "65,90,C",
//            "95,65,B",
//            "95,55,F",
//            "65,55,F",
//            "50,90,F",
//    })
    @MethodSource("providerParameters")
    public void WhenGradeAndPressenceThenResultAwaitedGrade(int grade,int pressence, char awaitedGrade){
        //Arrange
        gradingCalculator = new GradingCalculator(grade,pressence);

        //Act
        char gradGet = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(awaitedGrade,gradGet);
    }

    private static Stream<Arguments> providerParameters(){
        return Stream.of(
                Arguments.of(95,90,'A'),
                Arguments.of(85,90,'B'),
                Arguments.of(65,90,'C'),
                Arguments.of(95,65,'B'),
                Arguments.of(95,55,'F')
        );
    }
}
