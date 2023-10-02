
import java.sql.SQLOutput;
import java.util.Scanner;
import Common.Constant;
import Object.Student;

public class MainStatic {
    private Constant constant;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalStudent = 0;
        Student[] st = new Student[6];
        st[0] = new Student("congbt1",175f,75f,"qwertyuiop","27/07/2000","qwertyuio1","qwertyuiop","2018",7.5f);   //unit test
        st[1] = new Student("congb2",175f,75f,"qwertyuiop","29/09/2000","qwertyuio2","qwertyuiop","2018",1.5f);
        st[2] = new Student("congb3",175f,75f,"qwertyuiop","29/09/2000","qwertyuio3","qwertyuiop","2018",4.5f);
        st[3] = new Student("congb4",175f,75f,"qwertyuiop","29/09/2000","qwertyuio4","qwertyuiop","2018",9.5f);
        st[4] = new Student("congb5",175f,75f,"qwertyuiop","29/09/2000","qwertyuio5","qwertyuiop","2018",3.5f);
        st[5] = new Student("congb6",175f,75f,"qwertyuiop","29/09/2000","qwertyuio6","qwertyuiop","2018",5.5f);
        while(true){
            System.out.println(
                            "1.Create Student\n" +
                            "2.Find Student By Id\n" +
                            "3.Find All Student\n" +
                            "4.Update Student By Id\n" +
                            "5.Delete Student By Id\n" +
                            "0.Exit");
            System.out.print("Choose a number:");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice < 1 || choice > 5){
                System.out.println("See you again :D (press y to exit)? ");
                String exit = sc.nextLine();
                if(exit.toUpperCase().equals("Y")){
                    break;
                } else {
                    continue;
                }
            }
            switch (choice){
                case 1:
                    System.out.println("---------------------------------------");
                    System.out.println("CREATE STUDENT!!");
                    st = createManyStudent();
                    System.out.println("---------------------------------------");
                    break;
                case 2:
                    System.out.println("---------------------------------------");
                    System.out.println("FIND STUDENT BY ID!!!");
                    findById(st);
                    System.out.println("---------------------------------------");
                    break;
                case 3:
                    System.out.println("---------------------------------------");
                    System.out.println("FIND ALL STUDENT");
                    findAllStudent(st);
                    System.out.println("---------------------------------------");
                    break;
                case 4:
                    System.out.println("---------------------------------------");
                    System.out.println("UPDATE STUDENT!!");
                    updateStudentById(st);
                    System.out.println("---------------------------------------");
                    break;
                case 5:
                    System.out.println("DELETE STUDENT BY ID!!!");
                    deleteStudentById(st);
                    break;
            }
        }
    }

    public static boolean  createOneStudent(Student st){
        try{
        Scanner sc = new Scanner(System.in);
        System.out.print("Name:");
        String name = sc.nextLine();
        st.setName(name);
        while (st.getName().length() > Constant.ConstantHuman.MAX_NAME && !st.getName().isEmpty()) {
            System.out.print("Name length is less than 100 and not null!!!\nPlease enter again: ");
            name = sc.nextLine();
            st.setName(name);
        }

        System.out.print("Birth of Date:");
        String bod = sc.nextLine();
        st.setBirthOfDate(bod);
        while (!st.getBirthOfDate().matches(Constant.ConstantHuman.REGEX_BOD) && !st.getBirthOfDate().isEmpty()) {
            System.out.print("Birth of date is wrong format and not null!!!\nPlease enter according to format(DD/MM/YYYY): ");
            bod = sc.nextLine();
            st.setBirthOfDate(bod);
            if(bod.substring(bod.length()-5,bod.length()-1).length() < Constant.ConstantHuman.MIN_YEAR){
                System.out.print("Year of birth is less than 1900!!!\nPlease enter again: ");
                bod = sc.nextLine();
                st.setBirthOfDate(bod);
            }
        }
        System.out.print("Address: ");
        String address = sc.nextLine();
        st.setAddress(address);
        while (st.getAddress().length() > Constant.ConstantHuman.MAX_ADDRESS) {
            System.out.print("Address is less than 300!!\nPlease enter again: ");
            address = sc.nextLine();
            st.setAddress(address);
        }
        System.out.print("Weight: ");
        float weight = Float.parseFloat(sc.nextLine());
        st.setWeight(weight);
        while (st.getWeight()< Constant.ConstantHuman.MIN_WEIGHT || st.getWeight()> Constant.ConstantHuman.MAX_WEIGHT) {
            System.out.print("Weight is between 50 and 300!!!\nPlease enter again: ");
            weight = Float.parseFloat(sc.nextLine());
            st.setWeight(weight);
        }
        System.out.print("Height: ");
        float height = Float.parseFloat(sc.nextLine());
        st.setHeight(height);
        while (st.getHeight()< Constant.ConstantHuman.MIN_HEIGHT || st.getHeight()> Constant.ConstantHuman.MAX_HEIGHT) {
            System.out.print("Height is between 50 and 300!!!\nPlease enter again: ");
            height = Float.parseFloat(sc.nextLine());
            st.setWeight(height);
        }
        System.out.print("Student Id: ");
        String studentId = sc.nextLine();
        st.setStudentId(studentId);
        while (!st.getStudentId().matches(Constant.ConstantStudent.REGEX_STUDENT_ID)) {
            System.out.print("Student id can only be 10 characters and not null!!!\nPlease enter again: ");
            studentId = sc.nextLine();
            st.setStudentId(studentId);
        }
        System.out.print("School: ");
        String school = sc.nextLine();
        st.setSchool(school);
        while (st.getSchool().length() > Constant.ConstantStudent.MAX_SCHOOL || st.getSchool() == null) {
            System.out.print("School id less than 200 and not null!!!\nPlease enter again: ");
            school = sc.nextLine();
            st.setStudentId(school);
        }
        System.out.print("Start year: ");
        String startYear = sc.nextLine();
        st.setStartYear(startYear);
        int startYearToInt = Integer.parseInt(startYear);
        while (!st.getStartYear().matches(Constant.ConstantStudent.REGEX_START_YEAR) || startYearToInt < Constant.ConstantStudent.MIN_START_YEAR || st.getStartYear()== null) {
            System.out.print("Start year only be 4 number and less than 1900 and not null!!!\nPlease enter again: ");
            startYear = sc.nextLine();
            st.setStartYear(startYear);
            startYearToInt = Integer.parseInt(startYear);
        }
        System.out.print("Medium Score:");
        float mediumScore = Float.parseFloat(sc.nextLine());
        st.setMediumScore(mediumScore);
        while (st.getMediumScore() < Constant.ConstantStudent.MIN_MEDIUM_SCORE || st.getMediumScore() > Constant.ConstantStudent.MAX_MEDIUM_SCORE) {
            System.out.print("Medium score between 0.0 and 10.0!!!\nPlease enter again: ");
            mediumScore = Float.parseFloat(sc.nextLine());
            st.setMediumScore(mediumScore);
        }System.out.println("======>Add student success!!");
    }catch (Exception e){
        System.out.println("========>Add student failed!!");
    }

        return true;
    }
    public static Student[] createManyStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so sinh vien: ");
        int totalStudent = Integer.parseInt(sc.nextLine());
        Student[] st= new Student[totalStudent];
        for(int i=0 ; i < totalStudent ; i++){
            st[i] = new Student();
            if(createOneStudent(st[i])){
                display(st, i);
            }
        }
        return st;
    }
    public static void findById(Student[] st){
        Scanner sc = new Scanner(System.in);
        boolean idNotFound= false;
        System.out.print("Enter student code: ");
        String stCode = sc.nextLine();
        for(Student a : st){
            if(a.getStudentId().equals(stCode)){
                idNotFound= true;
                display(st, a.getId());
            }
        }
        if(!idNotFound){
            System.out.println("----------------------");
            System.out.println("Student ID not found");
            System.out.println("----------------------");
        }
    }
    public static void findAllStudent(Student[] st){
        for(int i=0; i< st.length ; i++){
            display(st, i);
        }
    }
    public static boolean  updateOneStudent(Student st){
        Scanner sc = new Scanner(System.in);
        try{
        System.out.print("Name:");
        String name = sc.nextLine();
        st.setName(name);
        while (st.getName().length() > Constant.ConstantHuman.MAX_NAME && !st.getName().isEmpty()) {
            System.out.print("Name length is less than 100 and not null!!!\nPlease enter again: ");
            name = sc.nextLine();
            st.setName(name);
        }

        System.out.print("Birth of Date:");
        String bod = sc.nextLine();
        st.setBirthOfDate(bod);
        while (!st.getBirthOfDate().matches(Constant.ConstantHuman.REGEX_BOD) && !st.getBirthOfDate().isEmpty()) {
            System.out.print("Birth of date is wrong format and not null!!!\nPlease enter according to format(DD/MM/YYYY): ");
            bod = sc.nextLine();
            st.setBirthOfDate(bod);
            if(bod.substring(bod.length()-5,bod.length()-1).length() < Constant.ConstantHuman.MIN_YEAR){
                System.out.print("Year of birth is less than 1900!!!\nPlease enter again: ");
                bod = sc.nextLine();
                st.setBirthOfDate(bod);
            }
        }
        System.out.print("Address: ");
        String address = sc.nextLine();
        st.setAddress(address);
        while (st.getAddress().length() > Constant.ConstantHuman.MAX_ADDRESS) {
            System.out.print("Address is less than 300!!\nPlease enter again: ");
            address = sc.nextLine();
            st.setAddress(address);
        }
        System.out.print("Weight: ");
        float weight = Float.parseFloat(sc.nextLine());
        st.setWeight(weight);
        while (st.getWeight()< Constant.ConstantHuman.MIN_WEIGHT || st.getWeight()> Constant.ConstantHuman.MAX_WEIGHT) {
            System.out.print("Weight is between 50 and 300!!!\nPlease enter again: ");
            weight = Float.parseFloat(sc.nextLine());
            st.setWeight(weight);
        }
        System.out.print("Height: ");
        float height = Float.parseFloat(sc.nextLine());
        st.setHeight(height);
        while (st.getHeight()< Constant.ConstantHuman.MIN_HEIGHT || st.getHeight()> Constant.ConstantHuman.MAX_HEIGHT) {
            System.out.print("Height is between 50 and 300!!!\nPlease enter again: ");
            height = Float.parseFloat(sc.nextLine());
            st.setWeight(height);
        }
        System.out.print("Student Id: ");
        String studentId = sc.nextLine();
        st.setStudentId(studentId);
        while (!st.getStudentId().matches(Constant.ConstantStudent.REGEX_STUDENT_ID)) {
            System.out.print("Student id can only be 10 characters and not null!!!\nPlease enter again: ");
            studentId = sc.nextLine();
            st.setStudentId(studentId);
        }
        System.out.print("School: ");
        String school = sc.nextLine();
        st.setSchool(school);
        while (st.getSchool().length() > Constant.ConstantStudent.MAX_SCHOOL && !st.getSchool().isEmpty()) {
            System.out.print("School id less than 200 and not null!!!\nPlease enter again: ");
            school = sc.nextLine();
            st.setStudentId(school);
        }
        System.out.print("Start year: ");
        String startYear = sc.nextLine();
        st.setStartYear(startYear);
        int startYearToInt = Integer.parseInt(startYear);
        while (!st.getStartYear().matches(Constant.ConstantStudent.REGEX_START_YEAR) || startYearToInt < Constant.ConstantStudent.MIN_START_YEAR || st.getStartYear()== null) {
            System.out.print("Start year only be 4 number and less than 1900 and not null!!!\nPlease enter again: ");
            startYear = sc.nextLine();
            st.setStartYear(startYear);
            startYearToInt = Integer.parseInt(startYear);
        }
        System.out.print("Medium Score:");
        float mediumScore = Float.parseFloat(sc.nextLine());
        st.setMediumScore(mediumScore);
        while (st.getMediumScore() < Constant.ConstantStudent.MIN_MEDIUM_SCORE || st.getMediumScore() > Constant.ConstantStudent.MAX_MEDIUM_SCORE) {
            System.out.print("Medium score between 0.0 and 10.0!!!\nPlease enter again: ");
            mediumScore = Float.parseFloat(sc.nextLine());
            st.setMediumScore(mediumScore);
        }System.out.println("======>Update student success!!");
        }catch (Exception e){
            System.out.println("========>Update student failed!!");
        }

        return true;
    }
    public static void updateStudentById(Student[] st){
        Scanner sc = new Scanner(System.in);
        boolean idNotFound = false;
        System.out.print("Enter student code: ");
        String stCode = sc.nextLine();
        for(Student a : st){
            if(a.getStudentId().equals(stCode)){
                idNotFound = true;
                if(updateOneStudent(a)){
                    System.out.println("Update student success!!");
                    System.out.println(a.toString());
                }
            }
        }
        if(!idNotFound){
            System.out.println("----------------------");
            System.out.println("Student ID not found");
            System.out.println("----------------------");
        }
    }
    public static void deleteStudentById(Student[] st){
        Scanner sc = new Scanner(System.in);
        int count =0;
        int location = 0;
        boolean idNotFound = false;
        System.out.print("Enter student code: ");
        String stCode = sc.nextLine();
        for(int i=0; i< st.length; i++){
                if (st[i].getStudentId().equals(stCode)) {
                    idNotFound = true;
                    location = i;
                } else {
                    count++;
                }
        }
        for(int i = location; i< st.length-1; i++){
            st[i]=st[i+1];
        }
        if(count != 0 ){
            System.out.println("Delete student have student code = " + stCode + " succcess!!!");
            System.out.println("Student in list after delete: ");
            for (int i=0; i< st.length-1;i++){
                display(st, i);
            }
        }
        if(!idNotFound){
            System.out.println("----------------------");
            System.out.println("Student ID not found");
            System.out.println("----------------------");
        }
    }
    public static void display(Student[] st, int i) {
        System.out.println("------->>Information of student number " + (i + 1) + ": ");
        System.out.println(st[i].toString());
    }


}