public class StudentGradeTranslator {

    GradeCalculator gradeCalculator;

    public StudentGradeTranslator() {
        this.gradeCalculator = new FlatCurveGradeCalculator();
    }

    public StudentGradeTranslator(String gradingMethod) {
        if (gradingMethod == null) {
            this.gradeCalculator = new FlatCurveGradeCalculator();
        } else if (gradingMethod.equals("FLAT")) {
            this.gradeCalculator = new FlatCurveGradeCalculator();
        } else if (gradingMethod.equals("SLIGHT")) {
            this.gradeCalculator = new SlightCurveGradeCalculator();
        } else if (gradingMethod.equals("HEAVY")) {
            this.gradeCalculator = new HeavyCurveGradeCalculator();
        }
    }

    public String getLetterGrade(int numberGrade) {
        return gradeCalculator.getLetterGrade(numberGrade);
    }

    public boolean isPassingGrade(int numberGrade) {
        return gradeCalculator.isPassingGrade(numberGrade);
    }

    public int howManyForNextLetterGrade(int numberGrade) {
        return gradeCalculator.howManyForNextLetterGrade(numberGrade);
    }

    interface GradeCalculator {
        public String getLetterGrade(int numberGrade);

        public int howManyForNextLetterGrade(int numberGrade);

        public boolean isPassingGrade(int numberGrade);
    }

    class FlatCurveGradeCalculator implements GradeCalculator {
        public String getLetterGrade(int numberGrade) {
            if (numberGrade < 60) {
                return "F";
            }
            if (numberGrade < 70) {
                return "D";
            }
            if (numberGrade < 80) {
                return "C";
            }
            if (numberGrade < 90) {
                return "B";
            }
            return "A";
        }

        public boolean isPassingGrade(int numberGrade) {
            if (numberGrade >= 60)
                return true;
            return false;
        }

        public int howManyForNextLetterGrade(int numberGrade) {
            int difference = 0;
            String letterGrade = getLetterGrade(numberGrade);
            if (letterGrade.equals("F")) {
                difference = 60 - numberGrade;
            }
            if (letterGrade.equals("D")) {
                difference = 70 - numberGrade;
            }
            if (letterGrade.equals("C")) {
                difference = 80 - numberGrade;
            }
            if (letterGrade.equals("B")) {
                difference = 90 - numberGrade;
            }
            return difference;
        }
    }

    class SlightCurveGradeCalculator implements GradeCalculator {
        public String getLetterGrade(int numberGrade) {
            if (numberGrade < 55) {
                return "F";
            }
            if (numberGrade < 65) {
                return "D";
            }
            if (numberGrade < 75) {
                return "C";
            }
            if (numberGrade < 85) {
                return "B";
            }
            return "A";
        }

        public boolean isPassingGrade(int numberGrade) {
            if (numberGrade >= 55)
                return true;
            return false;
        }

        public int howManyForNextLetterGrade(int numberGrade) {
            int difference = 0;
            String letterGrade = getLetterGrade(numberGrade);
            if (letterGrade.equals("F")) {
                difference = 55 - numberGrade;
            }
            if (letterGrade.equals("D")) {
                difference = 65 - numberGrade;
            }
            if (letterGrade.equals("C")) {
                difference = 75 - numberGrade;
            }
            if (letterGrade.equals("B")) {
                difference = 85 - numberGrade;
            }
            return difference;
        }
    }

    class HeavyCurveGradeCalculator implements GradeCalculator {
        public String getLetterGrade(int numberGrade) {
            if (numberGrade < 50) {
                return "F";
            }
            if (numberGrade < 60) {
                return "D";
            }
            if (numberGrade < 70) {
                return "C";
            }
            if (numberGrade < 80) {
                return "B";
            }
            return "A";
        }

        public boolean isPassingGrade(int numberGrade) {
            if (numberGrade >= 50)
                return true;
            return false;
        }

        public int howManyForNextLetterGrade(int numberGrade) {
            int difference = 0;
            String letterGrade = getLetterGrade(numberGrade);
            if (letterGrade.equals("F")) {
                difference = 50 - numberGrade;
            }
            if (letterGrade.equals("D")) {
                difference = 60 - numberGrade;
            }
            if (letterGrade.equals("C")) {
                difference = 70 - numberGrade;
            }
            if (letterGrade.equals("B")) {
                difference = 80 - numberGrade;
            }
            return difference;
        }
    }

}