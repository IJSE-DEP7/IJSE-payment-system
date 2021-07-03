package model;

import java.time.LocalDate;

public class Payment {
    private String studentNic;
    private String userNic;
    private String paymentId;
    private String amount;
    private LocalDate date;
    private String method;

    public Payment() {
    }

    public Payment(String studentNic, String userNic,String paymentId, String amount, LocalDate date, String method) {
        this.studentNic = studentNic;
        this.userNic = userNic;
        this.paymentId=paymentId;
        this.amount = amount;
        this.date = date;
        this.method = method;
    }

    public String getStudentNic() {
        return studentNic;
    }

    public void setStudentNic(String studentNic) {
        this.studentNic = studentNic;
    }

    public String getUserNic() {
        return userNic;
    }

    public void setUserNic(String userNic) {
        this.userNic = userNic;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "studentNic='" + studentNic + '\'' +
                ", userNic='" + userNic + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", amount='" + amount + '\'' +
                ", date=" + date +
                ", method='" + method + '\'' +
                '}';
    }
}
