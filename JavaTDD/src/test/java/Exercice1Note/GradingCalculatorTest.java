package Exercice1Note;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {
    private GradingCalculator gradingCalculator;

    @Test
    public void TestGradingCalculatorWhenGradingCalulator_95_90_ThenNote_A () {
        int score = 95;
        int attendancePercentage = 90;
        char noteExpected = 'A';
        gradingCalculator = new GradingCalculator(score, attendancePercentage);
        char note = gradingCalculator.getGrade();
        Assertions.assertEquals(noteExpected, note);
    }

    @Test
    public void TestGradingCalculatorWhenGradingCalulator_85_90_ThenNote_B () {
        int score = 85;
        int attendancePercentage = 90;
        char noteExpected = 'B';
        gradingCalculator = new GradingCalculator(score, attendancePercentage);
        char note = gradingCalculator.getGrade();
        Assertions.assertEquals(noteExpected, note);
    }

    @Test
    public void TestGradingCalculatorWhenGradingCalulator_65_90_ThenNote_C () {
        int score = 65;
        int attendancePercentage = 90;
        char noteExpected = 'C';
        gradingCalculator = new GradingCalculator(score, attendancePercentage);
        char note = gradingCalculator.getGrade();
        Assertions.assertEquals(noteExpected, note);
    }

    @Test
    public void TestGradingCalculatorWhenGradingCalulator_95_65_ThenNote_B () {
        int score = 95;
        int attendancePercentage = 65;
        char noteExpected = 'B';
        gradingCalculator = new GradingCalculator(score, attendancePercentage);
        char note = gradingCalculator.getGrade();
        Assertions.assertEquals(noteExpected, note);
    }

    @Test
    public void TestGradingCalculatorWhenGradingCalulator_95_55_ThenNote_F () {
        int score = 95;
        int attendancePercentage = 55;
        char noteExpected = 'F';
        gradingCalculator = new GradingCalculator(score, attendancePercentage);
        char note = gradingCalculator.getGrade();
        Assertions.assertEquals(noteExpected, note);
    }

    @Test
    public void TestGradingCalculatorWhenGradingCalulator_65_55_ThenNote_F () {
        int score = 65;
        int attendancePercentage = 55;
        char noteExpected = 'F';
        gradingCalculator = new GradingCalculator(score, attendancePercentage);
        char note = gradingCalculator.getGrade();
        Assertions.assertEquals(noteExpected, note);
    }

    @Test
    public void TestGradingCalculatorWhenGradingCalulator_50_90_ThenNote_F () {
        int score = 50;
        int attendancePercentage = 90;
        char noteExpected = 'F';
        gradingCalculator = new GradingCalculator(score, attendancePercentage);
        char note = gradingCalculator.getGrade();
        Assertions.assertEquals(noteExpected, note);
    }
}
