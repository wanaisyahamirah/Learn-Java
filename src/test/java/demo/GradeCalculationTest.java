package demo;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GradeCalculationTest {

    @Test
    public void InvalidScoreZero() {
        try {
            GradeCalculation.CalculateGrade(-99);
            System.out.println("It is supported to throw exception");
        } catch (Exception localException) {
        }
    }

    @Test
    public void InvalidScoreHundred() {
        try {
            GradeCalculation.CalculateGrade(120);
            System.out.println("It is supported to throw exception");
        } catch (Exception localException) {
        }
    }

    @Test
    public void ScoreIsF()
            throws Exception {
        assertTrue(GradeCalculation.CalculateGrade(49) == "F");
        assertTrue(GradeCalculation.CalculateGrade(10) == "F");
    }

    @Test
    public void ScoreIsD()
            throws Exception {
        assertTrue(GradeCalculation.CalculateGrade(50) == "D");
        assertTrue(GradeCalculation.CalculateGrade(59) == "D");
    }

    @Test
    public void ScoreIsC()
            throws Exception {
        assertTrue(GradeCalculation.CalculateGrade(60) == "C");
        assertTrue(GradeCalculation.CalculateGrade(69) == "C");
    }

    @Test
    public void ScoreIsB()
            throws Exception {
        assertTrue(GradeCalculation.CalculateGrade(70) == "B");
        assertTrue(GradeCalculation.CalculateGrade(79) == "B");
    }

    @Test
    public void ScoreIsA()
            throws Exception {
        assertTrue(GradeCalculation.CalculateGrade(80) == "A");
        assertTrue(GradeCalculation.CalculateGrade(99) == "A");
    }

}
