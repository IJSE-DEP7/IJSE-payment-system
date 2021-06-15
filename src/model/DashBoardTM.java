package model;

import java.io.Serializable;

public class DashBoardTM implements Serializable {

    private String course;
    private String newRegistrations;
    private String numberOfPayments;
    private String totalIncome;

    public DashBoardTM(){

    }

    public DashBoardTM(String course, String newRegistrations, String numberOfPayments, String totalIncome){
        this.course=course;
        this.newRegistrations=newRegistrations;
        this.numberOfPayments=numberOfPayments;
        this.totalIncome=totalIncome;

    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getNewRegistrations() {
        return newRegistrations;
    }

    public void setNewRegistrations(String newRegistrations) {
        this.newRegistrations = newRegistrations;
    }

    public String getNumberOfPayments() {
        return numberOfPayments;
    }

    public void setNumberOfPayments(String numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }

    @Override
    public String toString() {
        return "DashBoardTM{" +
                "course='" + course + '\'' +
                ", newRegistrations='" + newRegistrations + '\'' +
                ", numberOfPayments='" + numberOfPayments + '\'' +
                ", totalIncome='" + totalIncome + '\'' +
                '}';
    }
}
