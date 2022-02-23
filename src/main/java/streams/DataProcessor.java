package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class DataProcessor {

    public static boolean atLeastOneGradeA(Student student) {
        return student.getGrades().stream().map(Grade::getType).anyMatch(type -> type == GradeType.A);
    }


    public static List<Integer> getStudentAges(List<Student> students) {
        return students.stream().mapToInt(Student::getAge).boxed().collect(Collectors.toList());
    }

    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        return students.stream().filter(student -> student.getAge() == minAge).collect(Collectors.toList());
    }


    // getGender() == Gender.MALE
    // or getGender().name().equals("MALE")

    public static long countMaleStudents(List<Student> students) {
        return (int) students.stream().filter(student -> student.getGender() == Gender.MALE).count();
    }


    public static double avgAgeOfFemaleStudent(List<Student> students) {
        return students.stream().filter(student -> student.getGender() == Gender.FEMALE).map(Student::getAge).reduce(0, Integer::sum);
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        return students.stream().mapToInt(Student::getAge).reduce(1, (a,b) -> a* b);
    }

    // ignore F Grades
    //TODO
    public static double productOfStudentGrades(Student student) {
        return student.getGrades().stream().mapToInt(grade -> grade.getType().getValue()).reduce(1, (a, b) -> a * b);
    }

    // region BONUS
    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        return Optional.of(student.getGrades().stream().filter(grade -> grade.getSubject() == Subject.MATH).max(Comparator.comparing(Grade::getType)).get());
    }

    public static List<Integer> getSortedAges(List<Student> students) {
        return students.stream().mapToInt(Student::getAge).sorted().boxed().collect(Collectors.toList());
    }

    // endregion
}
