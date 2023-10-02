import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import Common.Constant;
import Object.Student;

public class MainDynamic {
    enum outOfTen{
        VERYLOW(1), LOW(2), MEDIUM(3), HIGH(4), VERYHIGH(5), ULTRA(6);
        private int value;
        outOfTen(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student st1 = new Student("congbt1",175f,75f,"qwertyuiop","27/07/2000","qwertyuio1","qwertyuiop","2018",9.6f);   //unit test
        Student st2 = new Student("congb2",175f,75f,"qwertyuiop","29/09/2000","qwertyuio2","qwertyuiop","2018",1.5f);
        Student st3 = new Student("congb3",175f,75f,"qwertyuiop","29/09/2000","qwertyuio3","qwertyuiop","2018",1.5f);
        Student st4 = new Student("congb4",175f,75f,"qwertyuiop","29/09/2000","qwertyuio4","qwertyuiop","2018",1.5f);
        Student st5 = new Student("congb5",175f,75f,"qwertyuiop","29/09/2000","qwertyuio5","qwertyuiop","2018",3.2f);
        Student st6 = new Student("congb6",175f,75f,"qwertyuiop","29/09/2000","qwertyuio6","qwertyuiop","2018",6.5f);
        LinkedList<Student> st = new LinkedList<>();
        st.add(st1);
        st.add(st2);
        st.add(st3);
        st.add(st4);
        st.add(st5);
        st.add(st6);
        while(true){
            System.out.println(
                            "1.Create Student\n" +
                            "2.Find Student By Id\n" +
                            "3.Find All Student\n" +
                            "4.Update Student By Id\n" +
                            "5.Delete Student By Id\n" +
                                    "6.Sort By Academic Ability\n" +
                                    "7.Sort By Medium Score\n" +
                                    "8.Search By Out Of Ten\n" +
                                    "9.Export Txt\n"+
                            "0.Exit");
            System.out.print("Choose a number:");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice < 1 || choice > 9){
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
                    System.out.println("Create Student!!");
                    st = createOneStudent();
                    System.out.println("---------------------------------------");
                    break;
                case 2:
                    System.out.println("---------------------------------------");
                    System.out.println("Find Student By Id!!!");
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
                    System.out.println("Update Student By Id!!");
                    updateStudentById(st);
                    System.out.println("---------------------------------------");
                    break;
                case 5:
                    System.out.println("---------------------------------------");
                    System.out.println("Delete Student By Id!!!");
                    deleteStudentById(st);
                    System.out.println("---------------------------------------");
                    break;
                case 6:
                    System.out.println("---------------------------------------");
                    System.out.println("Sort By Academic Ability!!!");
                    percentOfAcademicAbility(st);
                    System.out.println("---------------------------------------");
                    break;
                case 7:
                    System.out.println("---------------------------------------");
                    System.out.println("Sort By Medium Score!!!");
                    perOfMediumScore(st);
                    System.out.println("---------------------------------------");
                    break;
                case 8:
                    System.out.println("---------------------------------------");
                    System.out.println("Search By Out Of Ten!!!");
                    searchByOutOfTen(st);
                    System.out.println("---------------------------------------");
                    break;
                case 9:
                    System.out.println("---------------------------------------");
                    System.out.println("Export Txt!!!");
                    exportTXT(st);
                    System.out.println("---------------------------------------");
                    break;
            }
        }
    }
    public static LinkedList createOneStudent(){
        Scanner sc = new Scanner(System.in);
        LinkedList<Student> st1 = new LinkedList<>();
        try{
        Student st = new Student();
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
        }
        if(st!= null){
            st1.add(st);
        }
        System.out.println("======>Add student success!!");
        display(st);
        }catch (Exception e){
        System.out.println("========>Add student failed!!");
        }
        return st1;
    }
    public static void findById(LinkedList<Student> st){
        Scanner sc = new Scanner(System.in);
        boolean idNotFound = false;
        System.out.print("Enter student code: ");
        String stCode = sc.nextLine();
        for(Student findById : st){
            if(findById.getStudentId().equals(stCode)){
                idNotFound= true;
                System.out.println("------->>Information of student have code: " + stCode);
                display(findById);
            }
        }
        if(!idNotFound){
            System.out.println("----------------------------------------");
            System.out.println("Student ID not found");
            System.out.println("----------------------------------------");
        }
    }
    public static void findAllStudent(LinkedList<Student> st){
        System.out.println("------->>Information of student : ");
        for(Student searchAll : st){
            System.out.println("------------------------------------------------------------------------------------");
            display(searchAll);
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
        }
        System.out.println("======>Update student success!!");
        display(st);
        }catch (Exception e){
            System.out.println("========>Update student failed!!");
        }
        return true;
    }
    public static void updateStudentById(LinkedList<Student> st){
        Scanner sc = new Scanner(System.in);
        boolean idNotFound = false;
        System.out.print("Enter student code: ");
        String stCode = sc.nextLine();
        for(Student updateSt : st){
            if(updateSt.getStudentId().equals(stCode)){
                idNotFound= true;
                if(updateOneStudent(updateSt)){
                    System.out.println(updateSt.toString());
                }
            }
        }
        if(!idNotFound){
            System.out.println("----------------------------------------");
            System.out.println("Student ID not found");
            System.out.println("----------------------------------------");
        }
    }
    public static void deleteStudentById(LinkedList<Student> st){
        Scanner sc = new Scanner(System.in);
        boolean idNotFound = false;
        System.out.print("Enter student code: ");
        String stCode = sc.nextLine();
        for(Student deleteSt : st){
            if(deleteSt.getStudentId().equals(stCode)){
                idNotFound= true;
                if(st.remove(deleteSt)){
                    System.out.println("Delete student have code "+ stCode + " success!!");
                }else {
                    System.out.println("Delete Failed!!!");
                }
            }
        }
        if(!idNotFound){
            System.out.println("----------------------------------------");
            System.out.println("Student ID not found");
            System.out.println("----------------------------------------");
        }
    }
    public static void percentOfAcademicAbility(LinkedList<Student> st){
        int percentOfAcademicAbility = 0;
        int countVeryLow = 0;
        int countLow = 0;
        int countMedium = 0;
        int countHigh = 0;
        int countVeryHigh = 0;
        int countUltra = 0;
        for (Student check : st) {
            if (check.getMediumScore() < 3) {
                countVeryLow++;
            } else if (check.getMediumScore() < 5) {
                countLow++;
            } else if (check.getMediumScore() < 6.5) {
                countMedium++;
            } else if (check.getMediumScore() < 7.5) {
                countHigh++;
            } else if (check.getMediumScore() < 9) {
                countVeryHigh++;
            } else {
                countUltra++;
            }
        }
        percentOfAcademicAbility = (countVeryLow + countLow + countMedium + countHigh + countVeryHigh + countUltra);
        float percentOfVeryLow = countVeryLow * 100 / percentOfAcademicAbility;
        float percentOfLow = countLow * 100 / percentOfAcademicAbility;
        float percentOfMedium = countMedium * 100 / percentOfAcademicAbility;
        float percentOfHigh = countHigh * 100 / percentOfAcademicAbility;
        float percentOfVeryHigh = countVeryHigh * 100 / percentOfAcademicAbility;
        float percentOfUltra = countUltra * 100 / percentOfAcademicAbility;
        Map<String, Float> percent = new HashMap<>();
        percent.put("Very Low" , percentOfVeryLow);
        percent.put("Low" , percentOfLow);
        percent.put("Medium" , percentOfMedium);
        percent.put("High" , percentOfHigh);
        percent.put("Very High" , percentOfVeryHigh);
        percent.put("Ultra" , percentOfUltra);
//        List<Map.Entry<String, Float>> sortPercent = new ArrayList<>();
//        sortPercent.addAll(percent.entrySet());
//        Collections.sort(sortPercent, new Comparator<Map.Entry<String, Float>>() {
//            @Override
//            public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
//                return o1.getKey().compareTo(o2.getKey());
//            }
//        });
        Map<String, Float> sortPercent = percent.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for(Map.Entry<String, Float> a : sortPercent.entrySet()){
            System.out.println(a.getValue() + " - " + a.getKey());
        }
    }
    public static void perOfMediumScore(LinkedList<Student> sortMediumScore){
        Map<Float, Float> listPerOfMediumScore = new HashMap<>();
        int sum= sortMediumScore.size();
        for(int i=0; i< sortMediumScore.size();i++){
            float perOfMediumScore;
            int count = 1;
            for(int j=i+1 ; j< sortMediumScore.size() -1 ; j++){
                if(sortMediumScore.get(i).getMediumScore() == sortMediumScore.get(j).getMediumScore()){
                    count++;
                }else {
                    break;
                }
            }
            perOfMediumScore = count*100 / sum;
            if(!listPerOfMediumScore.containsKey(sortMediumScore.get(i).getMediumScore())){
                listPerOfMediumScore.put(sortMediumScore.get(i).getMediumScore(), perOfMediumScore);
            }
        }
        for(Map.Entry<Float, Float> entry : listPerOfMediumScore.entrySet()){
            System.out.println(entry.getKey()+": "+ entry.getValue()+"%");
        }
    }
    public static void searchByOutOfTen(LinkedList<Student> st){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Capacity(Low, Very Low, Medium, High, Very High, Ultra): ");
        String oOT = sc.nextLine();
        for(Student searchSt: st){
            if(oOT.trim().replaceAll("\\s+","").toUpperCase().equals(searchSt.getAcademicAbility())){
                System.out.println(searchSt.toString());
            }
        }
    }
    public static void exportTXT(LinkedList<Student> st){
        File op = null;
        ObjectOutputStream oos = null;
        Writer write = null;
        BufferedWriter bw = null;
        try{
            op = new File("D:\\student.txt");
            write = new FileWriter(op);
            bw = new BufferedWriter(write);
            oos= new ObjectOutputStream(new FileOutputStream(op));
            for(Student studentOut: st){
                oos.writeObject(studentOut);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void display(Student st) {
        System.out.println(st.toString());
    }
}

