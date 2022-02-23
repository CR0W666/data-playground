package processing

import streams.School
import streams.Student

fun sumOfAgesOfAllStudents(school: School): Int {
    return school.classes.flatMap { it.students }.sumOf { it.age }
}

fun allStudentsWithAgeGreaterThan(school: School, minAge: Int): List<Student> {
    return school.classes.flatMap {it.students }.filter { it.age > minAge }
}

fun avgMathGradeForAllFemaleStudents(school: School): Double {
    return school.classes.flatMap { it.students }.filter { it.gender == Gender.FEMALE }.flatMap { it.grades }.filter { it.subject == Subject.MATH }.map { it.type.value }.average()
}

