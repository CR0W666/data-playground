package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DataProcessor {

    public static boolean atLeastOneGradeA(Student student) {
        for (Grade grade : student.getGrades()) {
            if(grade.getType() == GradeType.A) return true;
        }
        return false;
    }


    public static List<Integer> getStudentAges(List<Student> students) {
        List<Integer> ages = new ArrayList<>();
        for(Student student : students) ages.add(student.getAge());

        return ages;
    }

    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        List<Student> minAgeStudents = new ArrayList<>();
        for(Student student : students) if(minAge == student.getAge()) minAgeStudents.add(student);
        
        return minAgeStudents;
    }


    // getGender() == Gender.MALE
    // or getGender().name().equals("MALE")
    public static long countMaleStudents(List<Student> students) {
        long maleStudents = 0;
        for(Student student : students) if(student.getGender().compareTo(Gender.MALE) == 0) maleStudents++;

        return maleStudents;
    }


    public static double avgAgeOfFemaleStudent(List<Student> students) {
        int femaleAgesTotal = 0;
        int numOfFemaleStudents = 0;
        for(Student student : students) {
            if(student.getGender().compareTo(Gender.FEMALE) == 0) { 
                femaleAgesTotal += student.getAge(); numOfFemaleStudents++; 
            }
        }
        if(numOfFemaleStudents == 0) return 0.0;

        return (double) femaleAgesTotal / numOfFemaleStudents;
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        int productOfStudentAges = 1;
        for(Student student : students) productOfStudentAges *= student.getAge();
        return productOfStudentAges;
    }

    // ignore F Grades
    public static double productOfStudentGrades(Student student) {
        double productOfStudentGrades = 1.0;
        for(Grade grade : student.getGrades()) if(grade.getType() != GradeType.F) productOfStudentGrades *= grade.getType().getValue();
        return productOfStudentGrades;
    }

    // region BONUS

    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        Grade bestMathGrade = null;
        for(Grade grade : student.getGrades()) {
            if(grade.getSubject().compareTo(Subject.MATH) == 0 && (bestMathGrade == null || bestMathGrade.compareTo(grade) < 0)) {
                bestMathGrade = grade;
            }
        }

        return Optional.ofNullable(bestMathGrade);
    }

    public static List<Integer> getSortedAges(List<Student> students) {
        List<Integer> ages = new ArrayList<>();
        for(Student student : students) ages.add(student.getAge());
        ages.sort(Comparator.naturalOrder());
        
        return ages;
    }

    // endregion
}
