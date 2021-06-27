package com.company;

import java.util.Scanner;

public class Main {

    public static Student[] students = new Student[1]; //預設兩筆資料空格座使用
    public static Scanner sc = new Scanner(System.in);
    public static int count = 0; // 紀錄資料數量

    public static void main(String[] args) {
        // write your code herex

        //建立功能選項介面
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
                    print_student_seat_number();
                    break;
                case 5:
                    modify_student_score();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }


        }

    }

    //修改學生成績
    private static void modify_student_score() {
        while (true) {
            boolean state = true;//標記查詢狀態(true表示找到，false表示沒找到)
            System.out.println("請輸入學生座號: ");
            int set_number = sc.nextInt();
            for (int i = 0; i < students.length; i++) {
                if (students[i].getSeat_number() == set_number) {
                    System.out.println("該學生的成績為: " + students[i].getScore());
                    students[i].setScore();
                    System.out.println("學生: "+students[i]+"成績修改為: "+students[i].getScore());
                    state = false;
                    break;
                }
            }
            if (state) {
                System.out.println("查無此學生!!");
            } else {
                break;
            }
        }
    }

    private static void print_student_seat_number() {
        if (students.length != 1) { //資料數量未達兩筆以上，不排序
            bubbleSort_student(2);
        }
        for (Student student : students) {
            System.out.println("學生座號:" + student.getSeat_number() + " 學生班級:" + student.getClass_name() +
                    " 學生姓名:" + student.getClass_name() + " 學生成績:" + student.getScore() + "分");
        }
    }

    //排序學生成績，並印出
    private static void print_student_socre() {
        if (students.length != 1) { //資料數量未達兩筆以上，不排序
            bubbleSort_student(1);
        }
        for (Student student : students) {
            System.out.println("學生座號:" + student.getSeat_number() + " 學生班級:" + student.getClass_name() +
                    " 學生姓名:" + student.getClass_name() + " 學生成績:" + student.getScore() + "分");
        }
    }

    // 查詢學生成績
    private static void find_student_score() {
        System.out.println("請輸入座號:");
        int seat_number = sc.nextInt();
        for (Student student : students) {
            if (seat_number == student.getSeat_number()) {
                System.out.println("學生" + student.getName() + " 成績：" + student.getScore() + "分");
            }
        }
    }

    //建立學生資料(Done)
    public static void create_student() {
        //Array資料不足，新增空間
        if (students.length == count) {
            increaseArray();
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
    public static void increaseArray() {
        Student[] student_Array = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            student_Array[i] = students[i];
        }
        students = student_Array;
    }

    //排序(氣泡排序法)
    public static void bubbleSort_student(int num) {
        Student temp;
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                switch (num) {
                    case 1:
                        if (students[i].getScore() < students[i + 1].getScore()) {
                            temp = students[i];
                            students[i] = students[i + 1];
                            students[i + 1] = temp;
                        }
                        break;
                    case 2:
                        if (students[i].getSeat_number() > students[i + 1].getSeat_number()) {
                            temp = students[i];
                            students[i] = students[i + 1];
                            students[i + 1] = temp;
                        }
                }

            }
        }

    }
}




