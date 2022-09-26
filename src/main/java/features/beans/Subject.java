package features.beans;

import java.util.Objects;

public class Subject {
    private String subjectName;
    private int mark;

    public Subject(String subjectName, int mark) {
        this.subjectName = subjectName;
        this.mark = mark;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public int getMark() {
        return this.mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName, mark);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", mark=" + mark +
                '}';
    }
}
