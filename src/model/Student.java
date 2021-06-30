package model;

import java.time.LocalDate;

public class Student {
    String course;
    String highestQualification;
    String name;
    String marks;
    String address;
    LocalDate dateOfBirth;
    String email;
    LocalDate commencementDate;
    String nic;

    public Student(){

    }

    public Student(String course, String highestQualification, String name, String marks, String address, LocalDate dateOfBirth, String email, LocalDate commencementDate, String nic) {
        this.course = course;
        this.highestQualification = highestQualification;
        this.name = name;
        this.marks = marks;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.commencementDate = commencementDate;
        this.nic = nic;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCommencementDate() {
        return commencementDate;
    }

    public void setCommencementDate(LocalDate commencementDate) {
        this.commencementDate = commencementDate;
    }


    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }


}
