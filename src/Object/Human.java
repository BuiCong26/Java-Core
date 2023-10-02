package Object;

import java.io.Serializable;

public class Human implements Serializable {
    private static int initId = 1;
    private int id;
    private String name;
    private float height;
    private float weight;
    private String address;
    private String birthOfDate;

    public Human(String name, float height, float weight, String address, String birthOfDate) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.address = address;
        this.birthOfDate = birthOfDate;
        this.id = initId++;
    }

    public Human() {
        this.id = initId++;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(String birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    @Override
    public String toString(){
        StringBuilder display = new StringBuilder();
        display.append("---------------------------------------\n");
        display.append("Name: "+ this.getName()+"\n");
        display.append("BirthOfDate: "+ this.getBirthOfDate()+"\n");
        display.append("Address: "+ this.getAddress()+"\n");
        display.append("Height: "+ this.getHeight()+"\n");
        display.append("Weight: "+ this.getWeight()+"\n");
        display.append("\n---------------------------------------");
        return display.toString();
    }
}
