package demo;

import java.io.PrintWriter;
import java.io.StringWriter;

public class GradeCalculation {

    public static String CalculateGrade(int score) throws Exception {

        try {
            if (score < 0) {
                throw new Exception("Score cannot be less than 0");
            }
            if (score > 100) {
                throw new Exception("Score cannot be more than 100");
            }
            if (score < 50) {
                return "F";
            }
            if (score < 60) {
                return "D";
            }
            if (score < 70) {
                return "C";
            }
            if (score < 80) {
                return "B";
            }
            return "A";
        } catch (Exception ex) {

            String printStackTrace = "CalculateGrade " + getExceptionStackTrace(ex);
            System.out.println(printStackTrace);
            throw ex;
        }

    }

    public static String getExceptionStackTrace(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }

}
