package model;

import java.time.LocalDate;

public class Expense {

    private String id;
    private String userNic;
    private String expense;
    private String amount;
    private String method;
    private LocalDate date;

    public Expense() {
    }

    public Expense(String id, String userNic, String expense, String amount, String method, LocalDate date) {
        this.id = id;
        this.userNic = userNic;
        this.expense = expense;
        this.amount = amount;
        this.method = method;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserNic() {
        return userNic;
    }

    public void setUserNic(String userNic) {
        this.userNic = userNic;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", userNic='" + userNic + '\'' +
                ", expense='" + expense + '\'' +
                ", amount='" + amount + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
