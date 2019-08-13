import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AverageGrades {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        String[] input;
        ArrayList<Student> students = new ArrayList<>();
        double grade;

        for (int i = 0; i < n; i++) {
            input = console.nextLine().split("\\s+");
            Student student = new Student();
            student.name = input[0];
            student.grades = new ArrayList<>();

            for (int j = 1; j <= input.length - 1; j++) {
                grade = Double.parseDouble(input[j]);
                student.grades.add(grade);
            }

            students.add(student);
        }

      /*  ArrayList<Student> filteredStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.AverageGrade() >= 5.00){
                filteredStudents.add(student);
            }
        } */

        students.stream()
                .filter( student -> student.AverageGrade() >= 5.00)
                .sorted(Comparator.comparing(Student::getName)
                        .thenComparing(Student::AverageGrade, Comparator.reverseOrder()))
                .forEach( student -> {
                    System.out.printf("%s -> %.2f\n", student.name, student.AverageGrade());
                });
    }

    static class Student{
        public String name;
        public ArrayList<Double> grades;

        public String getName() {
            return name;
        }

        public double AverageGrade() {
            double sum = 0;
            int elements = grades.size();

            for (Double grade : grades) {
                sum += grade;
            }

            return sum/elements;
        }
    }
}
