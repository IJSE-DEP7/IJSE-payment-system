package model;

import java.time.LocalDate;

public class Payment {
    private String studentNic;
    private String userNic;
    private String paymentId;
    private String payment;
    private String amount;
    private LocalDate date;
    private String method;
    private String recieptAmount;

    public Payment() {
    }
    public Payment(String studentNic, String userNic, String paymentId, String payment, String amount, LocalDate date, String method, String recieptAmount) {
        this.studentNic = studentNic;
        this.userNic = userNic;
        this.paymentId=paymentId;
        this.payment=payment;
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.recieptAmount=recieptAmount;
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

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
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

    public String getRecieptAmount() {
        return recieptAmount;
    }

    public void setRecieptAmount(String recieptAmount) {
        this.recieptAmount = recieptAmount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "studentNic='" + studentNic + '\'' +
                ", userNic='" + userNic + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", payment='" + payment + '\'' +
                ", amount='" + amount + '\'' +
                ", date=" + date +
                ", method='" + method + '\'' +
                ", recieptAmount='" + recieptAmount + '\'' +
                '}';
    }
}
