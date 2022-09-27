package org.ar.miguel.FILES.E18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Persona {
    private String adress;
    private String livingPlace;
    private int members;
    private String name;
    private int age;
    private String sex;
    private String studies;
    private String status;

    public Persona() {
    }

    public Persona(String adress, String livingPlace, int members, String name, int age, String sex, String studies, String status) {
        this.adress = adress;
        this.livingPlace = livingPlace;
        this.members = members;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.studies = studies;
        this.status = status;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLivingPlace() {
        return livingPlace;
    }

    public void setLivingPlace(String livingPlace) {
        this.livingPlace = livingPlace;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "adress='" + adress + '\'' +
                ", livingPlace='" + livingPlace + '\'' +
                ", members=" + members +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", studies='" + studies + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
