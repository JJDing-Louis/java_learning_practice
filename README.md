# java_learning_practice
Make a subject and learn
## 題目
- 撰寫一個類別Student
- Student有四個屬性
    1.座號(int)
    2.班級(String)
    3.姓名(String)
    4.成績(int)
- Student的方法自行添加
- 主程式有一個Student的陣列
- 可以讓使用者有以下功能
1. 新增一個學生(空間不構請使用doubleArr)
2. 印出指定"座號"的學生成績
3. 依照成績由大到小排序學生
4. 依照座號由小到大排序學生
5. 更改指定"座號"的學生成績
6. 結束程式

## Coding 內容

### 建立學生類別
```java
public class Student {
    Scanner sc = new Scanner(System.in);
    private int seat_number; //座號
    private String class_name; //班級名稱
    private String name; //學生姓名
    private int score; //分數

    //讀取學生座號
    public int getSeat_number() {
        return seat_number;
    }
    //讀取班級名稱
    public String getClass_name() {
        return class_name;
    }
    //讀取學生姓名
    public String getName() {
        return name;
    }
    //讀取學生分數
    public int getScore() {
        return score;
    }

    //輸入學生座號(輸入防呆未做)
    public void setSeat_number() {
        System.out.println("請輸入學生座位：");
        this.seat_number = sc.nextInt();
    }

    //輸入學生班級(輸入防呆未做)
    public void setClass_name() {
        System.out.println("請輸入學生班級：");
        this.class_name = sc.next();
    }

    //輸入學生姓名(輸入防呆未做)
    public void setName() {
        System.out.println("請輸入學生姓名：");
        this.name = sc.next();
    }

    //輸入學生成績(輸入防呆未做)
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
```
### 主程式(Main)
0. 全域變數
```java
public static Student[] students = new Student[1]; //預設兩筆資料空格座使用
public static Scanner sc = new Scanner(System.in);
public static int count = 0; // 紀錄資料數量
```

1. 建立功能介面
```java
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
```
2. 建立學生(create_student())
```java
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
```
3. 查詢學生成績(find_student_score())
```java
private static void find_student_score() {
    System.out.println("請輸入座號:");
    int seat_number = sc.nextInt();
    for (Student student : students) {
        if (seat_number == student.getSeat_number()) {
            System.out.println("學生" + student.getName() + " 成績：" + student.getScore() + "分");
        }
    }
}        
```
4. 排序學生成績(print_student_socre())
```java
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
```
5. 排序學生座位(print_student_seat_number())
```java=
private static void print_student_seat_number() {
    if (students.length != 1) { //資料數量未達兩筆以上，不排序
        bubbleSort_student(2);
    }
    for (Student student : students) {
        System.out.println("學生座號:" + student.getSeat_number() + " 學生班級:" + student.getClass_name() +
                " 學生姓名:" + student.getClass_name() + " 學生成績:" + student.getScore() + "分");
    }
}
```
6. 修改學生成績(modify_student_score())
```java
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
```
7. 結束程式(System.exit(0))
### 其他模組化程式碼
1. 擴充陣列(increaseArray())
```java
//建立陣列擴充
public static void increaseArray() {
    Student[] student_Array = new Student[students.length + 1];
    for (int i = 0; i < students.length; i++) {
        student_Array[i] = students[i];
    }
    students = student_Array;
}
```
2. 排序(氣泡排序法)(bubbleSort_student(int num))
1 => 表示分數排序
2 => 表示座號排序
```java
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
```
