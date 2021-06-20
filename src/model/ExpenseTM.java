package model;

public class ExpenseTM {
    private String expense;
    private String amount;
    private String date;
    private String transactionMethod;
    private String name;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransactionMethod() {
        return transactionMethod;
    }

    public void setTransactionMethod(String transactionMethod) {
        this.transactionMethod = transactionMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExpenseTM{" +
                "expense='" + expense + '\'' +
                ", amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                ", transactionMethod='" + transactionMethod + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
