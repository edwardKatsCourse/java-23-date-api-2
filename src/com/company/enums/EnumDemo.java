package com.company.enums;

import java.util.Scanner;

public class EnumDemo {

    public static void main(String[] args) {
        //Enum
        //Java Date API
//        AnotherEnum anotherEnum = new AnotherEnum();
        Position ceo = Position.CEO;
        System.out.println(ceo.getName());
        System.out.println(ceo.getTotalSalary(10000d));


        //var variable = new Employee();
        //int v = 11;
        //var v = 11;

        while (true) {
            System.out.println();
            System.out.println("Enter position code name: ");
            Scanner scanner = new Scanner(System.in);
            String positionType = scanner.nextLine(); //ceo, cto, sd
            Position position = Position.getByCodeName(positionType);
            if (position == null) {
                System.out.printf("No such position [%s]%n", positionType);
            } else {
                System.out.println(position.getTotalSalary(10000d));
            }

            System.out.println("Want to run once again? (Y)");
            String ifContinue = scanner.nextLine();
            if (ifContinue == null || ifContinue.isEmpty()) {
                break;
            }
        }
    }
}



//class AnotherEnum {
//    public static final String RECORD_1 = "RECORD_1";
//
//    private String field;
//
//    public AnotherEnum(String field) {
//        this.field = field;
//    }
//
//    @Override
//    public String toString() {
//        return "AnotherEnum{" +
//                "field='" + field + '\'' +
//                '}';
//    }


//}
