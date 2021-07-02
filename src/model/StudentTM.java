package model;

import java.time.LocalDate;

public class StudentTM {
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private String nic;

    public StudentTM() {
    }

    public StudentTM(String name, String address, String email, String contactNo, String nic) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.nic = nic;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
