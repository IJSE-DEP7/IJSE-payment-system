package model;

import java.io.Serializable;

public class CourseTM implements Serializable {

    private String id;
    private String courseName;
    private String courseFee;
    private String regFee;
    private String noOfInstallments;

    public CourseTM() {
    }

    public CourseTM(String id,String courseName, String courseFee, String regFee, String noOfInstallments) {
        this.id=id;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.regFee = regFee;
        this.noOfInstallments = noOfInstallments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(String courseFee) {
        this.courseFee = courseFee;
    }

    public String getRegFee() {
        return regFee;
    }

    public void setRegFee(String regFee) {
        this.regFee = regFee;
    }

    public String getNoOfInstallments() {
        return noOfInstallments;
    }

    public void setNoOfInstallments(String noOfInstallments) {
        this.noOfInstallments = noOfInstallments;
    }

    @Override
    public String toString() {
        return "CourseTM{" +
                "courseName='" + courseName + '\'' +
                ", courseFee='" + courseFee + '\'' +
                ", regFee='" + regFee + '\'' +
                ", noOfInstallments='" + noOfInstallments + '\'' +
                '}';
    }
}
