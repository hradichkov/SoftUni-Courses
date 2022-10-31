package P09DesignPatternsExercises.prototypePattern;

public class Main {
    public static void main(String[] args) {
        EmployeeRecord ivan = new EmployeeRecord(1, "Ivan", "more", 150, "Sofia");
        Prototype prototype = ivan.getClone();

        ivan.showRecord();
    }
}
