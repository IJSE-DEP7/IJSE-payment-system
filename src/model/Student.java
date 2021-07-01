package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
    String course;
    String highestQualification;
    String name;
    String marks;
    String address;
    LocalDate dateOfBirth;
    String email;
    String nic;
    String contactNo;


    public Student(){

    }

    public Student(String course, String highestQualification, String name, String marks, String address, LocalDate dateOfBirth, String email, String nic,String contactNo) {
        this.course = course;
        this.highestQualification = highestQualification;
        this.name = name;
        this.marks = marks;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.nic = nic;
        this.contactNo = contactNo;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course='" + course + '\'' +
                ", highestQualification='" + highestQualification + '\'' +
                ", name='" + name + '\'' +
                ", marks='" + marks + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", nic='" + nic + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
