package com.company.date;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeDemo {
    static List<Employee> employees = new ArrayList<>();
    //Employee [] employees = new Employee[10];

    public static void main(String[] args) {
//        Date employmentDate = Date.from(
//                LocalDate.of(2013, Month.MAY, 5)
//                        .atStartOfDay()
//                        .atZone(ZoneId.systemDefault())
//                        .toInstant());
//
//        Employee firstEmployee = new Employee(
//                "David",
//                "Smith",
//                employmentDate,
//                10000d,
//                Position.CEO
//        );
//
//        employees.add(firstEmployee);


        //Salary = (base * position multiplier) * 0.05/per year
//        System.out.println(getSalaryByYears(firstEmployee));

        while (true) {

            Integer choice = menu();
            if (choice == 1) {
                printEmployees();
            }

            if (choice == 2) {
                Employee employee = inputEmployee();
                employees.add(employee);
            }

            if (choice == 3) {
                break;
            }
        }

    }

    private static Employee inputEmployee() {

        System.out.println("Enter employee first name");
        String firstName = new Scanner(System.in).nextLine();

        System.out.println("Enter employee last name");
        String lastName = new Scanner(System.in).nextLine();

        System.out.println("Employee position");
        Position position = Position.getByCode(new Scanner(System.in).nextLine());

        System.out.println("Employee base salary");
        Double baseSalary = new Scanner(System.in).nextDouble();

        System.out.println("Employee employment date (yyyy-MM-dd)");
        String date = new Scanner(System.in).nextLine();
        Date employmentDate = DateUtils.fromStringToDate(date);


        return new Employee(
                firstName,
                lastName,
                employmentDate,
                baseSalary,
                position
        );
    }

    private static void printEmployees() {
        for (Employee employee : employees) {

            LocalDate date = DateUtils.convertToLocalDate(employee.getEmploymentDate());
            System.out.printf("Fullname: %s %s | position: %s | Since: %s | M. salary: %s | yearly salary: %s%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getPosition().name(),
                    date,
                    getSalaryByYears(employee),
                    getSalaryByYears(employee) * 12);
        }
    }

    private static Integer menu() {
        Integer choice = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Show all employees");
            System.out.println("2. Add a new employee");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                return choice;
            }
            System.out.println("You have entered the wrong value");
        }
    }


    private static Double getSalaryByYears(Employee e) {
        LocalDate employmentDate = e.getEmploymentDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate now = LocalDate.now();

        long between = ChronoUnit.YEARS.between(employmentDate, now);

        Double totalSalary = e.getBaseSalary() * e.getPosition().getSalaryMultiplier();
        for (int i = 0; i < between; i++) {
            totalSalary *= 1.05;
        }

        DecimalFormat dec = new DecimalFormat("#0.00");

        return Double.parseDouble(dec.format(totalSalary));
    }
}
