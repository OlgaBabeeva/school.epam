package javase02.t05;

public enum Course {
    MATH(TypeOfGrade.DOUBLE),
    PHYSICS(TypeOfGrade.DOUBLE),
    PHILOSOPHY(TypeOfGrade.INT),
    HISTORY(TypeOfGrade.INT),
    CHEMISTRY(TypeOfGrade.DOUBLE),
    ECONOMICS(TypeOfGrade.INT);

    private final TypeOfGrade TYPE;

    Course(TypeOfGrade TYPE) {
        this.TYPE = TYPE;
    }

    public TypeOfGrade getType() {
        return TYPE;
    }

    enum TypeOfGrade {
        INT, DOUBLE
    }

    public boolean isGradeInteger() {
        return this.getType().equals(TypeOfGrade.INT);
    }
}
