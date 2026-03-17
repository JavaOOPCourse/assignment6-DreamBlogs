import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int age;

    // ODO: Task 1 — Создай конструктор, который принимает имя, GPA и возраст
    public Student(String name, double gpa, int age) {
        this.gpa = gpa;
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }

    // ODO: Task 1 — Добавь возможность изменить GPA
    public void setGpa(double newGpa) {
        // заглушка
        this.gpa = newGpa;
    }

    // ODO: Task 1 (Sorting) — Реализуй Comparable по GPA (по возрастанию)
    @Override
    public int compareTo(Student other) {
        // заглушка — верни правильное значение сравнения
        if (this.gpa > other.gpa) {
            return 1;
        } else if (this.gpa < other.gpa) {
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        // ODO: Сделай красивый вывод
        return ("Name: "+this.name+" GPA: "+this.gpa+" Age: "+this.age);
    }
}

class GPAComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getGpa(), s2.getGpa());
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
