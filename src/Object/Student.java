package Object;

public class Student extends Human{
    private String studentId;
    private String school;
    private String startYear;
    private float mediumScore;
    enum outOfTen{
        VERYLOW(1), LOW(2), MEDIUM(3), HIGH(4), VERYHIGH(5), ULTRA(6);
        private int value;
        outOfTen(int value){
            this.value = value;
        }
    }
    outOfTen academicAbility;


    public Student(String name, float height, float weight, String address, String birthOfDate, String studentId, String school, String startYear, float mediumScore) {
        super(name, height, weight, address, birthOfDate);
        this.studentId = studentId;
        this.school = school;
        this.startYear = startYear;
        this.mediumScore = mediumScore;
        if(this.mediumScore<3){
            academicAbility = outOfTen.VERYLOW;
        }else if(this.mediumScore <5){
            academicAbility = outOfTen.LOW;
        }else if(this.mediumScore <6.5){
            academicAbility = outOfTen.MEDIUM;
        }else if(this.mediumScore <7.5){
            academicAbility = outOfTen.HIGH;
        }else if(this.mediumScore <9){
            academicAbility = outOfTen.VERYHIGH;
        }else{
            academicAbility = outOfTen.ULTRA;
        }
    }

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSchool() {
        return school;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public float getMediumScore() {
        return mediumScore;
    }


    public void setMediumScore(float mediumScore) {
        this.mediumScore = mediumScore;
        if(this.mediumScore<3){
            academicAbility = outOfTen.VERYLOW;
        }else if(this.mediumScore <5){
            academicAbility = outOfTen.LOW;
        }else if(this.mediumScore <6.5){
            academicAbility = outOfTen.MEDIUM;
        }else if(this.mediumScore <7.5){
            academicAbility = outOfTen.HIGH;
        }else if(this.mediumScore <9){
            academicAbility = outOfTen.VERYHIGH;
        }else{
            academicAbility = outOfTen.ULTRA;
        }
    }

    public String getAcademicAbility() {
        return academicAbility.toString();
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString(){
        super.toString();
        StringBuilder display = new StringBuilder();
        display.append("---------------------------------------\n");
        display.append("Id: "+ this.getId()+"\n");
        display.append("Student Id: "+ this.getStudentId()+"\n");
        display.append("Student School: "+ this.getSchool()+"\n");
        display.append("Start Year: "+ this.getStartYear()+"\n");
        display.append("Medium Score: "+ this.getMediumScore()+"\n");
        display.append("Out of Ten: "+ this.academicAbility.toString());
        display.append("\n---------------------------------------");
        return display.toString();
    }
}
