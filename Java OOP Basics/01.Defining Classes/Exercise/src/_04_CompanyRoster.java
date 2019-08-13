import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _04_CompanyRoster {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        HashMap<String, Department> departments = new HashMap<>();
        String[] line;

        for (int i = 0; i < n; i++) {
            line = reader.readLine().split("\\s+");
            departments.putIfAbsent(line[3], new Department(line[3]));
            Department currentDepartment = departments.get(line[3]);

            Employee currentEmployee = new Employee(line[0], Double.parseDouble(line[1]), line[2], line[3]);

            if (line.length == 6) {
                currentEmployee.email = line[4];
                currentEmployee.age = Integer.parseInt(line[5]);
            } else if (line.length == 5) {
                if (line[4].contains("@")) {
                    currentEmployee.email = line[4];
                } else {
                    currentEmployee.age = Integer.parseInt(line[4]);
                }
            }

            currentDepartment.employees.add(currentEmployee);
        }

        Comparator<Map.Entry<String, Department>> averageSalary = Comparator.comparing(kvp -> kvp.getValue().getAvgSalary(), Comparator.reverseOrder());
        departments.entrySet().stream()
                .sorted(averageSalary)
                .limit(1)
                .forEach(d -> {
                    System.out.println("Highest Average Salary: " + d.getKey());
                    System.out.println(d.getValue());
                });
    }

    static class Employee {
        public String name;
        public double salary;
        public String position;
        public String department;
        public String email;
        public int age;

        public Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = "n/a";
            this.age = -1;
        }

        @Override
        public String toString() {
            return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
        }
    }

    static class Department {
        public String name;
        public List<Employee> employees;
        private double salariesSum;
        public double avgSalary;

        public Department(String name){
            this.name = name;
            this.employees = new ArrayList<>();
            this.salariesSum = 0;
        }

        public double getAvgSalary() {
            this.employees.forEach(employee -> this.salariesSum += employee.salary);
            this.avgSalary = this.salariesSum / this.employees.size();

            return this.avgSalary;
        }

        @Override
        public String toString() {
            Comparator<Employee> salaryDesc = Comparator.comparing(employee -> employee.salary, Comparator.reverseOrder());
            StringBuilder sb = new StringBuilder();

            this.employees.sort(salaryDesc);
            this.employees.forEach(employee -> sb.append(employee).append("\n"));
            return sb.toString();
        }
    }
}
