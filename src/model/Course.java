package model;

public class Course {
    private String id;
    private String name;
    private String fee;
    private String regFee;
    private String numberOfInstallments;

    public Course() {
    }

    public Course(String id, String name, String fee, String regFee, String numberOfInstallments) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.regFee = regFee;
        this.numberOfInstallments = numberOfInstallments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getRegFee() {
        return regFee;
    }

    public void setRegFee(String regFee) {
        this.regFee = regFee;
    }

    public String getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(String numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fee='" + fee + '\'' +
                ", regFee='" + regFee + '\'' +
                ", numberOfInstallments='" + numberOfInstallments + '\'' +
                '}';
    }
}
