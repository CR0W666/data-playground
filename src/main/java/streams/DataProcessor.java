package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DataProcessor {
    //TODO
    public static boolean atLeastOneGradeA(Student student) {

        for (Grade grade : student.getGrades()) {

            if (grade.getType() == GradeType.A)
                return true;
        }
        return false;
    }


    public static List<Integer> getStudentAges(List<Student> students) {

        return students.stream().mapToInt(Student::getAge).boxed().toList();
    }
    //TODO
    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        final List<Student> minAgeStudents = new ArrayList<>();

        for (Student student : students) {

            if (minAge == student.getAge())
                minAgeStudents.add(student);
        }

        return minAgeStudents;
    }


    // getGender() == Gender.MALE
    // or getGender().name().equals("MALE")
    //TODO
    public static long countMaleStudents(List<Student> students) {
        long maleStudents = 0;

        for (Student student : students) {

            if (student.getGender().compareTo(Gender.MALE) == 0)
                maleStudents++;
        }

        return maleStudents;
    }

    //TODO
    public static double avgAgeOfFemaleStudent(List<Student> students) {
        int femaleAgesTotal = 0;
        int numOfFemaleStudents = 0;

        for (Student student : students) {

            if (student.getGender().compareTo(Gender.FEMALE) == 0) {
                femaleAgesTotal += student.getAge();
                numOfFemaleStudents++;
            }
        }

        if (numOfFemaleStudents == 0)
            return 0.0;

        return (double) femaleAgesTotal / numOfFemaleStudents;
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        
        return students.stream().mapToInt(Student::getAge).reduce(1, (a,b) -> a* b);
    }

    // ignore F Grades
    //TODO
    public static double productOfStudentGrades(Student student) {
        double productOfStudentGrades = 1.0;

        for (Grade grade : student.getGrades()) {

            if (grade.getType() != GradeType.F)
                productOfStudentGrades *= grade.getType().getValue();
        }

        return productOfStudentGrades;
    }

    // region BONUS
    //TODO
    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        Grade bestMathGrade = null;

        for (Grade grade : student.getGrades()) {

            if (grade.getSubject().compareTo(streams.Subject.MATH) == 0
                    && (bestMathGrade == null || bestMathGrade.compareTo(grade) < 0)) {

                bestMathGrade = grade;
            }
        }

        return Optional.ofNullable(bestMathGrade);
    }

    public static List<Integer> getSortedAges(List<Student> students) {


        return students.stream().mapToInt(Student::getAge).sorted().boxed().toList();
    }

    // endregion
}
