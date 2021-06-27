package com.company;


import java.util.Scanner;

public class Student {
    Scanner sc = new Scanner(System.in);
    private int seat_number;
    private String class_name;
    private String name;
    private int score;


    // public Student(int seat_number, String class_name, String name, int score) {
    //     this.seat_number = seat_number;
    //     this.class_name = class_name;
    //     this.name = name;
    //     this.score = score;
    // }

    public int getSeat_number() {
        return seat_number;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    //輸入學生座號(防呆未做)
    public void setSeat_number() {
        System.out.println("請輸入學生座位：");
        this.seat_number = sc.nextInt();
    }

    //輸入學生班級(防呆未做)
    public void setClass_name() {
        System.out.println("請輸入學生班級：");
        this.class_name = sc.next();
    }

    //輸入學生姓名(防呆未做)
    public void setName() {
        System.out.println("請輸入學生姓名：");
        this.name = sc.next();
    }

    //輸入學生成績
    public void setScore() {
        while (true) {
            System.out.println("請輸入學生分數：");
            int score = sc.nextInt();
            if (score > 100 || score < 0) {
                System.out.println("請輸入正確的成績!");
            } else {
                this.score = score;
                break;
            }
        }


    }


}
