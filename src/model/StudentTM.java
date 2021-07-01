package model;

import java.time.LocalDate;

public class StudentTM {
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private LocalDate DOB;

    public StudentTM() {
    }

    public StudentTM(String name, String address, String email, String contactNo, LocalDate DOB) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.DOB = DOB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", DOB='" + DOB + '\'' +
                '}';
    }
}
