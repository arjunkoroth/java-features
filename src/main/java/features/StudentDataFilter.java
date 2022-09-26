package features;

import features.beans.Student;
import features.beans.Subject;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentDataFilter {
    private List<Student> createStudents() {
        List<Subject> subFirstStudent = Arrays.asList(
                new Subject("Maths", 10),
                new Subject("English", 20),
                new Subject("History", 30),
                new Subject("Science", 50)
        );
        List<Subject> subSecondStudent = Arrays.asList(
                new Subject("Maths", 40),
                new Subject("English", 50),
                new Subject("History", 60)
        );
        List<Subject> subThirdStudent = Arrays.asList(
                new Subject("Maths", 70),
                new Subject("English", 10),
                new Subject("History", 25)
        );
        Student student1 = new Student("Alice", subFirstStudent);
        Student student2 = new Student("Bob", subSecondStudent);
        Student student3 = new Student("Charlie", subThirdStudent);
        return Arrays.asList(student1, student2, student3);
    }

    private void filterStudents() {
        List<Student> studentList = createStudents();
        System.out.println("Get the student names who enrolled to a particular subject");
        System.out.println("--------------------------------------------------\n");
        studentList.stream()
                .filter(st -> st.getSubjects().contains(new Subject("Science", 0)))
                .forEach(System.out::println);
        System.out.println("\nGet a Student list with enrolled to a particular subject and mark for that subject greater than a specific value");
        System.out.println("-------------------------------------------------------------------------------------------------------------------\n");
        studentList.stream()
                .map(st -> {
                    for (Subject sub : st.getSubjects()) {
                        if (sub.getSubjectName().equals("History") && sub.getMark() > 50)
                            return st;
                    }
                    return null;
                })
                .collect(Collectors.toList())
                .stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
        System.out.println("Get total marks of each student");
        System.out.println("--------------------------------\n");
        studentList.stream()
                .map(st-> {
                    int totalMark = 0;
                    for (Subject sub: st.getSubjects()) {
                        totalMark += sub.getMark();
                    }
                    st.setTotalMarks(totalMark);
                    return st;
                })
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        new StudentDataFilter().filterStudents();
    }
}
