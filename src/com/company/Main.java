package com.company;

import java.util.Scanner;

public class Main {

    public static Student[] students = new Student[2];
    public static Scanner sc = new Scanner(System.in);
    public static int count;
    public static void main(String[] args) {
        // write your code herex



        while (true) {
            System.out.println("功能說明:\n1.新增學生\n2.搜尋學生\n3.學生成績排序(由大到小)" +
                    "\n4.學生座號排序\n5.更改學生成績\n6.結束程式\n請輸入指令:");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    create_student();
                    break;
                case 2:
                    find_student_score();
                    break;
                case 3:
                    print_student_socre();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
                    break;
            }


        }

    }
    //排序學生成績，並印出
    private static void print_student_socre() {
    }

    // 查詢學生成績
    private static void find_student_score() {
        System.out.println("請輸入座號:");
        int seat_number = sc.nextInt();
        for (Student student: students) {
            if(seat_number==student.getSeat_number()){
                System.out.println("學生"+student.getName()+" 成績：" + student.getScore() +"分");
            }
        }
    }

    //建立學生資料(在思考一下)
    public static void create_student() {
        if(students.length ==count){ //這一段再確認
            doubleArray(students);
        }
        Student student = new Student();
        student.setSeat_number();
        student.setClass_name();
        student.setName();
        student.setScore();
        students[count] = student;
        count++;
    }

    //建立陣列擴充
    public static void doubleArray(Student[] students) {
        Student[] student_Array = new Student[students.length * 2];
        for (int i = 0; i < students.length; i++) {
            student_Array[i] = students[i];
        }
        students = student_Array; //再確認
    }


}
