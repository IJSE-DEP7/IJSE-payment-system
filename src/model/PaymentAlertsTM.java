package model;

import java.io.Serializable;

public class PaymentAlertsTM implements Serializable {
    private String courseName;
    private String studentName;
    private String contactNo;
    private String dueDate;
    private String amount;

    /*public PaymentAlertsTM(){

    }*/

    /*public PaymentAlertsTM(String courseName,String studentName,String contactNo,String dueDate,String amount){
        this.courseName=courseName;
        this.studentName=studentName;
        this.contactNo=contactNo;
        this.dueDate=dueDate;
        this.amount=amount;
    }*/

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentAlertsTM{" +
                "courseName='" + courseName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
