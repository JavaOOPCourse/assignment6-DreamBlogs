import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        students.put("IDAKBAR", new Student("Akbar", 3.5, 19));
        students.put("IDNURBEK", new Student("Nurbek", 3.7, 19));
        students.put("IDTEMIRLAN", new Student("Temirlan", 3.6, 19));
        students.put("IDISKERO", new Student("Iskender", 3.6, 19));
        students.put("IDNURSULTAN", new Student("Akbar", 3.9, 19));
        // Сделай минимум два студента с одинаковым GPA (для Task 3)

        // TODO: Напечатай всех студентов (ID + объект)
        for(Map.Entry<String, Student> entry:students.entrySet()) {
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }

        // TODO: Найди студента по ID и выведи его
        Boolean isFound = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("Find by ID: ");
        String input = scan.nextLine();
        for(Map.Entry<String, Student> entry:students.entrySet()) {
            if(entry.getKey().equals(input)) {
                System.out.println(entry.getValue().toString());
                isFound=true;
            }
        }
        if(!isFound) {
            System.out.println("Student isn't exist");
        }
        // TODO: Удали одного студента по ID
        Boolean isFoundForDel = false;
        System.out.print("Delete by ID: ");
        String input2 = scan.nextLine();
        for(Map.Entry<String, Student> entry:students.entrySet()) {
            if(entry.getKey().equals(input2)) {
                isFoundForDel=true;
                students.remove(entry.getKey());
            }
        }
        if (isFoundForDel) {
            for(Map.Entry<String, Student> entry:students.entrySet()) {
                System.out.println(entry.getKey()+" "+entry.getValue().toString());
            }
        } else System.out.println("Student doesn't exist");

        // TODO: Обнови GPA у одного студента
        System.out.print("Enter ID for refresh GPA: ");
        String id = scan.nextLine();
        System.out.print("Enter new GPA: ");
        double newGpa = scan.nextDouble();
        Boolean forGPA = false;
        for (Map.Entry<String, Student> entry:students.entrySet()) {
            if(id.equals(entry.getKey())) {
                entry.getValue().setGpa(newGpa);
                forGPA = true;
            }
        }

        if (!forGPA) {
            System.out.println("Student doesn't exist");
        }

        for(Map.Entry<String, Student> entry:students.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue().toString());
        }


        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        List<Student> studentsArr = new ArrayList<>();
        for (Map.Entry<String, Student> entry:students.entrySet()) {
            studentsArr.add(entry.getValue());
        }

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(studentsArr, new GPAComparator());
        for(Student s:studentsArr) {
            System.out.println(s.toString());
        }

        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        Collections.sort(studentsArr, new NameComparator());
        for(Student s:studentsArr) {
            System.out.println(s.toString());
        }

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
    }
}



